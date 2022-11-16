package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
