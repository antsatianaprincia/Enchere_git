package com.example.encherews.service;


import com.example.encherews.model.Commission;
import com.example.encherews.repository.CommissionRep;

import java.util.List;

public class CommissionService{


    CommissionRep categoryRep;
    public List<Commission> getAll(){
        List<Commission> all = categoryRep.findAll();
        return all;
    };
}
