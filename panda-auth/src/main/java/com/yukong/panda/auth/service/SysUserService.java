package com.yukong.panda.auth.service;

import com.yukong.panda.auth.service.fallback.SysUserServiceFallback;
import com.yukong.panda.common.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 * feign 调用服务
 * </p>
 *
 * @author yukong
 * @since 2018-10-08
 */
@FeignClient(name = "panda-user-service", fallback = SysUserServiceFallback.class)
public interface SysUserService {

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    @GetMapping("/loadUserByUsername/{username}")
    SysUser loadUserByUsername(@PathVariable(value = "username") String username);

}
