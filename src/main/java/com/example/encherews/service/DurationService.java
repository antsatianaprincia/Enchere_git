package com.example.encherews.service;


import com.example.encherews.model.Duration;
import com.example.encherews.repository.DurationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DurationService {

    @Autowired
    DurationRep durationRep;

    public List<Duration> getAll(){
        return durationRep.findAll();
    }
}
