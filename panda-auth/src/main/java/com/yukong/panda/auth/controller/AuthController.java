package com.yukong.panda.auth.controller;

import com.yukong.panda.common.constants.CommonConstants;
import com.yukong.panda.common.constants.SecurityConstants;
import com.yukong.panda.common.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;
import java.util.Collection;

/**
 * @author yukong
 * @date 2018年10月31日13:23:22
 */
@RestController
public class AuthController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private RedisTokenStore redisTokenStore;

    @PutMapping("/token")
    public ApiResult<Boolean> removeAccessToken(@RequestParam String accessToken) {
        return new ApiResult<>(consumerTokenServices.revokeToken(accessToken));
    }

    @GetMapping("/token")
    public ApiResult<Collection<OAuth2AccessToken>> readAllToken() {
        return new ApiResult<>(redisTokenStore.findTokensByClientId(SecurityConstants.CLOUD));
    }

}
