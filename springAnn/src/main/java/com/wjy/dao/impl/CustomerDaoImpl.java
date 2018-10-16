/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: CustomerDaoImpl
 * Author:   wjy
 * Date:     2018/10/10 7:37
 * Description: 范例dao实例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.dao.impl;

import com.wjy.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈范例dao实例〉
 *
 * @author wjy
 * @create 2018/10/10
 * @since 1.0.0
 */


public class CustomerDaoImpl implements CustomerDao {
    @Override
    public String toString() {
        return "CustomerDaoImpl{" +
                "dName='" + dName + '\'' +
                ", driverClass='" + driverClass + '\'' +
                '}';
    }

    private String dName;

    public String getDriverClass() {
        return driverClass;
    }

    @Value("${driverClass}")
    private  String driverClass;

    public void save() {
        System.out.println("保存保存保存！");
    }

    public void init() {
        System.out.println("初始化");
    }

    public void destory() {
        System.out.println("销毁");
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
}
