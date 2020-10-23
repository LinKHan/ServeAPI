package com.ak.restAPIBoot.service;

import com.ak.restAPIBoot.entity.Product;
import com.ak.restAPIBoot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public Product getSingleProductById(int id){
        return productRepository.findById(id).orElse(null);
    }
    public Product getSingleProductByName(String name){
        return productRepository.findByName(name);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public String deleteProductById(int id){
        productRepository.deleteById(id);
        return " product removed from db id : " + id;
    }

    public Product updateProduct(Product product) {
        int id = product.getId();
        Product existingProduct = productRepository.findById(id).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }

}
