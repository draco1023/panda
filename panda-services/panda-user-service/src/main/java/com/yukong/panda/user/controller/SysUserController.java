package com.yukong.panda.user.controller;

import com.yukong.panda.common.util.ApiResult;
import com.yukong.panda.common.util.UserUtil;
import com.yukong.panda.common.vo.SysUserVo;
import com.yukong.panda.user.model.dto.SysUserInfoDTO;
import com.yukong.panda.user.model.entity.SysUser;
import com.yukong.panda.user.model.query.SysRoleQuery;
import com.yukong.panda.user.model.query.SysUserVoQuery;
import com.yukong.panda.user.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/page")
    public ApiResult<SysUserVoQuery> pageByQuery(SysUserVoQuery query){
        return new ApiResult<>(sysUserService.pageUserVoByQuery(query));
    }

    @PostMapping
    public ApiResult<Boolean> save(@RequestBody SysUserVo sysUserVo){
        return new ApiResult<>(sysUserService.save(sysUserVo));
    }

    @PutMapping
    public ApiResult<Boolean> update(@RequestBody SysUserVo sysUserVo){
        return new ApiResult<>(sysUserService.update(sysUserVo));
    }

    @DeleteMapping("/id/{id}")
    public ApiResult<Boolean> delete(@PathVariable("id") Integer id){
        return new ApiResult<>(sysUserService.delete(id));
    }



}
