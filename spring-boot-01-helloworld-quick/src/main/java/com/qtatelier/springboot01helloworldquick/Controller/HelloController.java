package com.qtatelier.springboot01helloworldquick.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JazzXia
 * @create 2019-10-19:14
 *
 *
 * IDE都支持使用Spring的项目创建向导快速创建一个Spring Boot项目；
 *
 * 选择我们需要的模块；向导会联网创建Spring Boot项目；
 *
 * 默认生成的Spring Boot项目；
 *
 * - 主程序已经生成好了，我们只需要我们自己的逻辑
 * - resources文件夹中目录结构
 *   - static：保存所有的静态资源； js css  images；
 *   - templates：保存所有的模板页面；（Spring Boot默认jar包使用嵌入式的Tomcat，默认不支持JSP页面）；可以使用模板引擎（freemarker、thymeleaf）；
 *   - application.properties：Spring Boot应用的配置文件；可以修改一些默认设置；
 */
//这个类的所有方法返回的数据直接写给浏览器，（如果是对象还能转为JSON数据）
/*@ResponseBody
@Controller*/
@RestController //这个底层就是@ResponseBody与@Controller的组合
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "强盛永远是我儿子";
    }
}
