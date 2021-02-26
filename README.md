JFinal 3.4 Demo (for Maven)
======

## 特别注意：

jfinal_demo_for_maven 项目开发时的启动参数与 jfinal_demo 稍有不同，
需要指定webapp的路径如：JFinal.start("src/main/webapp", 80, "/", 5);
其中的 "src/main/webapp" 必须要指定，在使用 eclipse 配置启动项时需要
指定 argument: src/main/webapp 80 / 5
       
  
## 注意：

IDEA 下开发时启动只需要三个参数 argument: src/main/webapp 80 /
也即比 eclipse 启动少了最后一个参数
IDEA 下开发还需要将 pom.xml 中的 jetty-server 依赖配置中的
<scope>provided</scope> 删除掉


## 项目启动步骤

1. 使用 blog.sql 中的 sql 语句创建数据库与数据库表

2. 修改 WebRoot/WEB-INF/a_little_config.txt 文件，填入正确的数据库连接用户名、密码

3. 将项目导入 eclipse。推荐使用 Eclipse IDE for Java EE Developers

4. 打开 com.demo.common包下的 DemoConfig 文件，右键单击该文件并选择 Debug As ---> Java Application。
        其它启动项目的方式见 《JFinal手册》。除此之外，项目还可以与其它普通java web 项目一样使用 tomcat
   jetty 等 web server 来启动，启动方式与非jfinal项目完全一样。

5. maven 项目还可以在控制台通过  mvn jetty:run 来启动

6. 打开浏览器输入  localhost 即可查看运行效果

## 注意：

请确保您安装了 JavaSE 1.6 或更高版本，tomcat下运行项目需要先删除 jetty-server-xxx.jar，否则会有冲突
