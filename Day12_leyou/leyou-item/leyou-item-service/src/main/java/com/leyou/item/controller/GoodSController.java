package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.SpuDetail;
import com.leyou.item.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-06-15 16:01
 */
@Controller
@RequestMapping("goods")
public class GoodSController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/spu/page")
    public ResponseEntity<PageResult<SpuBo>> querySpuByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "2") Integer rows,
            @RequestParam(value = "saleable", required = false) Boolean saleable,
            @RequestParam(value = "key", required = false) String key
    ) {
        PageResult<SpuBo> pageResult = this.goodsService.querySpuByPage(page, rows, saleable, key);
        if (CollectionUtils.isEmpty(pageResult.getItems())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pageResult);
    }

    @PostMapping("goods")
    public ResponseEntity<Void> saveGoods(@RequestBody SpuBo spuBo) {
        this.goodsService.saveGoods(spuBo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 根据主键查询spuDetail
     * @param spuId
     * @return
     */
    @GetMapping("spu/detail/{spuId}")
    public ResponseEntity<SpuDetail> querySpuDetailBySpuId(@PathVariable("spuId")Long spuId){
        SpuDetail spuDetail = this.goodsService.querySpuDetailBySpuId(spuId);
        if (spuDetail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(spuDetail);
    }

    /**
     * 根据spuid查询所有的sku
     * @param spuId
     * @return
     */
    @GetMapping("sku/list")
    public ResponseEntity<List<Sku>> querySkusBySpuId(@RequestParam("id")Long spuId){
        List<Sku> skus = this.goodsService.querySkusBySpuId(spuId);
        if (CollectionUtils.isEmpty(skus)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(skus);
    }
}
