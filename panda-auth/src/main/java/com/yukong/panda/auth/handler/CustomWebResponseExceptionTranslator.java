package com.yukong.panda.auth.handler;

import com.yukong.panda.auth.exception.CustomOauth2Exception;
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
public class CustomWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {

        oauth2exception oauth2exception = (oauth2exception) e;
        return responseentity
                .status(oauth2exception.gethttperrorcode())
                .body(new customoauth2exception(oauth2exception.getmessage()));
    }
}
