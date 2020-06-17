package com.codegym.controllers;

import com.codegym.models.Customer;
import com.codegym.services.CustomerService;
import com.codegym.services.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /* ---------------- GET ALL CUSTOMER ------------------------ */
    @GetMapping("/customers")
    public ResponseEntity<ServiceResult> findAllCustomer() {
        return new ResponseEntity<ServiceResult>(customerService.findAll(), HttpStatus.OK);
    }

    /* ---------------- GET CUSTOMER BY ID ------------------------ */
    @GetMapping("/customers/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(customerService.findById(id), HttpStatus.OK);
    }

    /* ---------------- CREATE NEW CUSTOMER ------------------------ */
    @PostMapping("/customers")
    public ResponseEntity<ServiceResult> create(@RequestBody Customer customer) {
        return new ResponseEntity<ServiceResult>(customerService.create(customer), HttpStatus.OK);
    }

    /* ---------------- UPDATE CUSTOMER ------------------------ */
    @PutMapping("/customers")
    public ResponseEntity<ServiceResult> update(@RequestBody Customer customer) {
        return new ResponseEntity<ServiceResult>(customerService.update(customer), HttpStatus.OK);
    }

    @DeleteMapping("/customers")
    public ResponseEntity<ServiceResult> delete(@RequestBody DeleteCustomerRequest request) {
        return new ResponseEntity<ServiceResult>(customerService.delete(request.getId()), HttpStatus.OK);
    }
}
