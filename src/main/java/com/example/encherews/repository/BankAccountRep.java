package com.example.encherews.repository;



import com.example.encherews.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRep extends JpaRepository<BankAccount,Integer> {

}
