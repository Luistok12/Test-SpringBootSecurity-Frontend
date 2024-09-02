package com.springsecurity.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.springsecurity.models.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

}
