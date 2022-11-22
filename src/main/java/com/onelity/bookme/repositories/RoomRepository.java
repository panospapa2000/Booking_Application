package com.onelity.bookme.repositories;
import com.onelity.bookme.model.room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<room, Integer> {

}
