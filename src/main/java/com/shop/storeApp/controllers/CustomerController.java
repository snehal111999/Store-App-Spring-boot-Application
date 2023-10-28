package com.shop.storeApp.controllers;
import java.util.List;
import com.shop.storeApp.DTO.CustomerDTO;
import com.shop.storeApp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    @GetMapping("/Customers")
//    public  listOfAllCustomers(){
//           return service.getCustomersList();
//    }

    @PostMapping(path = "/customer")
    public ResponseEntity<CustomerDTO> createCustomers (@RequestBody CustomerDTO customerDTO) {

        CustomerDTO addCustomer = this.customerService.createCustomer(customerDTO);

        return new ResponseEntity<>(addCustomer, HttpStatus.CREATED);
    }

    @GetMapping(path = "/customer/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("customerId") Integer id) {

        return ResponseEntity.ok(this.customerService.getCustomerbyId(id));
    }

    @PutMapping(path = "/customer/{customerId}")
    public ResponseEntity<CustomerDTO> updateCustomer (@RequestBody CustomerDTO customerDTO , @PathVariable("customerId") Integer id) {

        CustomerDTO editCustomer = this.customerService.updateCustomer(customerDTO , id);

        return new ResponseEntity<>(editCustomer, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/customer/{customerId}")
    public ResponseEntity<String> deleteCustomer (@PathVariable("customerId") Integer id) {

        this.customerService.deleteCustomer(id);
        String message = "deleted sucessfully";
        return new ResponseEntity<>( message , HttpStatus.OK);
    }

    @GetMapping(path = "/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {

        return ResponseEntity.ok(this.customerService.getAllCustomers());
    }

    @PatchMapping(path = "/customer/{customerId}")
    public ResponseEntity<String> patchCustomer(@RequestBody CustomerDTO customerDTO , @PathVariable("customerId") Integer id){
        customerService.patchCustomer(customerDTO , id);
        String message = "patched sucessfully";
        return new ResponseEntity<>(message , HttpStatus.OK);
    }


}
