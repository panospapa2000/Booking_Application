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

@SpringBootTest
public class RoomServiceTest {
    @Autowired
    private RoomService roomService;
    private static final String ROOM_NAME_1 = "Meeting Room";
    private static final String ROOM_NAME_2 = "Diner Room";
    private static final String ROOM_NAME_3 = "Conference Room";

    @Test
    public void roomCRUD_positive_size() throws InterruptedException {
        List<Room> OG_rooms = roomService.getRooms();
        Room room = new Room();
        room.setName(ROOM_NAME_1);
        roomService.saveRoom(room);
        List<Room> storedRooms = roomService.getRooms();
        Assertions.assertEquals(OG_rooms.size() + 1 , storedRooms.size());
        roomService.deleteRoom(room.getId());
        List<Room> storedRoomsFinal = roomService.getRooms();
        Assertions.assertEquals(OG_rooms.size(),storedRoomsFinal.size());
    }

    @Test
    public void roomCRUD_positive_credentials(){
        Room room = new Room();
        room.setName(ROOM_NAME_2);
        roomService.saveRoom(room);
        Optional<Room> storedRoom = roomService.getRoomById(room.getId());
        Assertions.assertTrue(storedRoom.isPresent());
        Assertions.assertEquals(room.getName(), storedRoom.get().getName());
        roomService.deleteRoom(room.getId());
        Optional<Room> storedRoomFinal = roomService.getRoomById(room.getId());
        Assertions.assertTrue(storedRoomFinal.isEmpty());
    }

    @Test
    public void roomCRUD_negative_roomNameNull(){
        Room room = new Room();
        room.setName(null);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> roomService.saveRoom(room));
    }

    @Test
    public void roomCRUD_delete(){
        List<Room> OG_Rooms = roomService.getRooms();
        roomService.deleteAllRooms();
        List<Room> roomsDeleted = roomService.getRooms();
        Assertions.assertEquals(0 , roomsDeleted.size());
        roomService.saveAllRooms(OG_Rooms);
    }

    @Test
    public void roomCRUD_deleteById(){
        Room room = new Room();
        room.setName(ROOM_NAME_3);
        roomService.saveRoom(room);
        Optional<Room> storedRoom = roomService.getRoomById(room.getId());
        roomService.deleteRoom(room.getId());
        Optional<Room> testRoom = roomService.getRoomById(room.getId());
        Assertions.assertNotEquals(storedRoom, testRoom);
    }
}
