package com.onelity.bookme.controllers;

import com.onelity.bookme.model.booking;
import com.onelity.bookme.services.BookingService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService1) { this.bookingService = bookingService1; }

    public List<booking> getBookings() {
        return bookingService.getBookings();
    }
    public booking getBookingById(Integer id) {
        return bookingService.getBookingById(id);
    }
    public String deleteBooking(Integer id) {
        return bookingService.deleteBooking(id);
    }
}
