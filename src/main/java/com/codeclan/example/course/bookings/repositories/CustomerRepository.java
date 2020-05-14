package com.codeclan.example.course.bookings.repositories;

import com.codeclan.example.course.bookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseCourseNameIgnoreCase(String name);

    List<Customer> findByTownIgnoreCaseAndBookingsCourseCourseNameIgnoreCase(String town, String name);

    List<Customer> findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseCourseNameIgnoreCase(int age,String town, String name);
}
