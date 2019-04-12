package ${package}.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import ${package}.domain.dto.ProductDto;
import ${package}.domain.eo.Product;
import ${package}.enums.ResultEnum;
import ${package}.service.ProductService;
import com.deepexi.util.config.Payload;
import com.deepexi.util.extension.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductService productService;

    @GetMapping
    public Payload getProductList(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                                  @RequestParam(name = "price", required = false, defaultValue = "0") Integer price) {
        return new Payload(productService.getProductList(page, size, price));
    }

    @GetMapping("/{id:[a-zA-Z0-9]+}")
    public Payload getProductById(@PathVariable("id") String id) {
        return new Payload(productService.getProductById(id));
    }

    @PostMapping
    public Payload createProduct(@RequestBody Product product) {
        return new Payload(productService.createProduct(product));
    }

    @PutMapping("/{id:[a-zA-Z0-9]+}")
    public Payload updateProductById(@PathVariable("id") String id, Product product) {
        return new Payload(null);
    }

    @DeleteMapping("/{id:[a-zA-Z0-9]+}")
    public Payload deleteProductById(@PathVariable("id") String id) {
        return new Payload(productService.deleteProductById(id));
    }

    /**
     * 测试统一异常处理
     * @return
     */
    @GetMapping("/testError")
    public Payload testError() {
        productService.testError();
        return new Payload(true);
    }

    /**
     * 测试sentinel限流
     * @return
     */
    @GetMapping("/testSentinel")
    @SentinelResource(value = "testSentinel", blockHandler = "exceptionHandler")
    public Payload testSentinel() {
        logger.info("远程Sentinel测试接口成功: Hello World!!");
        return new Payload(true);
    }

    /**
     * 熔断降级处理逻辑
     * @param s
     * @param ex
     * @return
     */
    public Payload exceptionHandler(long s, BlockException ex) {
        // Do some log here.
        logger.info("-------------熔断降级处理逻辑---------\n");
        throw new ApplicationException(ResultEnum.NETWORK_LIMIT);
    }

    /**
     * 绑定参数校验demo，测试post方式
     */
    @PostMapping("/testPostValidate")
    public Payload testPostValidate(@Min(value = 5, message = "id必须大于等于5")@RequestParam Integer id,
                                    @Valid @RequestBody ProductDto productDto) {
        return new Payload(true);
    }

    /**
     * 绑定参数校验demo2，测试get url传参方式
     * 参数少时可以直接列出来单独写
     * 参数多时可以选择封装成dto对象
     */
    @GetMapping("/testGetValidate")
    public Payload testGetValidate(@Min(value = 5, message = "id必须大于等于5")@RequestParam Integer id,
                                   @Valid ProductDto productDto) {
        return new Payload(true);
    }

    @GetMapping("/testRpcError")
    public Payload testRpcError() {
        productService.testRpcError();
        return new Payload(true);
    }

}
