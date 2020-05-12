package com.capg.fms.flight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capg.fms.flight.model.Flight;
import com.capg.fms.flight.repo.IFlightRepo;
import com.capg.fms.flight.service.IFlightService;

@SpringBootTest
class FmsFlightMsApplicationTests {

	@Autowired
	IFlightService service;
	
	Flight flight = new Flight(101,"Airbus","Indigo",100);
	
	@Test
	public void testGetFlightById() {
		assertEquals(flight.getFlightNumber(), service.getFlightById(101).getFlightNumber());
	}
	
	@Test
	public void validateFlightModel() {
		assertEquals(flight.getFlightModel(), service.getFlightById(101).getFlightModel());
	}
	
	@Test
	public void validateCarrierName() {
		assertEquals(flight.getCarrierName(), service.getFlightById(101).getCarrierName());
	}
	
	@Test
	public void validateSeatCapacity() {
		assertEquals(flight.getSeatCapacity(), service.getFlightById(101).getSeatCapacity());
	}	
}


