package com.yukong.panda.auth.service.fallback;

import com.yukong.panda.auth.service.SysUserService;
import com.yukong.panda.common.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yukong
 * @since 2018-10-08
 */
@Slf4j
@Service
public class SysUserServiceFallback implements SysUserService {

    @Override
    public SysUser loadUserByUsername(String username) {
        log.error("调用{}方法异常，参数：{}", "loadUserByUsername", username);
       return null;
    }
}
