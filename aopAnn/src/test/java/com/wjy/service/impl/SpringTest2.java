/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: SpringTest
 * Author:   suneee
 * Date:     2018/11/22 11:48
 * Description: spring测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.service.impl;

import com.wjy.config.JavaConfig;
import com.wjy.model.GoodsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈spring测试〉
 *
 * @author suneee
 * @create 2018/11/22
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfig.class)
public class SpringTest2 {

    @Autowired
    private CustomerServiceImpl customerService;
    @Test
    public void add() {
        customerService.add();
    }
    @Test
    public void update() {
        JdbcTemplate template = new JdbcTemplate();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("wjy199889");
        template.setDataSource(dataSource);
        template.update("update pub_goods set goodsname = '超级' where goodsid = 139809");
        List<GoodsDao> query = template.query("select * from pub_goods where goodsid = ?", new
                BeanPropertyRowMapper<GoodsDao>(GoodsDao.class), 139809);
        System.out.println(query.get(0).getGoodsid());
    }
}
