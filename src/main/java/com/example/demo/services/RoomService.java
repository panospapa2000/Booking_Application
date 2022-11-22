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

    public room getRoomById(Integer id){
        return roomRepository.findById(id).orElse(null);
    }

    public String deleteRoom(Integer id){
        roomRepository.deleteById(id);
        return "room " + id + " has been removed!";
    }

    public room saveRoom(room room){
        return roomRepository.save(room);
    }

    public List<room> saveAllRooms(List<room> rooms){
        return roomRepository.saveAll(rooms);
    }

    public String deleteAllRooms() {
        roomRepository.deleteAll();
        return "All rooms have been deleted!";
    }
}


