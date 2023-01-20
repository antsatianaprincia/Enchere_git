package com.example.encherews.repository;


import com.example.encherews.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRep extends JpaRepository<Category,Integer> {

}
