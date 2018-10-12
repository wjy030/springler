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
    private CustomerDao customerDao;

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private Long id;

    @Override
    public String toString() {
        return "CustomerServiceImpl{" +
                "customerDao=" + customerDao +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public CustomerServiceImpl(){}

    /**
     * 构造方法注入
     * @param customerDao
     */
    public CustomerServiceImpl(CustomerDao customerDao){
        super();
        this.customerDao = customerDao;
    }

    /**
     * setter方法注入
     * @param customerDao
     */
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    public void save() {
        customerDao.save();
    }

    public void setId(Long id) {
        this.id = id;
    }
}
