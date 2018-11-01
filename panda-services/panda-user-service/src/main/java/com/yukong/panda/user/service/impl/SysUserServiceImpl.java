package com.yukong.panda.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Strings;
import com.yukong.panda.common.vo.SysUserVo;
import com.yukong.panda.user.model.dto.SysUserInfoDTO;
import com.yukong.panda.user.model.entity.SysResource;
import com.yukong.panda.user.model.entity.SysUser;
import com.yukong.panda.user.mapper.SysUserMapper;
import com.yukong.panda.user.service.SysResourceService;
import com.yukong.panda.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yukong
 * @since 2018-10-08
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysResourceService sysResourceService;

    @Override
    public SysUserVo loadUserByUsername(String username) {
        return sysUserMapper.loadUserByUsername(username);
    }

    @Override
    public SysUserInfoDTO getUserInfo(Integer userId, List<String> roles) {
        SysUserInfoDTO sysUserInfoDTO = new SysUserInfoDTO();
        SysUser sysUser = sysUserMapper.selectById(userId);
        sysUserInfoDTO.setSysUser(sysUser);
        sysUserInfoDTO.setRoles(roles);
        Set<SysResource> sysResources = sysResourceService.getSysResourceRoleCodes(roles);

        List<String> permissions = sysResources.stream()
                .map(SysResource::getPermission)
                .collect(Collectors.toList())
                .stream()
                .filter(permission ->
                     Strings.isNullOrEmpty(permission)
                ).collect(Collectors.toList());
        sysUserInfoDTO.setPermissions(permissions);
        return sysUserInfoDTO;
    }
}
