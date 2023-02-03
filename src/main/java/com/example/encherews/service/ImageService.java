package com.example.encherews.service;

import com.example.encherews.model.Image;
import com.example.encherews.mongoRepository.ImageRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    ImageRep imageRep;

    public Image findByIdAuction(int idAuction){
        return imageRep.findByIdauction(idAuction);
    }

    public Image save(Image image){
        return imageRep.save(image);
    }
}
