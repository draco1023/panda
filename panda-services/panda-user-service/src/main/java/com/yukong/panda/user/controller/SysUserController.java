package com.yukong.panda.user.controller;

import com.yukong.panda.user.entity.SysUser;
import com.yukong.panda.user.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yukong
 * @date: 2018/10/9 16:41
 * @description:
 */
@Slf4j
@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/loadUserByUsername/{username}")
    public SysUser loadUserByUsername(@PathVariable(value = "username") String username){
        return sysUserService.loadUserByUsername(username);
    }

}
