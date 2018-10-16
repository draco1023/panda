package com.yukong.panda.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yukong.panda.user.entity.SysUser;

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
    SysUser loadUserByUsername(String username);

}
