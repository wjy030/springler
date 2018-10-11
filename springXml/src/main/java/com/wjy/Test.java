/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: Test
 * Author:   suneee
 * Date:     2018/10/10 16:47
 * Description: 测试用例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy;

import com.wjy.dao.CustomerDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试用例〉
 *
 * @author suneee
 * @create 2018/10/10
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ((CustomerDao)context.getBean("customerDao")).save();
    }
}
