package com.qtatelier.springboot.config;

import com.qtatelier.springboot.component.LoginHandlerInterceptor;
import com.qtatelier.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author JazzXia
 * @create 2019-10-20:44
 *
 * 相较于Spring Boot 1.5.xx版本之前是继承WebMvcConfigurerAdapter
 *                            现在是实现WebMvcConfigurer这个接口来扩展SpringMVC的功能
 */
//@EnableWebMvc//全面接管SpringMvc的自动配置SpringBoot的所有的自动配置都失效了
//@EnableWebMvc将WebMvcConfigurationSupport组建导入进来；
//导入的WebMvcConfigurationSupport知识SpringMVC最基本的功能
//一般推荐加这个注解，使用这个注解就使得SpringBoot的优势丧失,
//所以除了做一些小型的项目不需要太多组件使用手动配置以外，其余还是自动配置。
@Configuration
public class MyMvcConfig  implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /qtatelier请求来到success页面
        registry.addViewController("/qtatelier").setViewName("success");
    }

    //所有的WebMvcConfigurer组件都会在一起起作用 WebMvcConfigurerAdapter过期了所以不用这个
    @Bean//将组件注册到容器
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer(){

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("").setViewName("login");
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源：*.css, *.js
                //SpringBoot已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**");
            }
        };
        return configurer;
    }


    //区域信息
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
