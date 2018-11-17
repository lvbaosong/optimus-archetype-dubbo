package ${package}.api;

import ${package}.domain.eo.Product;

public interface ProductService {

    Object getProductList(Integer page, Integer size, Integer price);

    Object getProductById(Integer id);

    Object createProduct(Product product);

    Object deleteProductById(Integer id);

}
