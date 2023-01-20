package com.example.encherews.controller;

import com.example.encherews.model.Products;
import com.example.encherews.model.User;
import com.example.encherews.service.ProductsService;
import com.example.encherews.service.UserService;
import com.example.encherews.utile.MyJson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductsCnt {

    ProductsService productsService;

    public ResponseEntity<?> getAll(){
        List<Products> list=null;
        MyJson mj = new MyJson();
        try {
            list=productsService.getAll();
            mj.setData(list);
        }
        catch (Exception e){
            mj.setError(e);
        }
        return ResponseEntity.ok(mj);
    }
}
