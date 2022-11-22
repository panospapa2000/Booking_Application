package com.onelity.bookme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onelity.bookme.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
