package cn.itcast.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 控制器类
 * */

//这个下边Controller是spring扫包告诉扫包这个程序要交给spring容器
@Controller
public class HelloController {
    //下边这个也成为映射关联
//    @RequestMapping也可以放在方法上就相当于一个大的包    用类的时候需要加上   类名(小名)/方法名(小名)
                //path 跟value一样                 这个是请求方式
                                //,method = {RequestMethod.POST}
    @RequestMapping(path = "/hello")//请求路径的注解()
    public String sayHello() {
        System.out.println("入门1");
        return "success";
    }
                                //加上params就需要传=后边的值
    @RequestMapping(path = "/hello2",params = {"name"})//请求路径的注解()
    public String hello2() {
        System.out.println("入门2");
        return "success1";
    }                           //指定请求方式需要指定
    @RequestMapping(path = "/hello3",params = {"name=mixin"})//请求路径的注解()
    public String hello3() {
        System.out.println("入门3");
        return "success1";
    }                                                       //这个是请求头信息
    @RequestMapping(path = "/hello4",params = {"name=mixin"},headers = {"Accept"})//请求路径的注解()
    public String hello4() {
        System.out.println("入门4");
        return "success1";
    }
}
