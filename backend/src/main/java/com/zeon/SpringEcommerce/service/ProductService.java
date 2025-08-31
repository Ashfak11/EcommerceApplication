//Business logic or logic to talk to repo layer
package com.zeon.SpringEcommerce.service;


import com.zeon.SpringEcommerce.model.Product;
import com.zeon.SpringEcommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException, IOException {
        //setting all thew values before saving it inside the db
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());

        return productRepo.save(product);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
//His approach on updating
//    public Product updateProduct(Product product, MultipartFile image) throws IOException {
//        product.setImageName(image.getOriginalFilename());
//        product.setImageType(image.getContentType());
//        product.setImageData(image.getBytes());
//
//        return productRepo.save(product);
//    }


    //update
//    public Product updateProduct(int id, Product updatedProduct) {
//        Optional<Product> optionalProduct = productRepo.findById(id); //tries to fetch a Product from the db using the given id
//        if (optionalProduct.isEmpty()) { //checks if the product exists.
//            return null;
//        }
//        Product existing = optionalProduct.get(); //extracts the actual Product object from the Optional container.
//
//        if (updatedProduct.getName() != null) { // will be null if did not made any changes
//            //takes the updated value and replaces with the existing one
//            existing.setName(updatedProduct.getName()); // runs if the above is true(takes the new value from updatedproduct and overwrites the name in the existing db obj
//        }
//
//        if (updatedProduct.getDescription() != null) {
//            existing.setDescription(updatedProduct.getDescription());
//        }

//        if (updatedProduct.getBrand() != null) {
//            existing.setBrand(updatedProduct.getBrand());
//        }
//
//        if (updatedProduct.getPrice() != null) {
//            existing.setPrice(updatedProduct.getPrice());
//        }
//
//        if (updatedProduct.getCategory() != null) {
//            existing.setCategory(updatedProduct.getCategory());
//        }
//
//        if (updatedProduct.getReleaseDate() != null) {
//            existing.setReleaseDate(updatedProduct.getReleaseDate());
//        }

//        if (updatedProduct.getProductAvailable() != null) {
//            existing.setProductAvailable(updatedProduct.getProductAvailable());
//        }

//        if (updatedProduct.getStockQuantity() != null) {
//            existing.setStockQuantity(updatedProduct.getStockQuantity());
//        }

        // Step 3: save updated product
//        return productRepo.save(existing);
//
//    }
}