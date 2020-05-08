package com.capg.fms.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.fms.booking.model.Booking;

public interface IBookingRepo extends JpaRepository<Booking, Long>{

	
}
