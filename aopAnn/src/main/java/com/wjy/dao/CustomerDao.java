/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: CustomerDao
 * Author:   suneee
 * Date:     2018/11/22 17:10
 * Description: 客户dao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.dao;

import com.wjy.model.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈客户dao〉
 *
 * @author suneee
 * @create 2018/11/22
 * @since 1.0.0
 */
@Component
public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add() {

//        jdbcTemplate.update("update pub_goods set goodsname = '天醒' where goodsid = 139809");
        List<GoodsDao> query = jdbcTemplate.query("select * from pub_goods where goodsid = ?", new
                BeanPropertyRowMapper<GoodsDao>(GoodsDao.class), 139809);
        jdbcTemplate.query("select * from pub_goods where goodsid = ?", new
                BeanPropertyRowMapper<GoodsDao>(GoodsDao.class), 139810);
        System.out.println("sql结束");
        System.out.println(query.get(0).getGoodsid());
    }
}
