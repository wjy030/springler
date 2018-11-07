/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: LogAspect
 * Author:   suneee
 * Date:     2018/10/18 11:12
 * Description: 测试日志切面
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试日志切面〉
 *
 * @author suneee
 * @create 2018/10/18
 * @since 1.0.0
 */
public class LogAspect {

    public void log() {
        System.out.println("before记录日志");
    }

    public void logReturn() {
        System.out.println("afterReturn记录日志");
    }

    public void logAfter() {
        System.out.println("after记录日志");
    }

    public void beforeArg(JoinPoint joinPoint) {
        System.out.println("参数"+joinPoint.getArgs());
    }

    public void afterArg(JoinPoint joinPoint,Object rvt) {
        System.out.println("参数"+rvt);
    }

    public void logThrow(Throwable ex) {
        System.out.println("throw记录日志" + ex.getMessage());
    }

    public void logAround(ProceedingJoinPoint joinPoint) {
        System.out.println("around前置记录日志");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("error");
        }
        System.out.println("around后置记录日志");
    }
}
