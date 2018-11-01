package com.yukong.panda.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yukong.panda.common.vo.SysUserVo;
import com.yukong.panda.user.model.entity.SysUser;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yukong
 * @since 2018-10-08
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户名查询用户信息（包括角色信息）
     * @param username 用户名
     * @return
     */
    SysUserVo loadUserByUsername(String username);

}
