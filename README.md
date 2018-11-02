## 介绍
- panda-server 服务注册中心
- panda-auth  oauth2 认证服务器 提供token
- panda-common 公共模块集合
- panda-config-server 配置中心服务器
- panda-gateway 统一网关，提供动态路由 同时也是oauth2的资源服务器
- panda-service 业务模块集合
  - panda-user-service 统一用户管理模块
    
 
后续会陆续支持 zipkin服务链路监控  springboot-admin 服务健康监控等
## 进度
- [x] 登录管理
  - [x] 登录
  - [x] 登出
- [ ] 系统管理
  - [x] 资源管理
    - [x] 查看资源
    - [x] 添加资源
    - [x] 修改资源
    - [x] 删除资源
  - [ ] 角色管理
    - [x] 查看角色
    - [ ] 添加角色
    - [ ] 修改角色
    - [ ] 分配角色资源
  - [ ] 用户管理
  - [ ] 令牌管理
  - [ ] 日志管理
- [ ] 个人中心
  - [ ] 查看资料
  - [ ] 修改资料
  

