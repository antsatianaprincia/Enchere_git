package com.example.encherews.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


import java.util.Date;

@Entity
@Data
@Table(name = "auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "pubdate")
    private Date pubDate ;

    @Column(name = "descriptions")
    private String descriptions;

    @Column(name = "price")
    private double price;

    @Column(name = "minprice")
    double minPrice;

    @Column(name = "soldprice")
    double soldPrice;

    @ManyToOne
    @JoinColumn(name = "idproducts")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "idduration")
    private Duration duration;

    @Column(name = "isclosed")
    private int isClosed;




}
