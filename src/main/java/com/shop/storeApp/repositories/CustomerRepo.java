package com.shop.storeApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shop.storeApp.entity.Customers;

public interface CustomerRepo extends JpaRepository<Customers, Integer> {

}
