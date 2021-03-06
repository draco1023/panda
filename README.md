
[![](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/YuKongEr/panda)
[![](https://img.shields.io/badge/release-v1.0-brightgreen.svg
)](https://github.com/YuKongEr/panda)
[![](https://img.shields.io/badge/springboot-%3E%3D2.0-blue.svg
)](https://github.com/YuKongEr/panda)[![](https://img.shields.io/badge/springcloud-Finchley.SR1-blue.svg
)](https://github.com/YuKongEr/panda)

## 介绍
- panda-server 服务注册中心
- panda-auth  oauth2 认证服务器 提供token
- panda-common 公共模块集合
- panda-config-server 配置中心服务器
- panda-gateway 统一网关，提供动态路由 同时也是oauth2的资源服务器
- panda-service 业务模块集合
  - panda-user-service 统一用户管理模块
  - panda-gen-service 代码生成器模块
    

后续会陆续支持 zipkin服务链路监控  springboot-admin 服务健康监控等
## 进度

![index](https://github.com/YuKongEr/panda/blob/master/imgs/index.png)

![resource-1](https://github.com/YuKongEr/panda/blob/master/imgs/resource-1.png)

![resource-2](https://github.com/YuKongEr/panda/blob/master/imgs/resource-2.png)

![role](https://github.com/YuKongEr/panda/blob/master/imgs/role.png)

![login-log](https://github.com/YuKongEr/panda/blob/master/imgs/login-log.png)

![operator-log](https://github.com/YuKongEr/panda/blob/master/imgs/operator-log.png)

![exception-log-1](https://github.com/YuKongEr/panda/blob/master/imgs/exception-log-1.png)

![exception-log-2](https://github.com/YuKongEr/panda/blob/master/imgs/exception-log-2.png)

![gen](https://github.com/YuKongEr/panda/blob/master/imgs/code.png)

- [x] 登录管理
  - [x] 登录
  - [x] 登出
- [x] 系统管理
  - [x] 资源管理
    - [x] 查看资源
    - [x] 添加资源
    - [x] 修改资源
    - [x] 删除资源
  - [x] 角色管理
    - [x] 查看角色
    - [x] 添加角色
    - [x] 修改角色
    - [x] 分配资源
  - [x] 用户管理
    - [x] 查看用户
    - [x] 添加用户
    - [x] 修改用户
    - [x] 分配角色
  - [ ] 字典管理
  - [ ] 终端管理
  - [ ] 令牌管理
- [x] 日志管理
    - [x] 登录日志
       - [x] 查询日志
    - [x] 操作日志
       - [x] 查询日志
    - [x] 异常日志
       - [x] 查询日志
- [x] 研发管理
  - [x] 代码生成
    - [x] 查询表格
    - [x] 生成代码
  - [x] 接口文档
- [ ] 个人中心
  - [ ] 查看资料
  - [ ] 修改资料




 ## 启动教程

 - 根据`init.sql` 创建数据库
 - 首先启动 `panda-server` 注册中心
 - 然后启动`panda-config-server`配置注册中心
 - 启动统一用户服务`panda-user-service`
 - 启动认证服务`panda-auth`  以为认证服务依赖于统一用户服务，所以 统一用户服务器启动在前
 - 最后启动`panda-gateway` 网关
 - 然后启动前台工程  `npm run dev / yarn run dev`就可以

[panda-admin前台工程地址](https://github.com/YuKongEr/panda-admin)



目前完成 基础权限模块，接下来会完善动态路由界面可视化配置，与个人中心模块。