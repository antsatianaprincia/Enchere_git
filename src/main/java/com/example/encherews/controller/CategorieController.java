package com.example.encherews.controller;


import com.example.encherews.model.Category;
import com.example.encherews.service.CategorieService;
import com.example.encherews.utile.MyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {

        @Autowired
        CategorieService categorieService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Category> list=null;
        MyJson mj = new MyJson();
        try {
            list=categorieService.getAll();
            mj.setData(list);
        }
        catch (Exception e){
            mj.setError(e);
        }
        return ResponseEntity.ok(mj);
    }
    @GetMapping("/hello")
    public String HelloWorld(){
        return "hello world";
    }
}
