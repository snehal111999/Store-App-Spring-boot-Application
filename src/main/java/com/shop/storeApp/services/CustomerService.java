package com.shop.storeApp.services;

import com.shop.storeApp.DTO.CustomerDTO;


import java.util.List;

public interface CustomerService {

    CustomerDTO createCustomer(CustomerDTO customer);

    CustomerDTO getCustomerbyId (Integer CustomerId);

    CustomerDTO updateCustomer(CustomerDTO customer , Integer CustomerId);

    void deleteCustomer(Integer CustomerId);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO patchCustomer(CustomerDTO customerDTO , Integer CustomerId);
}
