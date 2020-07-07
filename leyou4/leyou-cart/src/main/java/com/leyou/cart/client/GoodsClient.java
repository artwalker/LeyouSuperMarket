package com.leyou.cart.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author HackerStar
 * @create 2020-07-07 09:50
 */
@FeignClient("item-service")
public interface GoodsClient extends GoodsApi {
}
