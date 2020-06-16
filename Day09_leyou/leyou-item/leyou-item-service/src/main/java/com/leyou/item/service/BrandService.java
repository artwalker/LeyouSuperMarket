package com.leyou.item.service;

import com.leyou.item.pojo.Brand;
import com.leyou.common.pojo.PageResult;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-06-09 23:14
 */
public interface BrandService {
    PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);

    /**
     * 新增品牌
     * @param brand
     * @param cids
     */
    void saveBrand(Brand brand, List<Long> cids);
}
