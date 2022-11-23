package com.onelity.bookme.Service;

import com.onelity.bookme.model.Booking;
import com.onelity.bookme.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public String deleteBooking(int id){
        bookingRepository.deleteById(id);
        return "booking removed!" + id;
    }

}
