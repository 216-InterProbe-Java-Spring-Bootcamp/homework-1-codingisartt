package com.tubanurbalci.userproductproject.repository;

import com.tubanurbalci.userproductproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByExpirationDateLessThan(Date expirationDate);

    List<Product> findAllByExpirationDateAfter(Date expirationDate);
}
