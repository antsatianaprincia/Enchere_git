package com.example.encherews.model;

import jakarta.persistence.*;
import lombok.Data;
import com.example.encherews.model.User;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idToken;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User idUser;

    @Column(name = "valeur")
    private String valeur;

    @Column(name = "isvalable")
    private Boolean isValable;

    @Column(name = "dateexpiration")
    private LocalDateTime dateExpiration;


    public static String createToken(User user){
        String token = null;
        LocalDateTime dateNow = LocalDateTime.now();
        String date = dateNow.toString();
        token = user.getEmail()+user.getPassword()+date;
        return token;
    }

    //Date et heure Expiration : defini pour 24h
    public static LocalDateTime f_dateExpiration(){
        LocalDateTime dateNow = LocalDateTime.now();
        Long hour = Long.parseLong("24");
        dateNow = dateNow.plusHours(hour);
        return dateNow;
    }


}
