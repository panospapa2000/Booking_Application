package com.onelity.bookme.integration;
import com.onelity.bookme.model.Room;
import com.onelity.bookme.service.RoomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RoomServiceTest {
    @Autowired
    private RoomService roomService;
    private static final String ROOM_NAME_1 = "ethousa_user";
    private static final String ROOM_NAME_2 = "ethousa1";
    private static final String ROOM_NAME_3 = "ethousa2";

    @Test
    public void RoomCRUD_positive_size() throws InterruptedException {
        List<Room> OG_rooms = roomService.getRooms();
        Room room = new Room();
        room.setName(ROOM_NAME_1);
        roomService.saveRoom(room);
        List<Room> storedAdmins = roomService.getRooms();
        Assertions.assertEquals(OG_rooms.size() + 1 , storedAdmins.size());
    }

    @Test
    public void roomCRUD_positive_credentials(){
        Room room = new Room();
        room.setName(ROOM_NAME_2);
        roomService.saveRoom(room);
        Optional<Room> storedRoom = roomService.getRoomById(room.getId());
        Assertions.assertEquals(room.getName(), storedRoom.get().getName());}

    @Test
    public void roomCRUD_negative_usernameNull() throws InterruptedException {
        Room room = new Room();
        room.setName(null);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> roomService.saveRoom(room));
    }

    @Test
    public void roomCRUD_delete(){
        roomService.deleteAllRooms();
        List<Room> roomsDeleted = roomService.getRooms();
        Assertions.assertEquals(0 , roomsDeleted.size());
    }

    @Test
    public void adminCRUD_deleteById(){
        Room room = new Room();
        room.setName(ROOM_NAME_3);
        roomService.saveRoom(room);
        List<Room> storedRooms = roomService.getRooms();
        roomService.deleteRoom(room.getId());
        List<Room> newRooms = roomService.getRooms();
        Assertions.assertEquals(newRooms.size(), storedRooms.size() -1 );
    }

    }
