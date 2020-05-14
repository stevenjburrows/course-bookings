package com.codeclan.example.course.bookings.repositories;

import com.codeclan.example.course.bookings.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {


}
