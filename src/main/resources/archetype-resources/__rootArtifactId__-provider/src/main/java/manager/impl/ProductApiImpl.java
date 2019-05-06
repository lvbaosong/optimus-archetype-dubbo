/**
 * ProductApiImpl  2019/3/28
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ${package}.manager.impl;

import ${package}.domain.eo.Product;
import ${package}.manager.api.ProductBaseApi;
import ${package}.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 商品通用基础接口实现类
 * @program: dubbo-demo
 * @author: donh
 * @mail: hudong@deepexi.com
 * @date: 2019/3/28 上午11:16
 **/
@Service
public class ProductApiImpl implements ProductBaseApi {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void createProduct(Product product) {
        // 一些新增处理逻辑
        productMapper.insert(product);
    }

    @Override
    public void deleteProductById(String id) {
        // 一些删除前处理逻辑
        productMapper.deleteById(id);
    }

    @Override
    public Product getProductById(String id) {
        // 一些处理逻辑
        return productMapper.selectById(id);
    }
}
