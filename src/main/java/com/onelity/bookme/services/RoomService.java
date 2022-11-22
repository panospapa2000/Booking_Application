package com.onelity.bookme.services;

import com.onelity.bookme.models.Room;
import com.onelity.bookme.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getRooms(){
        return roomRepository.findAll();
    }

    public Room getRoomById(int id){
        return roomRepository.findById(id).orElse(null);
    }

    public String deleteRoom(int id){
        roomRepository.deleteById(id);
        return "room removed!" + id;
    }

    public Room saveRoom(Room room){
        return roomRepository.save(room);
    }

    public List<Room> saveAllRooms(List<Room> rooms){
        return roomRepository.saveAll(rooms);
    }
}
