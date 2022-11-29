package com.onelity.bookme.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class BookingRoomController {
    @GetMapping("/")
    public String bookingRoom(){
        return "bookingRoom.html";
    }
}
