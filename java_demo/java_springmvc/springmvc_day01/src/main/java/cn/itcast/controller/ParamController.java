package cn.itcast.controller;

import cn.itcast.dao.Account;
import cn.itcast.dao.riqi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/parma")
@Controller
public class ParamController {
    @RequestMapping("/test")
    public String test(String username){
        System.out.println("用户名:"+username);
        System.out.println("parma-----执行了");
        return "success";
    }
    @RequestMapping("/test2")
    public String test2(String username,String password) {
        System.out.println("用户名:" + username + "密码" + password);
        System.out.println("parma-----执行了");
        return "success";
    }
    /*
    * 请求参数绑定把数据封装到javaBean的类中
    * */
        @RequestMapping("/test3")
        public String test3(Account account){
            System.out.println(account);
//            System.out.println("parma-----执行了");
            return "success";
    }
    /*自定义类型转换器日期
    * */
    @RequestMapping("/test4")
    public String test4(riqi riqi1){
        System.out.println(riqi1);
//            System.out.println("parma-----执行了");
        return "success";
    }
    /*原生的API
    * */
    @RequestMapping("/test5")
    public String test5(HttpServletRequest request, HttpServletResponse response){
        System.out.println("原生的API执行了");
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(response);
//        System.out.println(session.getId());
        return "success";
    }
}
