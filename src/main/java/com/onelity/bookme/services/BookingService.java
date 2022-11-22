package com.onelity.bookme.services;
import com.onelity.bookme.model.booking;
import com.onelity.bookme.repositories.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private BookingRepository bookingRepository;


    public List<booking> getBookings(){
        return bookingRepository.findAll();
    }

    public booking getBookingById(int id){
        return  bookingRepository.findById(id).orElse(null);
    }

    public String deleteBooking(int id){
        bookingRepository.deleteById(id);
        return "removed booking " + id;
    }

}
