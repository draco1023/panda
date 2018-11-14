package com.yukong.panda.auth.handler;

import com.yukong.panda.common.constants.MqQueueNameConstant;
import com.yukong.panda.common.dto.SysLogDTO;
import com.yukong.panda.common.enums.OperationStatusEnum;
import com.yukong.panda.common.enums.SysLogTypeEnum;
import com.yukong.panda.common.util.UrlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
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
public class PandaAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        super.onAuthenticationFailure(request, response, exception);
        String username = request.getParameter("username");
        log.info("登录失败:{}", username);
        SysLogDTO sysLogDTO = new SysLogDTO();
        sysLogDTO
                .setCreateBy(username)
                .setRequestUri(request.getRequestURI())
                .setUserAgent(UrlUtil.getRemoteHost(request))
                .setType(SysLogTypeEnum.LOGIN.getCode())
                .setStatus(OperationStatusEnum.FAIL.getCode());
        rabbitTemplate.convertAndSend(MqQueueNameConstant.SYS_LOG_QUEUE, sysLogDTO);

    }
}
