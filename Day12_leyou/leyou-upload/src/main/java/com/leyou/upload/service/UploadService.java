package com.leyou.upload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author HackerStar
 * @create 2020-06-11 09:41
 */
public interface UploadService {
    String upload(MultipartFile file);
}
