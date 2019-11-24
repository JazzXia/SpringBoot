package com.qtatelier.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author JazzXia
 * @create 2019-10-23-15:56
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                                .antMatchers("/level1/**").hasRole("VIP1")
                                .antMatchers("/level2/**").hasRole("VIP2")
                                .antMatchers("/level3/**").hasRole("VIP3");

        //开启自动配置的登录功能，效果，如果没有登录，没有权限就回来到登录页面
        http.formLogin();
        //1、/login请求来到登录页
        //2、重定向到/login?error登录失败
        //3、更多详细规则

        //开启自动配置的注销功能
        //1、访问 /logout 表示用户注销，清空session
        //2、注销成功会返回 /login?logout 页面
       // http.logout();
        //自定义注销成功来到首页
        http.logout().logoutSuccessUrl("/");

    }

    //认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("qiangsheng").password("123456").roles("VIP1","VIP2")
                .and()
                .withUser("lisi").password("123456").roles("VIP2","VIP3")
                .and()
                .withUser("daijun").password("123456").roles("VIP1","VIP3")
                .and()
                .passwordEncoder(new CustomPasswordEncoder());

    }
}
