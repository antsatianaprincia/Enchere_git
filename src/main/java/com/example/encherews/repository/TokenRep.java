package com.example.encherews.repository;

import com.example.encherews.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRep extends JpaRepository<Token, Integer> {

    @Query(value = "select * from token where id=?1", nativeQuery = true)
    public Token getById(Integer id);

    @Query(value = "Update token set isvalable=false where id=?1", nativeQuery = true)
    public void deconnexion(int idToken);

}
