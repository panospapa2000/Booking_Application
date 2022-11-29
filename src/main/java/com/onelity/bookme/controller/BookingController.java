package com.onelity.bookme.controller;
import com.onelity.bookme.dto.BookingDTO;
import com.onelity.bookme.model.Admin;
import com.onelity.bookme.model.Booking;
import com.onelity.bookme.service.BookingService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService1) { this.bookingService = bookingService1; }

    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        return bookingService.getBookings();
    }
    @GetMapping("/bookings/{id}")
    public Optional<Booking> getBookingById(@PathVariable(value = "id") Integer id) {
        return bookingService.getBookingById(id);
    }
    @DeleteMapping("/bookings")
    public void deleteAllBookings(){
        bookingService.deleteAllBookings();
    }
    @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable(value = "id") Integer id) {
        bookingService.deleteBooking(id);
    }
    @PostMapping("/bookings")
    public Booking saveBooking(@RequestBody BookingDTO bookingDto) {
        Booking booking = bookingDto.convertToEntity();
        return bookingService.saveBooking(booking);
    }

    @PostMapping("/bookingsList")
    public List<Booking> saveAllBookings(@RequestBody List<Booking> bookings) {
        return bookingService.saveBookings(bookings);
    }
}
