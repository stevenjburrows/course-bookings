package com.codeclan.example.course.bookings.components;

import com.codeclan.example.course.bookings.repositories.BookingRepository;
import com.codeclan.example.course.bookings.repositories.CourseRepository;
import com.codeclan.example.course.bookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
