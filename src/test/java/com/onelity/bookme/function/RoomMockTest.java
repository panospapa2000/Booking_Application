package com.onelity.bookme.function;

import com.onelity.bookme.model.Room;
import com.onelity.bookme.repository.RoomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;

@SpringBootTest
public class RoomMockTest {

    @MockBean
    RoomRepository roomRepository;

    @Test
    public void postRequestMock(){
        Room room = new Room();
        room.setId(Mockito.anyInt());
        room.setName("Mockito Room");
        Mockito.when(roomRepository.findById(room.getId())).thenReturn(Optional.of(room));
        Mockito.when(roomRepository.save(room)).thenReturn(room);
        Assertions.assertNotEquals(Optional.of(room), null);
    }
}
