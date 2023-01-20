package com.example.encherews.repository;

import com.example.encherews.model.BankRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRequestRep extends JpaRepository<BankRequest,Integer> {
}
