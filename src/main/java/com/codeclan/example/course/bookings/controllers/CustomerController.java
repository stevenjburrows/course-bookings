package com.codeclan.example.course.bookings.controllers;

import com.codeclan.example.course.bookings.models.Customer;
import com.codeclan.example.course.bookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(

            @RequestParam(name = "courseName", required = false) String courseName,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "age", required = false) Integer age
    ) {
        if (age != null && town != null && courseName != null) {
            return new ResponseEntity<List<Customer>>(customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseCourseNameIgnoreCase(age, town, courseName), HttpStatus.OK);
        }
        if (town != null && courseName != null){
            return new ResponseEntity<List<Customer>>(customerRepository.findByTownIgnoreCaseAndBookingsCourseCourseNameIgnoreCase(town, courseName), HttpStatus.OK);
        }
        if (courseName != null) {
            return new ResponseEntity<List<Customer>>(customerRepository.findByBookingsCourseCourseNameIgnoreCase(courseName), HttpStatus.OK);
        }
        return new ResponseEntity<List<Customer>>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        if (customer.getId().longValue() != id){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
        return new ResponseEntity<List<Customer>>(customerRepository.findAll(), HttpStatus.OK);
    }
}
