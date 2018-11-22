/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: JavaConfig
 * Author:   suneee
 * Date:     2018/11/22 10:03
 * Description: 配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.config;

import com.wjy.config.aspect.DBConfig;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * 〈一句话功能简述〉<br> 
 * 〈配置类〉
 *
 * @author suneee
 * @create 2018/11/22
 * @since 1.0.0
 */
@Configurable
@ComponentScan(basePackages = "com.wjy")
@Import(DBConfig.class)
@EnableAspectJAutoProxy
public class JavaConfig {

}
