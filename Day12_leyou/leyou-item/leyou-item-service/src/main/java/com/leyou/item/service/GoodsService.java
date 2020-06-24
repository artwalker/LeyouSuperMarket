package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.SpuDetail;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-06-15 16:02
 */
public interface GoodsService {

    void saveGoods(SpuBo spuBo);

    PageResult<SpuBo> querySpuByPage(Integer page, Integer rows, Boolean saleable, String key);

    SpuDetail querySpuDetailBySpuId(Long spuId);

    List<Sku> querySkusBySpuId(Long spuId);
}
