package com.leyou.auth.client;

import com.leyou.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author HackerStar
 * @create 2020-07-03 10:13
 */
@FeignClient(value = "user-service")
public interface UserClient extends UserApi {
}
