package com.example.encherews.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "bankrequest")
public class BankRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idbankaccount")
    private BankAccount bankAccount;

    @Column(name = "requestedamount")
    private double requestedAmount;

    @Column(name = "requestdate")
    private Timestamp requestDate;

    @Column(name = "isconfirmed")
    private boolean isConfirmed;


}
