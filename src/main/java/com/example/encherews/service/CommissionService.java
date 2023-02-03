package com.example.encherews.service;


import com.example.encherews.model.Commission;
import com.example.encherews.repository.CommissionRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommissionService{

    @Autowired
    CommissionRep categoryRep;
    public List<Commission> getAll(){
        List<Commission> all = categoryRep.findAll();
        return all;
    };
}
