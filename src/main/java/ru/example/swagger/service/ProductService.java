package ru.example.swagger.service;

import ru.example.swagger.domain.Product;

public interface ProductService {

    Iterable<Product> listAllProducts();

    Product getProductById(Integer productID);

    Product saveProduct(Product product);

    void deleteProduct(Integer productID);

}
