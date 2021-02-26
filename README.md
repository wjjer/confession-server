# confession-server


## 应用介绍

告白吧 confession，是一款支持生成 **告白网页二维码**的在线告白神器，可以将生成的二维码奉献给你喜欢的那个她



## 应用展示



## 技术架构

:ballot_box_with_check: 基于[**JFinal** (JFinal 是基于Java 语言的极速WEB + ORM 框架）](https://gitee.com/jfinal/jfinal) 开发

:ballot_box_with_check: 服务器内存占用极低，服务启动快（RAM占用 < 100MB），应用快速启动（启动时间< 5 Sec）



## 部署方式



1. 克隆至本地

~~~shell
git clone https://github.com/wjjer/confession-server.git
~~~



2. 修改配置文件

（1）修改 resources/a_little_config.txt 文件，配置数据库文件

~~~shell
# 改为你的数据库配置 

jdbcUrl = jdbc:mysql://xxx/confession
user = xxxx
password = xxxx
devMode = false
~~~



（2）修改应用的页面部署路径

修改 global/SystemConstant 文件的 `TARGET_PATH` 属性

~~~shell
# 改为自己的web页面服务器的配置路径

public static final String TARGET_PATH = "/var/www/confession";
~~~



（3）导入sql文件

新建数据库 confession，将confession.sql文件导入到数据库，如果导入出错，请将sql文件中的 ` “` 号替换为 `‘`号或替换为`空格`，或者根据结构自己建表。

~~~shell
# sql文件所在目录
/sql/confession.sql
~~~





## 打包运行

应用支持打 jar 包运行

~~~shell
# 执行maven 命令
mvn clean
mvn install

# 打好的jar位于target下
~~~



服务端运行

~~~shell
java -jar confession.jar

# 服务端后台运行
nohup java -jar confession.jar >temp.txt &
~~~



**如果在本在idea下运行**，则执行 `vip/ablog/common` 下的`AppApplication`文件，端口修改也在该文件的 main 方法中，如果**在服务器打包运行**，需要修改端口，则修改`vip/ablog/common` 下的`AppPackageApplication`文件下的main方法。



## 服务端 nginx 配置

这里web服务端采用 nginx 服务器部署方式，首先确保服务器安装nginx，如果没有安装，请参照 [nginx安装教程]() 进行下载安装。

（1）编辑 nginx.conf 文件

~~~shell
# 修改nginx默认配置文件
vi /usr/local/nginx/conf/nginx.conf

# 找到server节点，在默认location节点上方添加新的location节点

    server {
        listen       80;
        server_name  localhost;
        
        #-------------------新添加的节点配置--------------------
        location /confession {
           root /var/www;
           index index.html index.htm;
        }
		#----------------------------------------------------
        location / {
            root   /var/www;
            index  index.html index.htm;
        }
}
~~~



（2）重启 nginx 配置

~~~shell
# reload使nginx新的配置生效
nginx -s reload
~~~

