//after the service reaching out to repo this guy talks to db
package com.zeon.SpringEcommerce.repo;

import com.zeon.SpringEcommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> { //basically it maps to <Product which has tables given and then Integer> that is the @Id type
//    @Query(value = "SELECT * FROM product", nativeQuery = true)
//    List<Product> findAllProducts();
}
