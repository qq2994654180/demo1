# demo1
spring boot项目，集成sawgger2,druid数据连接池及监控，自定义拦截器登陆认证注解

1.在Swagger2Config配置类中修改扫描的包路径   

（ .apis(RequestHandlerSelectors.basePackage("com.example.demo1.v1.controller"))//api选择器选择api的包）

2.在AuthenticationInterceptor中修改登陆认证不通过的跳转页面
（ //判断用户ID是否存在，不存在就跳转到登录界面
            if(session.getAttribute("user") == null){
                response.sendRedirect(request.getContextPath()+"/login");
                return false;）
3.在需要验证的方法上加上注解@LoginRequired
4.修改yml配置文件中的数据库连接地址和密码
5.修改DruidStatViewServlet数据库监控地址，包括黑名单白名单用户名和密码
启动成功：
http://localhost:8000/swagger-ui.html（swagger地址）
HTTP：//本地主机：8000 /德/ login.html的（数据库监控地址）
如有不懂可加微信xx17610115570 标注：项目
