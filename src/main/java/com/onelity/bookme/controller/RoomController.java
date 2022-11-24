package com.onelity.bookme.controller;

import com.onelity.bookme.model.Room;
import com.onelity.bookme.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) { this.roomService = roomService; }

    @GetMapping("/room")
    public List<Room> getRooms() {
        return roomService.getRooms();
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<Optional<Room>> getRoomById(@PathVariable(value = "id") Integer roomId){
        Optional<Room> room = roomService.getRoomById(roomId);
        return ResponseEntity.ok().body(room);
    }

    public void deleteRoom(Integer id) {
        roomService.deleteRoom(id);
    }

    public void deleteAllRooms() {
        roomService.deleteAllRooms();
    }
    public Room saveRoom(Room room) {
        return roomService.saveRoom(room);
    }

    public List<Room> saveAllRooms(List<Room> rooms) {
        return roomService.saveAllRooms(rooms);
    }

}
