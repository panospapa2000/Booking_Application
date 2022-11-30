package com.onelity.bookme.unit;

import com.onelity.bookme.dto.RoomDTO;
import com.onelity.bookme.model.Room;
import com.onelity.bookme.service.RoomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RoomDTOTest {

    @Autowired
    private RoomService roomService;
    private static final String TEST_NAME = "testName";

    @Test
    public void roomEntityConvert(){
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName(TEST_NAME);
        Room room = roomDTO.convertToEntity();
        Assertions.assertEquals(TEST_NAME, room.getName());
    }

    @Test
    public void roomDTOConvert(){
        RoomDTO roomDTO = new RoomDTO();
        Room room = new Room();
        room.setName(TEST_NAME);
        roomDTO = roomDTO.convertToDto(room);
        Assertions.assertEquals(TEST_NAME, roomDTO.getName());
    }

}