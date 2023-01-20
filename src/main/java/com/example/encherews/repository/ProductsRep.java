package com.example.encherews.repository;


import com.example.encherews.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRep extends JpaRepository<Products,Integer> {

}
