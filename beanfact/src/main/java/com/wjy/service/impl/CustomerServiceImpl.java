/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: CustomerServiceImpl
 * Author:   suneee
 * Date:     2018/10/10 16:43
 * Description: 范例service实例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.service.impl;

import com.wjy.BeanFactory;
import com.wjy.dao.CustomerDao;
import com.wjy.service.CustomerService;

/**
 * 〈一句话功能简述〉<br> 
 * 〈范例service实例〉
 *
 * @author suneee
 * @create 2018/10/10
 * @since 1.0.0
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = (CustomerDao) BeanFactory.getBean("customerdao");

    public void save() {
        customerDao.save();
    }
}
