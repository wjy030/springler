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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br> 
 * 〈范例service实例〉
 *
 * @author suneee
 * @create 2018/10/10
 * @since 1.0.0
 */
@Component
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDaoImpl;

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }
    @Value("上海,深圳")
    private String[] cities;
    private Properties custProp;
//    @Value("#{cd1.driverClass}")
    private String driverType;
    @Value("1111")
    private Long id;
    private List<CustomerService> customerServiceList;
    private Map customerMap;
    public CustomerServiceImpl(){}

    /**
     * 构造方法注入
     * @param customerDaoImpl
     */
    public CustomerServiceImpl(CustomerDao customerDaoImpl){
        super();
        this.customerDaoImpl = customerDaoImpl;
    }

    @Override
    public String toString() {
        return "CustomerServiceImpl{" +
                "c1=" + customerDaoImpl +
                ", cities=" + Arrays.toString(cities) +
                ", custProp=" + custProp +
                ", driverType='" + driverType + '\'' +
                ", id=" + id +
                ", customerServiceList=" + customerServiceList +
                ", customerMap=" + customerMap +
                '}';
    }

    /**
     * setter方法注入
     * @param customerDaoImpl
     */
    public void setCustomerDaoImpl(CustomerDao customerDaoImpl) {
        this.customerDaoImpl = customerDaoImpl;
    }
    public void save() {
//        customerDao.save();
    }

    public void setId(Long id) {
        System.out.println("aaaaaaaaaa");
        this.id = id;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    public void setCustomerServiceList(List<CustomerService> customerServiceList) {
        this.customerServiceList = customerServiceList;
    }

    public void setCustomerMap(Map customerMap) {
        this.customerMap = customerMap;
    }

    public void setCustProp(Properties custProp) {
        this.custProp = custProp;
    }
}
