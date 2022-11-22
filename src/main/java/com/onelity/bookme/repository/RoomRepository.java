package com.onelity.bookme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onelity.bookme.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
