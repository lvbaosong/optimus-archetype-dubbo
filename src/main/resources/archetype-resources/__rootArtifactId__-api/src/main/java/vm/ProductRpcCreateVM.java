/**
 * ProductRpcCreateVM  2019/4/1
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ${package}.vm;

import java.io.Serializable;

/**
 * @description: 创建商品入参qo
 * @program: dubbo-demo
 * @author: donh
 * @mail: hudong@deepexi.com
 * @date: 2019/4/1 下午2:15
 **/
public class ProductRpcCreateVM implements Serializable{

    private static final long serialVersionUID = -3181552265903631895L;
    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductCreateQO{" + "name='" + name + '\'' + ", price=" + price + '}';
    }
}
