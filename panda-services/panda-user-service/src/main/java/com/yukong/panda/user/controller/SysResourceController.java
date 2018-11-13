package com.yukong.panda.user.controller;

import com.yukong.panda.common.util.ApiResult;
import com.yukong.panda.common.util.UserUtil;
import com.yukong.panda.user.model.dto.SysResourceTree;
import com.yukong.panda.user.model.entity.SysResource;
import com.yukong.panda.user.service.SysResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "资源controller", tags = {"资源操作接口"})
public class SysResourceController {

    @Autowired
    private SysResourceService sysResourceService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 获取当前用户的菜单树
     * @return
     */
    @ApiOperation(value = "获取当前用户的菜单树", notes = "根据token查询当前用户权限的菜单树", httpMethod = "GET")
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
    @ApiOperation(value = "获取所有菜单的树", notes = "获取所有菜单的树", httpMethod = "GET")
    public ApiResult<List<SysResourceTree>> getAllResourceTree(){
        return new ApiResult<>(sysResourceService.getAllResourceTree());
    }

    @ApiOperation(value = "添加资源信息", notes = "添加资源信息", httpMethod = "POST")
    @ApiImplicitParam(name = "sysResource", value = "资源信息", required = true, dataType = "SysResource")
    @PostMapping
    public ApiResult saveMenu(@RequestBody SysResource sysResource) {
        return new ApiResult(sysResourceService.save(sysResource));
    }

    @ApiOperation(value = "修改资源信息", notes = "修改资源信息", httpMethod = "PUT")
    @ApiImplicitParam(name = "sysResource", value = "资源信息", required = true, dataType = "SysResource")
    @PutMapping
    public ApiResult updateMenu(@RequestBody SysResource sysResource) {
        return new ApiResult(sysResourceService.updateById((sysResource)));
    }

    @ApiOperation(value = "查询资源信息", notes = "根据id查询资源信息", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "资源id", required = true, dataType = "integer")
    @GetMapping("/id/{id}")
    public ApiResult<SysResource> getById(@PathVariable("id") Integer id){
        return new ApiResult<>(sysResourceService.getById(id));
    }


    @ApiOperation(value = "删除资源信息", notes = "根据id删除资源信息", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "资源id", required = true, dataType = "integer")
    @DeleteMapping("/id/{id}")
    public ApiResult<Boolean> deleteResource(@PathVariable("id") Integer id) {
        return new ApiResult<>(sysResourceService.deleteResource(id));
    }

}
