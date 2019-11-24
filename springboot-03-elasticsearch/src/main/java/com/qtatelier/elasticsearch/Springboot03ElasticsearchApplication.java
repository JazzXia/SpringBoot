package com.qtatelier.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * SpringBoot默认支持两种技术来和ES交互：
 * 1、Jest(默认不生效)
 *    需要导入jest的工具包(io.searchbox.client.JestClient)
 * 2、SpringData ElasticSearh
 *     1)、Client 节点信息 clusterNodes; clusterName;
 *     2)、ElasticsearchTemplate 操作es
 *     3)、编写一个ElasticsearchRepository的子接口来操作es
 *两种用法：
 * 1)、编写一个ElasticsearchRepository的子接口
 */
@SpringBootApplication
public class Springboot03ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticsearchApplication.class, args);
    }

}
