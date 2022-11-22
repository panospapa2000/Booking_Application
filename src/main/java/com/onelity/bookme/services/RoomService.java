package com.onelity.bookme.services;

import com.onelity.bookme.model.room;
import com.onelity.bookme.repositories.RoomRepository;
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


