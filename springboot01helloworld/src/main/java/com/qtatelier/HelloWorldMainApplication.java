package com.qtatelier;

/**
 * @author JazzXia
 * @create 2019-10-16:33
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *@SpringBootApplication 来标注一个主程序类，说明这是一个Spring Boot应用
 * @SpringBootApplication ：Spring Boot应用标注在某个类上说明这个类就是Spring Boot的主配置类，
 * SpringBoot就应该运行这个类的main方法来启动SpringBoot应用
 *
 *
 * @SpringBootApplication的底层如下:
 *
 * @Target(ElementType.TYPE)
 * @Retention(RetentionPolicy.RUNTIME)
 * @Documented
 * @Inherited
 * @SpringBootConfiguration :标注在某个类上，表示这是一个Spring Boot的配置类
 * @EnableAutoConfiguration
 * @ComponentScan(excludeFilters = {
 * 		@Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
 * 		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
 * public @interface SpringBootApplication {
 *
 *
 * @SpringBootConfiguration的底层如下：
 *
 * @Target(ElementType.TYPE)
 * @Retention(RetentionPolicy.RUNTIME)
 * @Documented
 * @Configuration: 就是配置类标注的注解
 *
 *     配置类 ------ 配置文件
 *
 *  配置类也是容器中的一个组件；@Component
 *
 * @EnableAutoConfiguration:开启自动配置功能
 *
 * 以前我们徐亚配置的东西，Spring Boot帮我们自动配置；
 * @EnableAutoConfiguration告诉SpringBoot开启自动配置功能；这样自动配置才能生效;
 * public @interface SpringBootConfiguration {
 *
 * }
 *
 * @EnableAutoConfiguration的原理如下:
 *
 * @AutoConfigurationPackage：自动配置包
 * 而其底层为 @Import(AutoConfigurationPackages.Registrar.class)
 * Spring的底层注解@Import，给容器中导入一个组件；
 * 导入的组件由AutoConfigurationPackages.Registrar.class
 * @Import(EnableAutoConfigurationImportSelector.class)
 * 将主配置类的(SpringBootApplication标注的类)的所在包及下面所有子包里的所有组件扫描到Spring容器里；
 * public @interface EnableAutoConfiguration {
 *
 *
 * EnableAutoConfigurationImportSelector：导入哪些组件的选择器；
 * 将所有需要导入的组件以全类名的方式返回；这些组件就会被添加到容器中；
 *
 *  有了自动配置类，免去了我们手动编写配置注入功能组件等的工作；
 *  SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class,classLoader)；
 *
 *  Spring Boot在启动的时候从类路径下的
 *  META-INF/spring.factories中获取EnableAutoConfiguration指定的值，
 *  将这些值作为自动配置类导入到容器中，自动配置类就生效，帮我们进行自动配置工作；
 *  以前我们需要自己配置的东西，自动配置类都帮我们；
 *
 *
 * J2EE的整体整合解决方案和自动配置都在spring-boot-autoconfigure-1.5.9.RELEASE.jar下；
 */

@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {

        //Spring应用的启动
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }
}
