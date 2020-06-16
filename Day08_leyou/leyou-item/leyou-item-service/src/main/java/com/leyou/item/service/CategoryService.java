package com.leyou.item.service;

import com.leyou.item.pojo.Category;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-06-09 21:16
 */
public interface CategoryService {
    List<Category> queryCategoriesByPid(Long pid);
}
