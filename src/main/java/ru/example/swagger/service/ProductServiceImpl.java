package ru.example.swagger.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.swagger.domain.Product;
import ru.example.swagger.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> listAllProducts() {
        logger.debug("List all products called.");
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer productID) {
        logger.debug("Get product by id called.");
        return this.productRepository.findById(productID).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        logger.debug("Save product called.");
        return this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer productID) {
        logger.debug("Delete product called.");
        this.productRepository.deleteById(productID);
    }
}
