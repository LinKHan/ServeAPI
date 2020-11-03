package com.ak.restAPIBoot.controller;

import auditing.InputRequest;
import com.ak.restAPIBoot.entity.Product;
import com.ak.restAPIBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody InputRequest<Product> request){
        return productService.saveProduct(request);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
        return productService.getSingleProductById(id);
    }

    @GetMapping("/productByName/{name}")
    public Product findProductByName(@PathVariable String name){
        return productService.getSingleProductByName(name);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody InputRequest<Product> request){
        return productService.updateProduct(request);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProductById(id);
    }


}
