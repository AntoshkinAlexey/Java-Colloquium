package com.example.Colloq.repository;

import com.example.Colloq.entity.HotelEntity;
import com.example.Colloq.entity.ReviewEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewRepo  extends CrudRepository<ReviewEntity, Integer> {
    List<ReviewEntity> findAllByIdForReview(Long hotelId);
}
