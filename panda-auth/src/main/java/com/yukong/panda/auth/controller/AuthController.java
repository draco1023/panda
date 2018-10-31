package com.yukong.panda.auth.controller;

import com.yukong.panda.common.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;

/**
 * @author yukong
 * @date 2018年10月31日13:23:22
 */
@RestController
public class AuthController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @PutMapping("/token")
    public ApiResult<Boolean> removeAccessToken(@RequestParam String accessToken) {
        return new ApiResult<>(consumerTokenServices.revokeToken(accessToken));
    }

}
