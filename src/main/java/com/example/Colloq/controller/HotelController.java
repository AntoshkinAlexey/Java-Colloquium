package com.example.Colloq.controller;

import com.example.Colloq.entity.HotelEntity;
import com.example.Colloq.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelRepo hotelRepository;

    @GetMapping()
    public ResponseEntity getHotels() {
        try {
            return ResponseEntity.ok(hotelRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getHotelById(@PathVariable(value = "id") Long hotelId) {
        try {
            final HotelEntity hotel = hotelRepository.findById(hotelId);
            if (hotel == null) {
                return ResponseEntity.badRequest().body("Некорректный id");
            }
            return ResponseEntity.ok(hotel);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        return ResponseEntity.badRequest().body("Некорректный запрос. Укажите все необходимые параметры.");
    }
}
