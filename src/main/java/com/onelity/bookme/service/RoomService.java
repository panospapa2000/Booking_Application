package com.onelity.bookme.service;

import com.onelity.bookme.model.Admin;
import com.onelity.bookme.model.Room;
import com.onelity.bookme.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private RoomRepository roomRepository;
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms(){
        return roomRepository.findAll();
    }
    public Optional<Room> getRoomById(Integer id){
        return roomRepository.findById(id);
    }

    public void deleteRoom(int id){
        roomRepository.deleteById(id);
    }

    public void deleteAllRooms(){
        roomRepository.deleteAll();
    }

    public Room saveRoom(Room room){
        return roomRepository.save(room);
    }

    public List<Room> saveAllRooms(List<Room> rooms){
        return roomRepository.saveAll(rooms);
    }
}
