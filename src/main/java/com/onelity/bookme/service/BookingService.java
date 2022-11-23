package com.onelity.bookme.service;

import com.onelity.bookme.model.Booking;
import com.onelity.bookme.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getBookings(){
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(int id){
        return  bookingRepository.findById(id);
    }

    public void deleteBooking(int id){
        bookingRepository.deleteById(id);
    }

}
