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

@SpringBootTest
public class BookingServiceTest {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private RoomService roomService;
    private static final String BOOKING_TITLE = "Cyraco";
    private Room booking_Room1;
    private static final String BOOKING_DESCRIPTION ="Cyraco Meeting";
    private static final String BOOKING_PARTICIPANTS = "Kostas, Giorgos, Panos";

    String StartTimeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
    String EndTimeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
    @Test
    public void bookingCRUD_positive_size(){
        List<Booking> OG_Bookings = bookingService.getBookings();
        Booking booking= new Booking();
        List<Room> rooms = roomService.getRooms();
        booking_Room1=rooms.get(2);
        booking.setRoom(booking_Room1);
        booking.setTitle(BOOKING_TITLE);
        booking.setDescription(BOOKING_DESCRIPTION);
        booking.setStart_timestamp(Timestamp.valueOf(StartTimeStamp));
        booking.setEnd_timestamp(Timestamp.valueOf(EndTimeStamp));
        booking.setParticipants(BOOKING_PARTICIPANTS);
        bookingService.saveBooking(booking);
        List<Booking> storedBookings = bookingService.getBookings();
        Assertions.assertEquals(OG_Bookings.size() + 1, storedBookings.size());
        bookingService.deleteBooking(booking.getId());
        List<Booking> storedBookingsFinal = bookingService.getBookings();
        Assertions.assertEquals(OG_Bookings.size(),storedBookingsFinal.size());
    }

    @Test
    public void bookingCRUD_positive_credentials(){
        Booking booking = new Booking();
        List<Room> rooms = roomService.getRooms();
        booking_Room1=rooms.get(1);
        booking.setRoom(booking_Room1);
        booking.setTitle(BOOKING_TITLE);
        booking.setDescription(BOOKING_DESCRIPTION);
        booking.setStart_timestamp(Timestamp.valueOf(StartTimeStamp));
        booking.setEnd_timestamp(Timestamp.valueOf(EndTimeStamp));
        booking.setParticipants(BOOKING_PARTICIPANTS);
        bookingService.saveBooking(booking);
        Optional<Booking> storedBooking = bookingService.getBookingById(booking.getId());
        Assertions.assertTrue(storedBooking.isPresent());
        Assertions.assertEquals(booking.getRoom().getId(), storedBooking.get().getRoom().getId());
        Assertions.assertEquals(booking.getTitle(), storedBooking.get().getTitle());
        Assertions.assertEquals(booking.getDescription(), storedBooking.get().getDescription());
        Assertions.assertEquals(booking.getParticipants(), storedBooking.get().getParticipants());
        Assertions.assertEquals(booking.getStart_timestamp(), storedBooking.get().getStart_timestamp());
        Assertions.assertEquals(booking.getEnd_timestamp(), storedBooking.get().getEnd_timestamp());
        bookingService.deleteBooking(storedBooking.get().getId());
        Optional<Booking> storedBookingFinal = bookingService.getBookingById(booking.getId());
        Assertions.assertTrue(storedBookingFinal.isEmpty());
    }

    @Test
    public void bookingCRUD_delete(){
        List<Booking> OG_Bookings = bookingService.getBookings();
        bookingService.deleteAllBookings();
        List<Booking> bookingsDeleted = bookingService.getBookings();
        Assertions.assertEquals(0, bookingsDeleted.size());
        bookingService.saveBookings(OG_Bookings);
    }

    @Test
    public void bookingCRUD_deleteById(){
        Booking booking = new Booking();
        List<Room> rooms = roomService.getRooms();
        booking_Room1=rooms.get(1);
        booking.setRoom(booking_Room1);
        booking.setTitle(BOOKING_TITLE);
        booking.setDescription(BOOKING_DESCRIPTION);
        booking.setStart_timestamp(Timestamp.valueOf(StartTimeStamp));
        booking.setEnd_timestamp(Timestamp.valueOf(EndTimeStamp));
        booking.setParticipants(BOOKING_PARTICIPANTS);
        bookingService.saveBooking(booking);
        Optional<Booking> storedBooking = bookingService.getBookingById(booking.getId());
        bookingService.deleteBooking(storedBooking.get().getId());
        Optional<Booking> testBooking = bookingService.getBookingById(booking.getId());
        Assertions.assertNotEquals(storedBooking, testBooking);
    }
}
