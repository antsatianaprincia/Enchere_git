package com.example.encherews.repository;


import com.example.encherews.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRep extends JpaRepository<User,Integer> {

    public User findByEmailAndPassword(String email, String password);


}
