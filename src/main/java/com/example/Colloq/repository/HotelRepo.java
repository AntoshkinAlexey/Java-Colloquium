package com.example.Colloq.repository;

import com.example.Colloq.entity.HotelEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HotelRepo extends CrudRepository<HotelEntity, Integer> {
    List<HotelEntity> findAll();

    HotelEntity findById(Long hotelId);
}
