package com.codeclan.example.course.bookings.repositories;

import com.codeclan.example.course.bookings.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
