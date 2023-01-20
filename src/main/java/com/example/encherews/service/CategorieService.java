package com.example.encherews.service;

import com.example.encherews.model.Category;
import com.example.encherews.repository.CategoryRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService  {
    @Autowired
    CategoryRep categoryRep;
    public List<Category> getAll(){
        List<Category> all = categoryRep.findAll();
        return all;
    };
}
