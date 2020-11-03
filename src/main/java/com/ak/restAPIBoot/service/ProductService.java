package com.ak.restAPIBoot.service;

import auditing.InputRequest;
import com.ak.restAPIBoot.entity.Product;
import com.ak.restAPIBoot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product saveProduct(InputRequest<Product> request){
        request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
        Product product = request.getProduct();
        String currentUser = request.getLoggedInUser();
        product.setCreatedBy(currentUser);
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

    public Product updateProduct(InputRequest<Product> request) {
        Product product = request.getProduct();
        int id = product.getId();
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null){
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setModifiedBy(request.getLoggedInUser());
            return productRepository.save(existingProduct);
        }else {
            throw new RuntimeException("Product not found ");
        }
    }

}
