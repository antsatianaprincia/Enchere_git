package com.example.encherews.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Image {

    @Id
    private String id;

    private String nom;

    private int idauction;


}
