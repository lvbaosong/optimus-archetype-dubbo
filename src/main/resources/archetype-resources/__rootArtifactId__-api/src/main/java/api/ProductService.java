package ${package}.api;

import ${package}.domain.eo.Product;

public interface ProductService {

    Object getProductList(Integer page, Integer size, Integer price);

    Object getProductById(String id);

    Object createProduct(Product product);

    Object deleteProductById(String id);

}
