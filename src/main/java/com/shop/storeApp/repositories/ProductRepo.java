package com.shop.storeApp.repositories;

import com.shop.storeApp.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository <Products, Integer>{

}
