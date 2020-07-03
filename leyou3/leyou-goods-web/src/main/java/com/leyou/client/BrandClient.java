package com.leyou.client;

import com.leyou.item.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author HackerStar
 * @create 2020-06-25 15:38
 */
@FeignClient("item-service")
public interface BrandClient extends BrandApi {
}
