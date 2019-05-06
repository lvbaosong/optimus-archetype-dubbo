/**
 * ProductServiceImpl  2019/3/27
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ${package}.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import ${package}.domain.eo.Product;
import ${package}.domain.vm.ProductCreateVM;
import ${package}.dto.ProductDTO;
import ${package}.enums.ResultEnum;
import ${package}.manager.api.ProductBaseApi;
import ${package}.mapper.ProductMapper;
import ${package}.service.ProductService;
import com.deepexi.util.extension.ApplicationException;
import com.deepexi.util.pageHelper.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:
 * @program: ProductServiceImpl
 * @author: donh
 * @mail: hudong@deepexi.com
 * @create: 2019/3/27 下午2:13
 **/
@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductBaseApi productBaseApi;

    @Autowired
    private ProductMapper productMapper;

    /**
     * @param page :
     * @param size :
     * @param price  :
     * @Description:
     * @return: com.deepexi.util.pageHelper.PageBean
     * @Author: donh
     * @Date: 2019/3/27 下午1:55
     */
    @Override
    public PageBean getProductList(Integer page, Integer size, Integer price) {
        PageHelper.startPage(page, size);
        List<ProductDTO> userTasks = productMapper.selectPageVo(price);
        return new PageBean<>(userTasks);
    }

    /**
     * @param productCreateVM :
     * @Description:
     * @return: java.lang.Integer
     * @Author: donh
     * @Date: 2019/3/27 下午1:55
     */
    @Override
    public Boolean createProduct(ProductCreateVM productCreateVM) {
        Product product = new Product();
//        BeanHelper.copyProperties(productCreateQuery, product);
        product.setName(productCreateVM.getName());
        product.setPrice(productCreateVM.getPrice());
        product.setTenantId("10001");
        productBaseApi.createProduct(product);
        return true;
    }

    /**
     * @param id :
     * @Description:
     * @return: java.lang.Boolean
     * @Author: donh
     * @Date: 2019/3/27 下午1:55
     */
    @Override
    public Boolean deleteProductById(String id) {
        productBaseApi.deleteProductById(id);
        return true;
    }

    /**
     * @param id :
     * @Description:
     * @return: com.deepexi.demo.domain.eo.Product
     * @Author: donh
     * @Date: 2019/3/27 下午2:12
     */
    @Override
    @SentinelResource(value = "testSentinel", fallback = "doFallback", blockHandler = "exceptionHandler")
    public ProductDTO getProductById(String id) {
        // dubbo生产者被消费者调用时，客户端隐式传入的参数
        String tenantId = RpcContext.getContext().getAttachment("tenantId");
        logger.info("获取客户端隐式参数，tenantId：{}", tenantId);
        Product product = productBaseApi.getProductById(id);
        return new ProductDTO(product.getName(), 1);
    }

    /**
     * @param i :
     * @Description: 描述
     * @return: java.lang.String
     * @Author: donh
     * @Date: 2019/3/27 下午2:10
     */
    public String doFallback(long i) {
        // Return fallback value.
        return "Oops, degraded";
    }

    /**
     * @param s  :
     * @param ex :
     * @Description: 熔断降及处理逻辑
     * @return: void
     * @Author: donh
     * @Date: 2019/3/27 下午2:09
     */
    public void exceptionHandler(long s, Exception ex) {
        // Do some log here.
        logger.info("-------------熔断降级处理逻辑---------\n");
        throw new ApplicationException(ResultEnum.NETWORK_LIMIT);
    }

    /**
     * @Description: 测试框架统一捕获处理内部处理异常
     * @return: void
     * @Author: donh
     * @Date: 2019/3/27 下午1:56
     */
    @Override
    public void testError() {
        throw new ApplicationException(ResultEnum.USER_EXIST);
    }

    /**
     * @Description: 测试rpc调用时服务端抛出自定义异常，调用端是否能正常处理
     * @return: void
     * @Author: donh
     * @Date: 2019/3/27 下午1:57
     */
    @Override
    public void testRpcError() {
        throw new ApplicationException(ResultEnum.RPC_ERROR);
    }
}