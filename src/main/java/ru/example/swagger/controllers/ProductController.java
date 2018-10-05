package ru.example.swagger.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.example.swagger.domain.Product;
import ru.example.swagger.service.ProductService;

import javax.xml.ws.Response;

@RestController
@RequestMapping(value = "/product")
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class ProductController {

    @Autowired
    private ProductService productService;


    @ApiOperation(value = "View list of available products", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list."),
            @ApiResponse(code = 401, message = "You are not authorized to view the resources."),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Product> list(Model model) {
        Iterable<Product> products = this.productService.listAllProducts();
        return products;
    }

    @ApiOperation(value = "Search product with a ID", response = Product.class)
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public Product showProduct(@PathVariable("id") Integer id) {
        Product product = this.productService.getProductById(id);
        return product;
    }

    @ApiOperation(value = "Add a product")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveProduct(@RequestBody Product product) {
        this.productService.saveProduct(product);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update a product")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        Product storedProduct = this.productService.getProductById(id);
        storedProduct.setDescription(product.getDescription());
        storedProduct.setImgUrl(product.getImgUrl());
        storedProduct.setPrice(product.getPrice());
        this.productService.saveProduct(storedProduct);
        return new ResponseEntity("Product successfully updated", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a product")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        this.productService.deleteProduct(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }

}
