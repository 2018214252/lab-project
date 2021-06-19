### lab-project
实验室预约管理系统后端，为前端提供支持

### lab-gateway-service
网关服务，配置cloud.gateway.routes路由转发规则。
根据路由转发到相应微服务。

### lab-Login-service
登录成功后，后端仅在header返回token/加密的role(约定)，不返回首页组件加载数据。
前端登录成功，获取token/role保存在SessionStorage。

### Interceptor
后端在LoginInterceptor中解密出token中的uid/role数据，置于request attribute作用域。由于每次请求创建一个请求对象，
且请求对象一直持续到本次互交结束。因此，对象可在后续拦截器/控制层方法中获取并使用。  
在controller方法直接注入请求对象，或通过@RequestAttribute注解注入作用域中指定属性数据

### lab-admin-service
管理员端服务，处理前端管理员账号的请求
包括教师、实验室的增删改查等功能

### lab-teacher-service
教师端服务，处理前端教师账号的请求
包括课程的增删改查以及预约、取消预约等功能

### Others
引入caffeine缓存
服务注册到nacos

## Deployment
服务部署在openjdk11+MySQL8 2个容器。通过docker compose编排管理。