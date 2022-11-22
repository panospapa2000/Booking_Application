package com.onelity.bookme.controllers;

import com.onelity.bookme.model.room;
import com.onelity.bookme.services.RoomService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) { this.roomService = roomService; }

    public List<room> getRooms() {
        return roomService.getRooms();
    }
    public room getRoomById(Integer id) {
        return roomService.getRoomById(id);
    }
    public String deleteRoom(Integer id) {
        return roomService.deleteRoom(id);
    }
    public room saveRoom(room room) {
        return roomService.saveRoom(room);
    }

    public List<room> saveAllRooms(List<room> rooms) {
        return roomService.saveAllRooms(rooms);
    }

    public String deleteAllRooms() {
        return roomService.deleteAllRooms();
    }
}
