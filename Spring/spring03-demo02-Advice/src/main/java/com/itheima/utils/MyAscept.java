package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 */
public class MyAscept {

    public static void checkRights() {
        System.out.println("通知:开始权限校验");
    }

    public void showLog(String result) {
        System.out.println("这是一条删除之后的日志-->" + result);
    }

    /**
     * 别忘了让原来的方法运行(ProceedingJoinPoint 固定写法)
     *
     * @param joinPoint
     * @throws Throwable
     */
    public void showCostTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Long begin = System.currentTimeMillis();
        System.out.println("begin time:" + begin);
        //让原来的方法运行
        joinPoint.proceed();
        Long end = System.currentTimeMillis();
        System.out.println("end time:" + end);
        System.out.println("cost time:" + (end - begin));
    }

    public void showErrMsg(Throwable e1) {
        System.out.println("this is a error msg--->" + e1.getMessage());
    }

    public void showFinalMsg() {
        System.out.println("this is a final msg");
    }
}
