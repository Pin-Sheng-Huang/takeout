[//swagger接口文挡访问 :http://localhost:8080/doc.html#/home]
#前端访问:listen       8991;
EX:http://localhost:8991/#/dashboard
#负载均衡器 指定服务器
upstream webservers{
	  server 127.0.0.1:8080 weight=90 ;
	  #server 127.0.0.1:8088 weight=10 ;
	}
## 快速搭建项目：
启动nginx ，nginx要放在无中文目录下

默认端口80 ，逆向代理到8080

导入sql

改yml的数据库配置

要上传图片，自己用自己的OSS服务

不会用redis就打开调试，多点一下平台的业务功能，出问题了把redis的注解注释了就不会有问题。
### 开发更新日志
2023/5/4____ 更新了微信小程序端的代码，若需要使用微信前端小程序需要注册小程序，导入更新的微信小程序代码进行编译，注意搜索端口8080，改为自己的端口。在yml配置自己小程序的Access Key，还有password。
