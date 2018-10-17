/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: CglibProxyUtil
 * Author:   suneee
 * Date:     2018/10/17 10:33
 * Description: cglib代理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈cglib代理〉
 *
 * @author suneee
 * @create 2018/10/17
 * @since 1.0.0
 */
public class CglibProxyUtil {
    public static   Object getProxy(final Object target) {
        return Enhancer.create(target.getClass(), new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws
                    Throwable {
                System.out.println("*******************");
                return methodProxy.invokeSuper(proxy,objects);
            }
        });
    }
}
