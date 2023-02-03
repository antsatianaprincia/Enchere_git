package com.example.encherews.repository;


import com.example.encherews.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface AuctionRep extends JpaRepository<Auction,Integer> {

//    @Query(value = "Select * from auction join products on auction.idproducts=products.id where descriptions LIKE %?1% or pubdate::text LIKE %?2% or price::text LIKE %?3% or isClosed::text LIKE %?4% name LIKE %?5%)",nativeQuery = true)
//    public List<Auction> findByDescriptionsOrPubDateOrPriceOrIsClosed(String descriptions, Timestamp pubDate, double price, int idClosed);


     public List<Auction> findByDescriptionsOrPubDateOrPriceOrIsClosed(String descriptions, Timestamp pubDate, double price, int idClosed);

     @Query(value = "select * from v_enchereclient where iduser=?1",nativeQuery = true)
     public List<Auction> listeByIdUser(Integer iduser);


     @Query(value = "select a.* from auction a join products p on a.idproducts = p.id join users u on u.id = p.iduser where u.id=:idUser",nativeQuery = true)
     List<Auction> findAuctionUser(@Param("idUser") int idUser);



}
