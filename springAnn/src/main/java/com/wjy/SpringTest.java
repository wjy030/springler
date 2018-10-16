/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: SpringTest
 * Author:   suneee
 * Date:     2018/10/16 14:42
 * Description: springtest
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy;

import com.wjy.config.SpringConfig;
import com.wjy.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈springtest〉
 *
 * @author suneee
 * @create 2018/10/16
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Resource
    private CustomerService customerService;

    @Test
    public void testSave() {
        customerService.save();
    }
}
