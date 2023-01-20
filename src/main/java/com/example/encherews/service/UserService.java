package com.example.encherews.service;


import com.example.encherews.model.User;
import com.example.encherews.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRep userRep;

    public List<User> getAll(){
        return userRep.findAll();
    }

    public User findByEmailAndPassword(String email, String password){
        User user = userRep.findByEmailAndPassword(email, password);
        return user;
    }

    public User save(User user){
        return userRep.save(user);
    }

}
