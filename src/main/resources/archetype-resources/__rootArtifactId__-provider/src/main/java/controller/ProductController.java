package ${package}.controller;

import ${package}.api.ProductService;
import ${package}.domain.eo.Product;
import com.deepexi.util.config.Payload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductService productService;

    @GetMapping
    public Payload getProductList(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                                  @RequestParam(name = "age", required = false, defaultValue = "0") Integer price) {
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
}
