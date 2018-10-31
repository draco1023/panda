package com.yukong.panda.user.controller;

import com.yukong.panda.common.util.ApiResult;
import com.yukong.panda.common.util.UserUtil;
import com.yukong.panda.user.dto.SysResourceTree;
import com.yukong.panda.user.entity.SysResource;
import com.yukong.panda.user.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: yukong
 * @date: 2018/10/17 13:22
 * @description: 资源管理
 */
@RestController
@RequestMapping("/resource")
public class SysResourceController {

    @Autowired
    private SysResourceService sysResourceService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 获取当前用户的菜单树
     * @return
     */
    @GetMapping("/menu/tree")
    public ApiResult<List<SysResourceTree>> getMenuTree(){
        List<String> roleCodes = UserUtil.getRoles(request);
        return new ApiResult<>(sysResourceService.getMenuTreeByRoleCodes(roleCodes));
    }

    /**
     * 获取所有的资源树
     * @return
     */
    @GetMapping("/tree")
    public ApiResult<List<SysResourceTree>> getAllResourceTree(){
        return new ApiResult<>(sysResourceService.getAllResourceTree());
    }

    @PostMapping
    public ApiResult saveMenu(@RequestBody SysResource sysResource) {
        return new ApiResult(sysResourceService.save(sysResource));
    }

    @PutMapping
    public ApiResult updateMenu(@RequestBody SysResource sysResource) {
        return new ApiResult(sysResourceService.updateById((sysResource)));
    }

    @GetMapping("/id/{id}")
    public ApiResult<SysResource> getById(@PathVariable("id") Integer id){
        return new ApiResult<>(sysResourceService.getById(id));
    }

    
    @DeleteMapping("/id/{id}")
    public ApiResult<Boolean> deleteResource(@PathVariable("id") Integer id) {
        return new ApiResult<>(sysResourceService.deleteResource(id));
    }

}
