package com.onelity.bookme.Service;

import com.onelity.bookme.model.Booking;
import com.onelity.bookme.repository.BookingRepository;
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
