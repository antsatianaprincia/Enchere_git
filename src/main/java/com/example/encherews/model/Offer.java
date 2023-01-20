package com.example.encherews.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idauction")
    private Auction idAuction;

    @Column(name = "amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    @Column(name = "dateoffer")
    private Timestamp dateOffer;
}
