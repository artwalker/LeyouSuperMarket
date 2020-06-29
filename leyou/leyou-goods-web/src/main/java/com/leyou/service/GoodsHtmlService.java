package com.leyou.service;

import com.leyou.utils.ThreadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author HackerStar
 * @create 2020-06-26 15:53
 */
@Service
public class GoodsHtmlService {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TemplateEngine templateEngine;

    private static final Logger LOGGER  = LoggerFactory.getLogger(GoodsHtmlService.class);

    /**
     * 创建html页面
     *
     * @param spuId
     * @throws Exception
     */
    public void createHtml(Long spuId) {
        PrintWriter writer = null;
        try {
            // 获取页面数据
            Map<String, Object> spuMao =  this.goodsService.loadData(spuId);
            // 创建thymeleaf上下文对象
            Context context = new Context();
            // 把数据放入上下文对象
            context.setVariables(spuMao);
            // 创建输出流
            // 创建输出流
            File file = new File("/usr/local/var/www/item/" + spuId + ".html");
            writer = new PrintWriter(file);
            // 执行页面静态化方法
            templateEngine.process("item", context, writer);
        } catch (Exception e) {
            LOGGER.error("页面静态化出错: {}, " + e, spuId);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * 新建线程处理页面静态化
     * @param spuId
     */
    public void asyncExcute(Long spuId) {
        ThreadUtils.execute(()->createHtml(spuId));
        /*ThreadUtils.execute(new Runnable() {
            @Override
            public void run() {
                createHtml(spuId);
            }
        });*/
    }

    public void deleteHtml(Long id) {
        File file = new File("/usr/local/var/www/item/", id + ".html");
        file.deleteOnExit();
    }
}
