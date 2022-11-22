package com.onelity.bookme.Repository;

import com.onelity.bookme.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
}
