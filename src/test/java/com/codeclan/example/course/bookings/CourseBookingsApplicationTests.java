package com.codeclan.example.course.bookings;

import com.codeclan.example.course.bookings.models.Customer;
import com.codeclan.example.course.bookings.repositories.BookingRepository;
import com.codeclan.example.course.bookings.repositories.CourseRepository;
import com.codeclan.example.course.bookings.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseBookingsApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}



}
