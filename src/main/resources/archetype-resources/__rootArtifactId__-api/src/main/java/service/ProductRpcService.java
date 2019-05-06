/**
 * ProductRpcService  2019/4/2
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ${package}.service;

import ${package}.dto.ProductDTO;
import ${package}.vm.ProductRpcCreateVM;

/**
 * @description: 商品rpc调用接口
 * @program: IProductService
 * @author: donh
 * @mail: hudong@deepexi.com
 * @date: 2019/4/2 下午2:35
 **/
public interface ProductRpcService {

    /**
     * @description: 根据商品id获取商品部分信息
     * @param id : 
     * @return: com.deepexi.demo.dto.ProductDTO
     * @author: donh
     * @date: 2019/3/28 上午11:23
     */
    ProductDTO getProductById(String id);

    /**
     * 添加商品
     * @param productCreateQO
     * @return
     */
    Boolean createProduct(ProductRpcCreateVM productCreateQO);
}