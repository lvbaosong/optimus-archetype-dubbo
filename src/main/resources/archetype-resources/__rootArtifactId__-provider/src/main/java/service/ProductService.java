/**
 * ProductService  2019/3/28
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ${package}.service;

import ${package}.domain.vm.ProductCreateVM;
import ${package}.dto.ProductDTO;
import com.deepexi.util.extension.ApplicationException;
import com.deepexi.util.pageHelper.PageBean;

/**
 * @description: 商品rest接口调用实现类接口
 * @program: IProductRestService
 * @author: donh
 * @mail: hudong@deepexi.com
 * @date: 2019/3/28 上午11:24
 **/
public interface ProductService {

    /**
     * 条件分页查询商品信息
     */
    PageBean getProductList(Integer page, Integer size, Integer price);

    /**
     * 根据id获取商品信息
     */
    ProductDTO getProductById(String id);

    /**
     * 创建商品
     */
    Boolean createProduct(ProductCreateVM productCreateVM);

    /**
     * 根据id删除商品
     */
    Boolean deleteProductById(String id);

    /**
     * 测试统一异常返回
     */
    void testError();

    /**
     * 测试rpc异常处理
     */
    void testRpcError() throws ApplicationException;
}
