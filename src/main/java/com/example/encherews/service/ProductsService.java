package com.example.encherews.service;


import com.example.encherews.model.Products;
import com.example.encherews.repository.ProductsRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductsService {

            @Autowired
            ProductsRep productsRep;
            public List<Products> getAll(){
                return productsRep.findAll();
            }
}
