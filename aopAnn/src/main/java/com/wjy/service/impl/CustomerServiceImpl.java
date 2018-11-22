/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: CustomerServiceImpl
 * Author:   suneee
 * Date:     2018/11/22 9:59
 * Description: 客户服务测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.service.impl;

import com.wjy.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 〈一句话功能简述〉<br> 
 * 〈客户服务测试〉
 *
 * @author suneee
 * @create 2018/11/22
 * @since 1.0.0
 */
@Component
public class CustomerServiceImpl {

    @Autowired
    private CustomerDao customerDao;

    @Transactional
    public void add() {
        System.out.println("执行新增");
        customerDao.add();
    }
}
