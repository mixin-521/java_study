package cn.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 增强类(增强的方法所在的类)
 *
 * @Aspect(切面) ===  aop:aspect [千万不要遗漏此处]
 */
@Aspect
public class MyAscept {
    /**
     * 配置前置通知
     * value: 表达式方式配置切入点,value可以省略
     */
    @Before("execution(* com.itheima.dao.impl.*.save(..))")
    public static void checkRights() {
        System.out.println("通知:开始权限校验");
    }

    /**
     * 配置后置通知
     * value:表达式方式配置切入点
     * returning: 和通知所在的方法的形参名一致
     */
    @AfterReturning(value = "execution(* com.itheima.dao.impl.*.delete(..))", returning = "result")
    public void showLog(String result) {
        System.out.println("这是一条删除之后的日志-->" + result);
    }

    /**
     * 别忘了让原来的方法运行(ProceedingJoinPoint 固定写法)
     *
     * @Around.value : 配置切入点
     */
    @Around(value = "execution(* com.itheima.dao.impl.*.findAll(..))")
    public void showCostTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Long begin = System.currentTimeMillis();
        System.out.println("begin time:" + begin);
        //让原来的方法运行
        joinPoint.proceed();
        Long end = System.currentTimeMillis();
        System.out.println("end time:" + end);
        System.out.println("cost time:" + (end - begin));
    }

    @AfterThrowing(value = "execution(* com.itheima.dao.impl.*.update(..))", throwing = "e1")
    public void showErrMsg(Throwable e1) {
        System.out.println("this is a error msg--->" + e1.getMessage());
    }

    @After("execution(* com.itheima.dao.impl.*.findById(..))")
    public void showFinalMsg() {
        System.out.println("this is a final msg");
    }
}
