package com.leyou.upload.service.impl;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.upload.service.UploadService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author HackerStar
 * @create 2020-06-11 09:42
 */
@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private FastFileStorageClient storageClient;

    private static final List<String> CONTENT_TYPES = Arrays.asList("image/jpeg", "image/gif", "image/png");

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadService.class);

    @Override
    public String upload(MultipartFile file) {
        // 校验文件的类型
        String originalFilename = file.getOriginalFilename();
        try {
            // 校验文件的内容
            String contentType = file.getContentType();
            if (!CONTENT_TYPES.contains(contentType)) {
                // 文件类型不合法，直接返回null
                LOGGER.info("文件内容不合法：{}", originalFilename);
                return null;
            }
            // 保存到服务器
//            file.transferTo(new File("/Users/XinxingWang/Desktop/upload/"+originalFilename));
            String ext = StringUtils.substringAfterLast(originalFilename, ".");
            StorePath storePath = this.storageClient.uploadFile(file.getInputStream(), file.getSize(), ext, null);
            // 生成url地址，返回
            return "http://image.leyou.com/" + storePath.getFullPath();
        } catch (IOException e) {
            LOGGER.info("服务器内部错误：{}", originalFilename);
            e.printStackTrace();
        }
        return null;
    }
}
