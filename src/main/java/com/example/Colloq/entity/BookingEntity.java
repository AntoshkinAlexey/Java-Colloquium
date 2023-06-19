package com.example.Colloq.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "bookings")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    @Column(nullable = false)
    private Long idForBooking;

    @Column(nullable = false)
    private Timestamp checkInDate;

    @Column(nullable = false)
    private Timestamp checkOutDate;

    public BookingEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdForBooking() {
        return idForBooking;
    }

    public void setIdForBooking(Long idForBooking) {
        this.idForBooking = idForBooking;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    public Timestamp getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Timestamp checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Timestamp getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Timestamp checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
