package com.yukong.panda.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yukong.panda.common.vo.SysUserVo;
import com.yukong.panda.user.dto.SysUserInfoDTO;
import com.yukong.panda.user.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author yukong
 * @since 2018-10-08
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    SysUserVo loadUserByUsername(String username);

    /**
     * 根据userid 与角色信息返回用户详细信息
     * @param userId
     * @param roles
     * @return
     */
    SysUserInfoDTO getUserInfo(Integer userId, List<String> roles);
}
