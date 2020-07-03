package com.leyou.item.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-06-20 10:37
 */

@RequestMapping("category")
public interface CategoryApi {
    @GetMapping("names")
    List<String> queryNamesByIds(@RequestParam("ids")List<Long> ids);
}
