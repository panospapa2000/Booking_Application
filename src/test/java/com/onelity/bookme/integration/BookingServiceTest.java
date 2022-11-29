package com.onelity.bookme.integration;


import com.onelity.bookme.model.Booking;
import com.onelity.bookme.model.Room;
import com.onelity.bookme.service.BookingService;
import com.onelity.bookme.service.RoomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BookingServiceTest {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private RoomService roomService;

    private static final String BOOKING_TITLE1="Cyraco";
    private Room booking_Room1;
    private static final String BOOKING_DESCRIPTION_1 ="Cyraco Meeting";
    private static final String BOOKING_PARTICIPANTS_1 = "Kostas, Giorgos, Panos";

    String StartTimeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
    String EndTimeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());

    @Test
    public void bookingCRUD_positive_size(){
        List<Booking> OG_Bookings = bookingService.getBookings();
        Booking booking= new Booking();
        List<Room> rooms = roomService.getRooms();
        booking_Room1=rooms.get(2);
        booking.setRoom(booking_Room1);
        booking.setTitle(BOOKING_TITLE1);
        booking.setDescription(BOOKING_DESCRIPTION_1);
        booking.setStart_timestamp(Timestamp.valueOf(StartTimeStamp));
        booking.setEnd_timestamp(Timestamp.valueOf(EndTimeStamp));
        booking.setParticipants(BOOKING_PARTICIPANTS_1);
        bookingService.saveBooking(booking);
        List<Booking> storedBookings = bookingService.getBookings();
        Assertions.assertEquals(OG_Bookings.size() + 1, storedBookings.size());
    }

    @Test
    public void bookingCRUD_positive_credentials(){
        Booking booking = new Booking();
        List<Room> rooms = roomService.getRooms();
        booking_Room1=rooms.get(1);
        booking.setRoom(booking_Room1);
        booking.setTitle(BOOKING_TITLE1);
        booking.setDescription(BOOKING_DESCRIPTION_1);
        booking.setStart_timestamp(Timestamp.valueOf(StartTimeStamp));
        booking.setEnd_timestamp(Timestamp.valueOf(EndTimeStamp));
        booking.setParticipants(BOOKING_PARTICIPANTS_1);
        bookingService.saveBooking(booking);
        Optional<Booking> storedBooking = bookingService.getBookingById(booking.getId());
        Assertions.assertTrue(storedBooking.isPresent());
        Assertions.assertEquals(booking.getRoom().getId(), storedBooking.get().getRoom().getId());
        Assertions.assertEquals(booking.getTitle(), storedBooking.get().getTitle());
        Assertions.assertEquals(booking.getDescription(), storedBooking.get().getDescription());
        Assertions.assertEquals(booking.getParticipants(), storedBooking.get().getParticipants());
        Assertions.assertEquals(booking.getStart_timestamp(), storedBooking.get().getStart_timestamp());
        Assertions.assertEquals(booking.getEnd_timestamp(), storedBooking.get().getEnd_timestamp());
    }

    @Test
    public void bookingCRUD_delete(){
        bookingService.deleteAllBookings();
        List<Booking> bookingsDeleted = bookingService.getBookings();
        Assertions.assertEquals(0, bookingsDeleted.size());
    }

    @Test
    public void bookingCRUD_deleteById(){
        Booking booking = new Booking();
        List<Room> rooms = roomService.getRooms();
        booking_Room1=rooms.get(1);
        booking.setRoom(booking_Room1);
        booking.setTitle(BOOKING_TITLE1);
        booking.setDescription(BOOKING_DESCRIPTION_1);
        booking.setStart_timestamp(Timestamp.valueOf(StartTimeStamp));
        booking.setEnd_timestamp(Timestamp.valueOf(EndTimeStamp));
        booking.setParticipants(BOOKING_PARTICIPANTS_1);
        bookingService.saveBooking(booking);
        Optional<Booking> storedBooking = bookingService.getBookingById(booking.getId());
        bookingService.deleteBooking(storedBooking.get().getId());
        Optional<Booking> testBooking = bookingService.getBookingById(booking.getId());
        Assertions.assertNotEquals(storedBooking, testBooking);
    }
}
