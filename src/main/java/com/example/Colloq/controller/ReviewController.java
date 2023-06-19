package com.example.Colloq.controller;

import com.example.Colloq.entity.HotelEntity;
import com.example.Colloq.entity.ReviewEntity;
import com.example.Colloq.repository.HotelRepo;
import com.example.Colloq.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private HotelRepo hotelRepository;

    @Autowired
    private ReviewRepo reviewRepository;

    @PostMapping()
    public ResponseEntity addReview(@RequestBody ReviewEntity review) {
        try {
            HotelEntity hotel = hotelRepository.findById(review.getIdForReview());
            if (hotel == null) {
                return ResponseEntity.badRequest().body("Некорректный id отеля.");
            }
            review.setHotel(hotel);
            return ResponseEntity.ok(reviewRepository.save(review));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity getReviewsByHotelId(@PathVariable(value = "hotelId") Long hotelId) {
        try {
            HotelEntity hotel = hotelRepository.findById(hotelId);
            if (hotel == null) {
                return ResponseEntity.badRequest().body("Некорректный id отеля.");
            }
            return ResponseEntity.ok(reviewRepository.findAllByIdForReview(hotelId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        return ResponseEntity.badRequest().body("Некорректный запрос.");
    }
}
