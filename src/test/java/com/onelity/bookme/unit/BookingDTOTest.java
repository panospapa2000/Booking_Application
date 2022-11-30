package com.onelity.bookme.unit;

import com.onelity.bookme.dto.BookingDTO;
import com.onelity.bookme.model.Booking;
import com.onelity.bookme.model.Room;
import com.onelity.bookme.service.BookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BookingDTOTest {

    @Autowired
    private BookingService bookingService;

    private static final String BOOKING_TITLE="Cyraco";
    private Room booking_Room;
    private static final String BOOKING_DESCRIPTION ="Cyraco Meeting";
    private static final String BOOKING_PARTICIPANTS = "Kostas, Giorgos, Panos";

    String StartTimeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
    String EndTimeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());


    @Test
    public void bookingEntityConvert(){
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setTitle(BOOKING_TITLE);
        bookingDTO.setDescription(BOOKING_DESCRIPTION);
        bookingDTO.setParticipants(BOOKING_PARTICIPANTS);
        bookingDTO.setStart_timestamp(Timestamp.valueOf(StartTimeStamp));
        bookingDTO.setEnd_timestamp(Timestamp.valueOf(EndTimeStamp));
        bookingDTO.setRoom(booking_Room);
        Booking booking = bookingDTO.convertToEntity();
        Assertions.assertEquals(BOOKING_TITLE, booking.getTitle());
        Assertions.assertEquals(BOOKING_DESCRIPTION, booking.getDescription());
        Assertions.assertEquals(BOOKING_PARTICIPANTS, booking.getParticipants());
        Assertions.assertEquals(Timestamp.valueOf(StartTimeStamp), booking.getStart_timestamp());
        Assertions.assertEquals(Timestamp.valueOf(EndTimeStamp), booking.getEnd_timestamp());
        Assertions.assertEquals(booking_Room, booking.getRoom());

    }

    @Test
    public void bookingDTOConvert(){
        BookingDTO bookingDTO = new BookingDTO();
        Booking booking = new Booking();
        booking.setTitle(BOOKING_TITLE);
        booking.setDescription(BOOKING_DESCRIPTION);
        booking.setParticipants(BOOKING_PARTICIPANTS);
        booking.setStart_timestamp(Timestamp.valueOf(StartTimeStamp));
        booking.setEnd_timestamp(Timestamp.valueOf(EndTimeStamp));
        bookingDTO.setStart_timestamp(Timestamp.valueOf(StartTimeStamp));
        bookingDTO.setEnd_timestamp(Timestamp.valueOf(EndTimeStamp));
        bookingDTO.setRoom(booking_Room);
        bookingDTO = bookingDTO.convertToDto(booking);
        Assertions.assertEquals(BOOKING_TITLE, booking.getTitle());
        Assertions.assertEquals(BOOKING_DESCRIPTION, booking.getDescription());
        Assertions.assertEquals(BOOKING_PARTICIPANTS, booking.getParticipants());
        Assertions.assertEquals(Timestamp.valueOf(StartTimeStamp), booking.getStart_timestamp());
        Assertions.assertEquals(Timestamp.valueOf(EndTimeStamp), booking.getEnd_timestamp());
        Assertions.assertEquals(booking_Room, booking.getRoom());
    }

}