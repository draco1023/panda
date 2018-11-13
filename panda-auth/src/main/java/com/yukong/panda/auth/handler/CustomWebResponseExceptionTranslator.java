package com.yukong.panda.auth.handler;

import com.yukong.panda.auth.exception.CustomOauth2Exception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * @author: yukong
 * @date: 2018/10/12 10:25
 * @description: oauth2异常处理器
 */

@Component("customWebResponseExceptionTranslator")
@Slf4j
public class CustomWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
        log.error(e.getStackTrace().toString());
        if (!(e instanceof OAuth2Exception)) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new CustomOauth2Exception(e.getMessage()));
        }
        OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
        return ResponseEntity
                .status(oAuth2Exception.getHttpErrorCode())
                .body(new CustomOauth2Exception(oAuth2Exception.getMessage()));
    }
}
