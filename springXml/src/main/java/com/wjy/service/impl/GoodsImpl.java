/**
 * Copyright (C), 2015-2018, 上海象翌微链有限公司
 * FileName: GoodsImpl
 * Author:   suneee
 * Date:     2018/11/23 9:28
 * Description: 商品
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.service.impl;

/**
 * 〈一句话功能简述〉<br> 
 * 〈商品〉
 *
 * @author suneee
 * @create 2018/11/23
 * @since 1.0.0
 */
public class GoodsImpl {

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "GoodsImpl{" +
                "name='" + name + '\'' +
                '}';
    }
}
