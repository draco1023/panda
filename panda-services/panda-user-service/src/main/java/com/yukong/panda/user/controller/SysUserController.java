package com.yukong.panda.user.controller;

import com.yukong.panda.common.util.ApiResult;
import com.yukong.panda.common.util.UserUtil;
import com.yukong.panda.common.vo.SysUserVo;
import com.yukong.panda.user.model.dto.SysUserInfoDTO;
import com.yukong.panda.user.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: yukong
 * @date: 2018/10/9 16:41
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/info")
    public ApiResult<SysUserInfoDTO> getInfo(){
        Integer userId =UserUtil.getUserId(request);
        List<String> roles =UserUtil.getRoles(request);
        return new ApiResult<>(sysUserService.getUserInfo(userId, roles));
    }

    @GetMapping("/loadUserByUsername/{username}")
    public SysUserVo loadUserByUsername(@PathVariable(value = "username") String username){
        return sysUserService.loadUserByUsername(username);
    }

    @GetMapping("/roles")
    public ApiResult<List<String>> getRoles(){
        return new ApiResult<>(UserUtil.getRoles(request));
    }

}
