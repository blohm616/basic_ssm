# SSM基础框架结构
1. 整合Redis，Freemarker，Dubbo

## dubbo的使用
zookeeper
  1. 解压zookeeper-3.4.9.tar.gz到本机
  2. 复制zoo_sample.cfg，改名成zoo.cfg,修改文件
  > dataLogDir=/tmp/log
  3. 启动zookeeper,
  > zkServer.cmd
dubbo-admin
  1. 将war包复制到tomcat webapp下
  2. 密码在dubbo.properties中
** dubbo的环境必须是JDK1.7和TOMCAT7 **


