//Business logic or logic to talk to repo layer
package com.zeon.SpringEcommerce.service;


import com.zeon.SpringEcommerce.model.Product;
import com.zeon.SpringEcommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

//    public HttpStatusCode getAllProducts;
    @Autowired
    private ProductRepo productRepo; //this connects it with repo layer


    public List<Product> getAllProducts() {

        return productRepo.findAll();//.findall() provided by jpa by default

    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(new Product(-1));
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException, IOException {
        //setting all thew values before saving it inside the db
//        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());

        return productRepo.save(product);
    }
}