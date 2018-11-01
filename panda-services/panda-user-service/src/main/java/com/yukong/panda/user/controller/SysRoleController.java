package com.yukong.panda.user.controller;

import com.yukong.panda.common.util.ApiResult;
import com.yukong.panda.user.model.dto.SysRoleDTO;
import com.yukong.panda.user.model.entity.SysRole;
import com.yukong.panda.user.model.query.SysRoleQuery;
import com.yukong.panda.user.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yukong
 * @date 2018年11月01日15:15:54
 */
@RestController
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping
    public ApiResult<Boolean> save(@RequestBody SysRoleDTO sysRoleDTO){
        return new ApiResult<>(sysRoleService.save(sysRoleDTO));
    }

    @PutMapping
    public ApiResult<Boolean> update(@RequestBody SysRoleDTO sysRoleDTO){
        return new ApiResult<>(sysRoleService.updateById(sysRoleDTO));
    }


    @DeleteMapping("/{id}")
    public ApiResult<Boolean> delete(@PathVariable("id") Integer id){
        return new ApiResult<>(sysRoleService.deleteById(id));
    }

    @GetMapping("/{id}")
    public ApiResult<SysRoleDTO> getSysRoleInfo(@PathVariable("id") Integer id){
        return new ApiResult<>(sysRoleService.getRoleInfoWithResourceById(id));
    }

    @GetMapping("/page")
    public ApiResult<SysRoleQuery> pageByQuery(SysRoleQuery sysRoleQuery){
        return new ApiResult<>(sysRoleService.pageByQuery(sysRoleQuery));
    }
}
