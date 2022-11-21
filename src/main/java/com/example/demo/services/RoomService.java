package com.example.demo.services;

import com.example.demo.model.room;
import com.example.demo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    public List<room> getRooms(){
        return roomRepository.findAll();
    }

    public room getRoomById(int id){
        return roomRepository.findById(id).orElse(null);
    }

    public String deleteRoom(int id){
        roomRepository.deleteById(id);
        return "room removed!" + id;
    }

    public room saveRoom(room room){
        return roomRepository.save(room);
    }

    public List<room> saveAllRooms(List<room> rooms){
        return roomRepository.saveAll(rooms);
    }
}
