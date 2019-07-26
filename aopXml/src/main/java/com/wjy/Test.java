/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: Test
 * Author:   suneee
 * Date:     2018/10/18 11:14
 * Description: 测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy;

import com.wjy.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试〉
 *
 * @author suneee
 * @create 2018/10/18
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService = (CustomerService) context.getBean("c1");
        customerService.update();
        customerService.save();
        customerService.methodArg(1);
    }
}
