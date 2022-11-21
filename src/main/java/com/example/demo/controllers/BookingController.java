package com.example.demo.controllers;

import com.example.demo.model.booking;
import com.example.demo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {
    private final BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService1) { this.bookingService = bookingService1; }

    public List<booking> getBookings() {
        return bookingService.getBookings();
    }
    public booking getBookingById(int id) {
        return bookingService.getBookingById(id);
    }
    public String deleteBooking(int id) {
        return bookingService.deleteBooking(id);
    }
}
