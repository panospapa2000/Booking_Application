package com.onelity.bookme.controller;

import com.onelity.bookme.model.Booking;
import com.onelity.bookme.service.BookingService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService1) { this.bookingService = bookingService1; }

    public List<Booking> getBookings() {
        return bookingService.getBookings();
    }
    public Booking getBookingById(Integer id) {
        return bookingService.getBookingById(id);
    }
    public String deleteBooking(Integer id) {
        return bookingService.deleteBooking(id);
    }
}
