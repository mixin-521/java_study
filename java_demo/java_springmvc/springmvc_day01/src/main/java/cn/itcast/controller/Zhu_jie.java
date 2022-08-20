package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/zhujie")
public class Zhu_jie {
    /*常用注解
    *
    * */
    @RequestMapping("/RequestParam")        //传进来的名字"必须"是name
    public String RequestParam(@RequestParam(name="name")String username){
        System.out.println("执行了..RequestParam");
        System.out.println(username);
        return "success";
    }
    @RequestMapping("/RequestBody")
    public String RequestBody(@RequestBody String body){
        System.out.println("执行了..RequestBody");
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/PathVariable/{sid}") //这个sid跟我这行的一个名字
    public String PathVariable(@PathVariable(name = "sid") String id){
        System.out.println("执行了..PathVariable");
        System.out.println(id);
        return "success";
    }

}


