package com.onelity.bookme.function;

import com.onelity.bookme.model.Booking;
import com.onelity.bookme.model.Room;
import com.onelity.bookme.repository.BookingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Optional;

@SpringBootTest
public class BookingMockTest {

    @MockBean
    private BookingRepository bookingRepository;
    private static final String BOOKING_TITLE = "Cyraco";
    private Room booking_Room1;
    private static final String BOOKING_DESCRIPTION ="Cyraco Meeting";
    private static final String BOOKING_PARTICIPANTS = "Kostas, Giorgos, Panos";

    String StartTimeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
    String EndTimeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());


    @Test
    public void postRequestMock(){
        Booking booking = new Booking(Mockito.anyInt(), BOOKING_TITLE, BOOKING_DESCRIPTION,
                Timestamp.valueOf(StartTimeStamp), Timestamp.valueOf(EndTimeStamp), BOOKING_PARTICIPANTS, booking_Room1);
        Mockito.when(bookingRepository.findById(booking.getId())).thenReturn(Optional.of(booking));
        Mockito.when(bookingRepository.save(booking)).thenReturn(booking);
        Assertions.assertNotEquals(Optional.of(booking), null);
    }
}
