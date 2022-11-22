package com.onelity.bookme.services;

import com.onelity.bookme.models.Booking;
import com.onelity.bookme.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getBookings(){
        return bookingRepository.findAll();
    }

    public Booking getBookingById(int id){
        return  bookingRepository.findById(id).orElse(null);
    }

    public String deleteBooking(int id){
        bookingRepository.deleteById(id);
        return "booking removed!" + id;
    }

}
