/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: BeanFactory
 * Author:   wjy
 * Date:     2018/10/10 7:24
 * Description: 一个简单的IOC容器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br> 
 * 〈一个简单的IOC容器〉
 *
 * @author wjy
 * @create 2018/10/10
 * @since 1.0.0
 */
public class BeanFactory {

    private static Properties prop = new Properties();
    static {
        InputStream inputStream = BeanFactory.class.getResourceAsStream("/beans.properties");
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String name) {
        String className = prop.getProperty(name);
        try {
            return Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
