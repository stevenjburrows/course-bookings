package com.codeclan.example.course.bookings.controllers;



import com.codeclan.example.course.bookings.models.Booking;
import com.codeclan.example.course.bookings.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllbookings(

            @RequestParam(name = "date", required = false) String date
    ) {

        if (date != null) {
            return new ResponseEntity<List<Booking>>(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<List<Booking>>(bookingRepository.findAll(), HttpStatus.OK);
    }


    @PostMapping(value = "/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PutMapping(value = "/bookings/{id}")
    public ResponseEntity<Booking> putBooking(@RequestBody Booking booking, @PathVariable Long id) {
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/bookings/{id}")
    public ResponseEntity<List<Booking>> deleteBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
        return new ResponseEntity<List<Booking>>(bookingRepository.findAll(), HttpStatus.OK);
    }
}
