package com.example.encherews.service;

import com.example.encherews.model.Token;
import com.example.encherews.repository.TokenRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    TokenRep tokenRep;

    public Token save(Token token){
        Token t = tokenRep.save(token);
        //return t;
        return tokenRep.getById(t.getIdToken()) ;
    }


    //Pour faire le controle des token si elles sont encore valide
    public Boolean bearerToken( Token token){
        try {
            Token t = tokenRep.getById(token.getIdToken());
            if (t.getIsValable()){
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void deconnexion(Token token){
        tokenRep.deconnexion(token.getIdToken());
    }

}
