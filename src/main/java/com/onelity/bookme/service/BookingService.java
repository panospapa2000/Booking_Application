package com.onelity.bookme.service;

import com.onelity.bookme.model.Booking;
import com.onelity.bookme.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private BookingRepository bookingRepository;

    /**
     * BookingService works as a constructor dependency injection, using BookingRepository.
     * @param bookingRepository
     */
    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    /**
     * This method returns the list of all bookings from the database, via GET request.
     * @return
     */
    public List<Booking> getBookings(){
        return bookingRepository.findAll();
    }

    /**
     * This method returns a specific booking, given its unique id.
     * Also returns Optional.Empty if it does not exist.
     * @param id
     * @return
     */
    public Optional<Booking> getBookingById(int id){
        return  bookingRepository.findById(id);
    }

    /**
     * This method is serving a POST request of a specific booking.
     * @param booking
     * @return
     */
    public Booking saveBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    /**
     * This method deletes all bookings.
     */
    public void deleteAllBookings(){
        bookingRepository.deleteAll();
    }
    /**
     * This method is serving a DELETE request of a specific booking, given its id.
     * @param id
     */
    public void deleteBooking(int id){
        bookingRepository.deleteById(id);
    }
}
