package com.example.encherews.controller;

import com.example.encherews.model.*;
import com.example.encherews.service.DurationService;
import com.example.encherews.utile.MyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/durations")
public class Duration {
    @Autowired
    DurationService durationService;

    public ResponseEntity<?> getAll(){
        List list=null;
        MyJson mj = new MyJson();
        try {
            list=durationService.getAll();
            mj.setData(list);
        }
        catch (Exception e){
            mj.setError(e);
        }
        return ResponseEntity.ok(mj);
    }
}
