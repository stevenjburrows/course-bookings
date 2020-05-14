package com.codeclan.example.course.bookings.repositories;

import com.codeclan.example.course.bookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseCourseName(String name);
}
