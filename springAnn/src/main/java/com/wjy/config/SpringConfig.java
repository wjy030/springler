/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: SpringConfig
 * Author:   suneee
 * Date:     2018/10/16 12:17
 * Description: 配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.config;

import com.wjy.dao.CustomerDao;
import com.wjy.dao.impl.CustomerDaoImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 〈一句话功能简述〉<br> 
 * 〈配置类〉
 *
 * @author suneee
 * @create 2018/10/16
 * @since 1.0.0
 */
@Import({JDBCProperties.class})
@Configurable
@ComponentScan(basePackages = "com.wjy")
public class SpringConfig {

    @Bean(name="cd1")
    public CustomerDao getDao() {
        return new CustomerDaoImpl();
    }
}
