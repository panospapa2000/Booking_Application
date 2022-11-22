package com.onelity.bookme.controller;

import com.onelity.bookme.model.Room;
import com.onelity.bookme.service.RoomService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) { this.roomService = roomService; }

    public List<Room> getRooms() {
        return roomService.getRooms();
    }
    public Room getRoomById(Integer id) {
        return roomService.getRoomById(id);
    }
    public String deleteRoom(Integer id) {
        return roomService.deleteRoom(id);
    }
    public Room saveRoom(Room room) {
        return roomService.saveRoom(room);
    }

    public List<Room> saveAllRooms(List<Room> rooms) {
        return roomService.saveAllRooms(rooms);
    }

}
