package com.example.demo.services;
import com.example.demo.model.booking;
import com.example.demo.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
