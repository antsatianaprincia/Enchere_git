package com.example.encherews.mongoRepository;

import com.example.encherews.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRep extends MongoRepository<Image,String> {

    public Image findByIdauction(int idauction);
}
