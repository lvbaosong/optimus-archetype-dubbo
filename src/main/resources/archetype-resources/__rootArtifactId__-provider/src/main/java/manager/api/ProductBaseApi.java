/**
 * ProductBaseApi  2019/3/28
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ${package}.manager.api;

import ${package}.domain.eo.Product;

/**
 * @description: 商品通用基础接口
 * @program: dubbo-demo
 * @author: donh
 * @mail: hudong@deepexi.com
 * @date: 2019/3/28 上午11:13
 **/
public interface ProductBaseApi {

    /**
     * 新增商品基础接口
     */
    void createProduct(Product product);

    /**
     * 根据id删除商品基础接口
     */
    void deleteProductById(String id);

    /**
     * 根据id查询商品信息
     */
    Product getProductById(String id);
}
