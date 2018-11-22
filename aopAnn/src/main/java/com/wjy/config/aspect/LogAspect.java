/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: LogAspect
 * Author:   suneee
 * Date:     2018/11/22 11:38
 * Description: 日志记录
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.config.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈日志记录〉
 *
 * @author suneee
 * @create 2018/11/22
 * @since 1.0.0
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(public void com.wjy.service.impl.CustomerServiceImpl.add())")
    public void pointCut(){}
    @Before("pointCut()")
    public void log() {
        System.out.println("打印before日志");
    }
}
