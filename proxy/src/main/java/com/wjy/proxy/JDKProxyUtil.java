/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: JDKProxyUtil
 * Author:   suneee
 * Date:     2018/10/16 18:04
 * Description: jdk代理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈jdk代理〉
 *
 * @author suneee
 * @create 2018/10/16
 * @since 1.0.0
 */
public class JDKProxyUtil {

    public static Object getProxy(final Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("======");
                return method.invoke(target,args);
            }
        });
    }
}
