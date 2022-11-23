package com.onelity.bookme.controller;

import com.onelity.bookme.model.Booking;
import com.onelity.bookme.service.BookingService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService1) { this.bookingService = bookingService1; }

    public List<Booking> getBookings() {
        return bookingService.getBookings();
    }

    public Optional<Booking> getBookingById(Integer id) {
        return bookingService.getBookingById(id);
    }
    public void deleteBooking(Integer id) {
        bookingService.deleteBooking(id);
    }
}
