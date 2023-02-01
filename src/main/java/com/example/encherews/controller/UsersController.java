package com.example.encherews.controller;

import com.example.encherews.model.Token;
import com.example.encherews.model.User;
import com.example.encherews.repository.TokenRep;
import com.example.encherews.service.TokenService;
import com.example.encherews.service.UserService;
import com.example.encherews.utile.MyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @Autowired
    TokenRep tokenRep;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<User> list=null;
        MyJson mj = new MyJson();
        try {
            list=userService.getAll();
            mj.setData(list);
        }
        catch (Exception e){
            mj.setError(e);
        }
        return ResponseEntity.ok(mj);
    }

    @PostMapping
    public ResponseEntity<User> inscription(@RequestBody User utilisateur){
        User user = null;
        try {
            user= userService.save(utilisateur);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Token> log(@RequestBody User utilisateur){
        Token generateToken = null;
        try{
            User user = userService.findByEmailAndPassword(utilisateur.getEmail(), utilisateur.getPassword());

            Token token = new Token();
            token.setIdUser(user);
            String valeurs = Token.createToken(user);
            token.setValeur(valeurs);
            token.setIsValable(true);

            //Devra à nouveau se connecter après 24h car la dateExpiration est après 24h
            LocalDateTime dateExp = Token.f_dateExpiration();

            token.setDateExpiration(dateExp);
            generateToken = tokenService.save(token);
            Token t = tokenRep.getById(generateToken.getIdToken());
        }

        catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(generateToken);
    }




}
