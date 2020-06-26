package com.leyou.item.api;

import com.leyou.item.pojo.Brand;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-06-20 10:37
 */
@RequestMapping("brand")
public interface BrandApi {
    @GetMapping("{id}")
    Brand queryBrandById(@PathVariable("id") Long id);
}
