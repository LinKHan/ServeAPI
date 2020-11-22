package com.ak.restAPIBoot.controller;

import auditing.InputRequest;
import com.ak.restAPIBoot.entity.Product;
import com.ak.restAPIBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody InputRequest<Product> request){
        return productService.saveProduct(request);
    }

    @PostMapping("/addLists")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id){
        return productService.getSingleProductById(id);
    }

    /**
     * add name as request param
     * @param name
     * @return
     */
    @GetMapping()
    public Product findProductByName(@RequestParam(value = "name") String name){
        return productService.getSingleProductByName(name);
    }

    @GetMapping("/lists")
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
