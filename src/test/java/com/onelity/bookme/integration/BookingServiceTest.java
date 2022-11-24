package com.onelity.bookme.integration;


import com.onelity.bookme.model.Booking;
import com.onelity.bookme.model.Room;
import com.onelity.bookme.service.AdminService;
import com.onelity.bookme.service.BookingService;
import com.onelity.bookme.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BookingServiceTest {

    @Autowired
    private BookingService bookingService;
    private AdminService adminService;
    private RoomService roomService;

    private static final String BOOKING_TITLE1="Cyraco";

    private Room booking_Room1;

//    private static final String booking_Title2="Epg";
//
//    private static final String booking_Title3="Tisix";

    private static final String BOOKING_DESCRIPTION_1 ="Cyraco Meeting";

    private static final String BOOKING_PARTICIPANTS_1 = "Kostas,Giorgos,Panos";

    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

    @Test
    public void BookingCRUD_positive_size() throws InterruptedException{
        List<Booking> OG_Bookings = bookingService.getBookings();
        Booking booking= new Booking();
        booking.setTitle(BOOKING_TITLE1);
        List<Room> rooms = roomService.getRooms();
        booking_Room1=rooms.get(0);
        booking.setRoom(booking_Room1);
        booking.setDescription(BOOKING_DESCRIPTION_1);
        booking.setStart(Timestamp.valueOf(timeStamp));
    }
}
