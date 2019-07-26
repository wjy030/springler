/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: DBConfig
 * Author:   suneee
 * Date:     2018/11/22 17:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.config.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author suneee
 * @create 2018/11/22
 * @since 1.0.0
 */
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class DBConfig {

    @Value("${driverClass}")
    private String dirverClass;
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String user;
    @Value("${pass}")
    private String pass;
    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new DriverManagerDataSource();
        ((DriverManagerDataSource) dataSource).setDriverClassName(dirverClass);
        ((DriverManagerDataSource) dataSource).setUrl(url);
        ((DriverManagerDataSource) dataSource).setUsername(user);
        ((DriverManagerDataSource) dataSource).setPassword(pass);
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dtaSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dtaSource);
        return transactionManager;
    }

}
