package com.shop.storeApp.services.impl;
import com.shop.storeApp.entity.Customers;
import com.shop.storeApp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import com.shop.storeApp.DTO.CustomerDTO;
import com.shop.storeApp.repositories.CustomerRepo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	public Customers dtoToCustomers(CustomerDTO dto) {

		Customers customer = new Customers();

		customer.setCustomerName(dto.getCustomerName());
		customer.setPhoneNum(dto.getPhoneNum());
		customer.setLocation(dto.getLocation());
		return customer;
	}

	public CustomerDTO customerToDto(Customers customer) {

		CustomerDTO dto = new CustomerDTO();

		dto.setCustomerId(customer.getCustomerId());
		dto.setCustomerName(customer.getCustomerName());
		dto.setPhoneNum(customer.getPhoneNum());
		dto.setLocation(customer.getLocation());
		return dto;
	}

	@Override
	public CustomerDTO createCustomer(CustomerDTO customerDTO) {

		Customers customer = this.dtoToCustomers(customerDTO);

		Customers createdCustomer = this.customerRepo.save(customer);

		return this.customerToDto(createdCustomer);
	}

	@Override
	public CustomerDTO getCustomerbyId(Integer customerId) {

		Optional<Customers> customer = customerRepo.findById(customerId);

		return this.customerToDto(customer.get());
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO, Integer customerId) {
		Optional<Customers> updateCustomer = customerRepo.findById(customerId);

		Customers customer = updateCustomer.get();

		if (updateCustomer.isPresent()) {
			customer.setCustomerName(customerDTO.getCustomerName());
			customer.setPhoneNum(customerDTO.getPhoneNum());
			customer.setLocation(customerDTO.getLocation());

			Customers updatedCustomer = customerRepo.save(customer);

			return this.customerToDto(updatedCustomer);

		} else {
			return null;
		}
	}
	@Override
	public void deleteCustomer(Integer customerId) {
		Optional<Customers> deletecustomer = customerRepo.findById(customerId);
		Customers customer = deletecustomer.get();
		this.customerRepo.delete(customer);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {

		List<Customers> customer = this.customerRepo.findAll();

		List<CustomerDTO> allCustomers = new ArrayList<>();

		for (Customers customerObj : customer) {
			allCustomers.add(customerToDto(customerObj));
		}
		return allCustomers;
	}

	@Override
	public CustomerDTO patchCustomer(CustomerDTO customerDTO, Integer customerId) {

		Optional<Customers> patchCustomer = customerRepo.findById(customerId);

		if (patchCustomer.isPresent()) {
			Customers customer = patchCustomer.get();
			customer.setCustomerId(customer.getCustomerId());
			if (!(customerDTO.getCustomerName() == null || customerDTO.getCustomerName().equals(""))) {
				customer.setCustomerName(customerDTO.getCustomerName());
			} else {
				customer.setCustomerName(customer.getCustomerName());
			}
			if (!(customerDTO.getLocation() == null || customerDTO.getLocation().equals(""))) {
				customer.setLocation(customerDTO.getLocation());
			} else {
				customer.setLocation(customer.getLocation());
			}
			if (!(customerDTO.getPhoneNum() == null || customerDTO.getPhoneNum().equals(""))) {
				customer.setPhoneNum(customerDTO.getPhoneNum());
			} else {
				customer.setPhoneNum(customer.getPhoneNum());
			}
			customerRepo.save(customer);
			return customerDTO;
		}
		return null;
	}
}
