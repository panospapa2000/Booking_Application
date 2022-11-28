package com.onelity.bookme.controller;

import com.onelity.bookme.dto.AdminDTO;
import com.onelity.bookme.dto.RoomDTO;
import com.onelity.bookme.model.Room;
import com.onelity.bookme.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/room/{id}")
    public void deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
    }

    @DeleteMapping("/room")
    public void deleteAllRooms() {
        roomService.deleteAllRooms();
    }

    @PostMapping("/room")
    public Room saveRoom(@RequestBody RoomDTO roomDto) {
        Room room = roomDto.convertToEntity();
        return roomService.saveRoom(room);
    }
    public List<Room> saveAllRooms(@RequestBody List<Room> rooms) {
        return roomService.saveAllRooms(rooms);
    }

}
