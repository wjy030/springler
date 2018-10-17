/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: TestMain
 * Author:   suneee
 * Date:     2018/10/16 18:03
 * Description: main测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy;

import com.wjy.proxy.CglibProxyUtil;
import com.wjy.proxy.JDKProxyUtil;
import com.wjy.service.CustomerService;
import com.wjy.service.impl.CustomerServiceImpl;

/**
 * 〈一句话功能简述〉<br> 
 * 〈main测试〉
 *
 * @author suneee
 * @create 2018/10/16
 * @since 1.0.0
 */
public class TestMain {

    public static void main(String[] args) {
        CustomerService customerService = (CustomerService) CglibProxyUtil.getProxy(new CustomerServiceImpl());
        customerService.save();
        customerService.update();
    }
}
