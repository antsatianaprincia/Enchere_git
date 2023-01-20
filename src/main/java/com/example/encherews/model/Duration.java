package com.example.encherews.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "duration")
public class Duration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "duration")
    private double duration;

}

