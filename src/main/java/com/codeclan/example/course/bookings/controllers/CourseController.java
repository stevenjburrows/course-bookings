package com.codeclan.example.course.bookings.controllers;

import com.codeclan.example.course.bookings.models.Course;
import com.codeclan.example.course.bookings.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllcourses(

            @RequestParam(name = "rating", required = false) Integer rating,
            @RequestParam(name = "name", required = false)String name
    ) {
        if(rating != null) {
            return new ResponseEntity<List<Course>>(courseRepository.findByRating(rating), HttpStatus.OK);
        }

        if(name != null) {
            return new ResponseEntity<List<Course>>(courseRepository.findByBookingsCustomerName(name), HttpStatus.OK);
        }
        return new ResponseEntity<List<Course>>(courseRepository.findAll(), HttpStatus.OK);
    }
}
