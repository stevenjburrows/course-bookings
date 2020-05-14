package com.codeclan.example.course.bookings.components;

import com.codeclan.example.course.bookings.models.Booking;
import com.codeclan.example.course.bookings.models.Course;
import com.codeclan.example.course.bookings.models.Customer;
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

        Course java = new Course("Java", "Edinburgh", 4);
        courseRepository.save(java);
        Course python = new Course("Python", "Livingston", 2);
        courseRepository.save(python);
        Course ruby = new Course("Ruby", "Glasgow", 5);
        courseRepository.save(ruby);


        Customer john = new Customer("John","Stirling",32);
        customerRepository.save(john);

        Customer ian = new Customer("Ian","Belfast",35);
        customerRepository.save(ian);

        Customer rob = new Customer("Rob","Armadale",29);
        customerRepository.save(rob);

        Booking booking1 = new Booking("23-04-2020", java, john);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("23-04-2020", python, ian);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("23-04-2020", java, rob);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("23-04-2020", ruby, john);
        bookingRepository.save(booking4);







    }
}
