package com.shop.storeApp.services;

import com.shop.storeApp.entity.Customers;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/* this class is only for demo purpose without connecting to db adding data by list*/
@Component
public class CustomersDaoService {
    private static List <Customers> customersList = new ArrayList<>();

     //Date D = new Date("2023-08-13");
    /*
    static {
        customersList.add(new Customers(1 , "rohit" , 1234567890 , "pune"));
        customersList.add(new Customers(2 ,"asmita" , 234567894 , "kolhapur"));
        customersList.add(new Customers(3 ,"abhijeet" , 348759435 , "kolhapur"));
    }



    public List <Customers> getCustomersList(){
        return customersList;
    }

   */
}
