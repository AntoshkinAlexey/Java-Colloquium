package com.example.Colloq.controller;

import com.example.Colloq.entity.BookingEntity;
import com.example.Colloq.entity.HotelEntity;
import com.example.Colloq.repository.BookingRepo;
import com.example.Colloq.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingRepo bookingRepository;

    @Autowired
    private HotelRepo hotelRepository;

    @PostMapping()
    public ResponseEntity addBooking(@RequestBody BookingEntity booking) {
        try {
            HotelEntity hotel = hotelRepository.findById(booking.getIdForBooking());
            if (hotel == null) {
                return ResponseEntity.badRequest().body("Некорректный id отеля.");
            }
            booking.setHotel(hotel);
            return ResponseEntity.ok(bookingRepository.save(booking));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        return ResponseEntity.badRequest().body("Некорректный запрос. Укажите все необходимые параметры.");
    }
}
