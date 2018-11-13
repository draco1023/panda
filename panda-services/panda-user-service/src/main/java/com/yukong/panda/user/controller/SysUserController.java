package com.yukong.panda.user.controller;

import com.yukong.panda.common.util.ApiResult;
import com.yukong.panda.common.util.UserUtil;
import com.yukong.panda.common.vo.SysUserVo;
import com.yukong.panda.user.model.dto.SysUserInfoDTO;
import com.yukong.panda.user.model.entity.SysUser;
import com.yukong.panda.user.model.query.SysRoleQuery;
import com.yukong.panda.user.model.query.SysUserVoQuery;
import com.yukong.panda.user.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "用户controller", tags = {"用户操作接口"})
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private HttpServletRequest request;

    @ApiOperation(value = "获取用户信息", notes = "用户详细信息，附带角色信息，权限信息", httpMethod = "GET")
    @GetMapping("/info")
    public ApiResult<SysUserInfoDTO> getInfo(){
        Integer userId =UserUtil.getUserId(request);
        List<String> roles =UserUtil.getRoles(request);
        return new ApiResult<>(sysUserService.getUserInfo(userId, roles));
    }

    @ApiOperation(value = "获取用户信息", notes = "用户详细信息，附带角色信息，权限信息", httpMethod = "GET")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string")
    @GetMapping("/loadUserByUsername/{username}")
    public SysUserVo loadUserByUsername(@PathVariable(value = "username") String username){
        return sysUserService.loadUserByUsername(username);
    }

    @ApiOperation(value = "获取用户角色信息", notes = "根据token获取用户角色信息", httpMethod = "GET")
    @GetMapping("/roles")
    public ApiResult<List<String>> getRoles(){
        return new ApiResult<>(UserUtil.getRoles(request));
    }

    @ApiOperation(value = "获取用户信息 分页查询", notes = "用户信息分页查询", httpMethod = "GET")
    @ApiImplicitParam(name = "query", value = "用户信息查询条件", required = false, dataType = "SysUserVoQuery")
    @GetMapping("/page")
    public ApiResult<SysUserVoQuery> pageByQuery(SysUserVoQuery query){
        return new ApiResult<>(sysUserService.pageUserVoByQuery(query));
    }

    @ApiOperation(value = "添加用户", notes = "添加用户信息  带角色信息", httpMethod = "POST")
    @ApiImplicitParam(name = "sysUserVo", value = "用户信息", required = true, dataType = "SysUserVo")
    @PostMapping
    public ApiResult<Boolean> save(@RequestBody SysUserVo sysUserVo){
        return new ApiResult<>(sysUserService.save(sysUserVo));
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息 带角色信息", httpMethod = "PUT")
    @ApiImplicitParam(name = "sysUserVo", value = "用户信息", required = true, dataType = "SysUserVo")
    @PutMapping
    public ApiResult<Boolean> update(@RequestBody SysUserVo sysUserVo){
        return new ApiResult<>(sysUserService.update(sysUserVo));
    }

    @ApiOperation(value = "删除用户信息", notes = "删除用户信息", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "integer")
    @DeleteMapping("/id/{id}")
    public ApiResult<Boolean> delete(@PathVariable("id") Integer id){
        return new ApiResult<>(sysUserService.delete(id));
    }

    @ApiOperation(value = "主键查询用户信息", notes = "查询用户信息", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "integer")
    @GetMapping("/id/{id}")
    public ApiResult<SysUser> get(@PathVariable("id") Integer id){
        return new ApiResult<>(sysUserService.getById(id));
    }






}
