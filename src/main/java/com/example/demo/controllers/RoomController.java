package com.example.demo.controllers;

import com.example.demo.model.room;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    private final RoomService roomService;
    @Autowired
    public RoomController(RoomService roomService) { this.roomService = roomService; }

    public List<room> getRooms() {
        return roomService.getRooms();
    }
    public room getRoomById(int id) {
        return roomService.getRoomById(id);
    }
    public String deleteRoom(int id) {
        return roomService.deleteRoom(id);
    }
    public room saveRoom(room room) {
        return roomService.saveRoom(room);
    }

    public List<room> saveAllRooms(List<room> rooms) {
        return roomService.saveAllRooms(rooms);
    }


}
