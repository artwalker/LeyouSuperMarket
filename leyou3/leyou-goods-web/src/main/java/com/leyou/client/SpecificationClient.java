package com.leyou.client;

import com.leyou.item.api.SpecificationApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author HackerStar
 * @create 2020-06-25 15:39
 */
@FeignClient("item-service")
public interface SpecificationClient extends SpecificationApi {
}
