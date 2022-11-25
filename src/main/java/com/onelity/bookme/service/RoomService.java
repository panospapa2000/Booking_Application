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

    /**
     * RoomService works as a constructor dependency injection, using RoomRepository.
     * @param roomRepository
     */
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    /**
     * This method returns the list of all rooms from the database, via GET request.
     * @return
     */
    public List<Room> getRooms(){
        return roomRepository.findAll();
    }

    /**
     * This method returns a specific Room, given its unique id.
     * Also returns Optional.Empty if it does not exist.
     * @param id
     * @return
     */
    public Optional<Room> getRoomById(Integer id){
        return roomRepository.findById(id);
    }

    /**
     * This method is serving a DELETE request of a specific room, given its id.
     * @param id
     */
    public void deleteRoom(int id){
        roomRepository.deleteById(id);
    }

    /**
     * This method deletes all rooms.
     */
    public void deleteAllRooms(){
        roomRepository.deleteAll();
    }

    /**
     * This method is serving a POST request of a specific room.
     * @param room
     * @return
     */
    public Room saveRoom(Room room){
        return roomRepository.save(room);
    }

    /**
     * This method is serving a POST request of a list of rooms, saving them to the database.
     * @param rooms
     * @return
     */
    public List<Room> saveAllRooms(List<Room> rooms){
        return roomRepository.saveAll(rooms);
    }
}
