package com.codeclan.example.course.bookings.controllers;

import com.codeclan.example.course.bookings.models.Customer;
import com.codeclan.example.course.bookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(

            @RequestParam(name = "courseName", required = false) String courseName
    ) {
        if (courseName != null) {
            return new ResponseEntity<List<Customer>>(customerRepository.findByBookingsCourseCourseName(courseName), HttpStatus.OK);
        }
        return new ResponseEntity<List<Customer>>(customerRepository.findAll(), HttpStatus.OK);
    }

}
