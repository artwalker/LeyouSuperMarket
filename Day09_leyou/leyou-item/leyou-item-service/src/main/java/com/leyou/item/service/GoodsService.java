package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;

/**
 * @author HackerStar
 * @create 2020-06-15 16:02
 */
public interface GoodsService {
    PageResult<SpuBo> querySpuBoByPage(String key, Boolean saleable, Integer page, Integer rows);
}
