package com.yukong.panda.auth.handler;

import com.yukong.panda.common.constants.MqQueueNameConstant;
import com.yukong.panda.common.dto.SysLogDTO;
import com.yukong.panda.common.enums.OperationStatusEnum;
import com.yukong.panda.common.enums.SysLogTypeEnum;
import com.yukong.panda.common.util.UrlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: yukong
 * @date: 2018/11/14 20:08
 */
@Slf4j
@Component
public class PandaAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private RabbitTemplate rabbitTemplate;




    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        super.onAuthenticationSuccess(request, response, authentication);
        log.info("登录成功:{}", authentication.getName());
        SysLogDTO sysLogDTO = new SysLogDTO();
        sysLogDTO
                .setCreateBy(authentication.getName())
                .setRequestUri(request.getRequestURI())
                .setUserAgent(UrlUtil.getRemoteHost(request))
                .setType(SysLogTypeEnum.LOGIN.getCode())
                .setStatus(OperationStatusEnum.SUCCESS.getCode());
        rabbitTemplate.convertAndSend(MqQueueNameConstant.SYS_LOG_QUEUE, sysLogDTO);
    }
}
