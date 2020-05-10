package com.capg.fms.schedule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.fms.schedule.excepions.InvalidInputException;
import com.capg.fms.schedule.service.IAvailabilityService;

@SpringBootTest
class FmsScheduleMsAvailabilityTests {

	@Autowired
	IAvailabilityService availabilityService;

	@Test
	public void testFlightNumberwithLessDigits() throws InvalidInputException {

		Exception exception = assertThrows(InvalidInputException.class, () -> {
			availabilityService.validateFlightId(4567890L);
		});
		String expectedMessage = "ID should be of 12 digits";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void testFlightNumberwithMoreDigits() throws InvalidInputException {
		Exception exception = assertThrows(InvalidInputException.class, () -> {
			availabilityService.validateFlightId(1234345678907856L);
		});

		String expectedMessage = "ID should be of 12 digits";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void testFlightNumber() {
		assertEquals("The flight is available", availabilityService.checkScheduledFlightById(446233632412L));
	}

	@Test
	public void testSourceAirport() throws InvalidInputException {
		Exception exception = assertThrows(InvalidInputException.class, () -> {
			availabilityService.checkSource(446233628412L, "Vizag");
		});

		String expectedMessage = "Source Airport is not valid";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void testDestinationAirport() throws InvalidInputException {
		Exception exception = assertThrows(InvalidInputException.class, () -> {
			availabilityService.checkDestination(446233628412L, "Mumbai");
		});

		String expectedMessage = "Destination Airport is not valid";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void testSourceAndDestinationAirport() throws InvalidInputException {
		Exception exception = assertThrows(InvalidInputException.class, () -> {

			availabilityService.checkSourceAndDestination("Vizag", "Mumbai");
		});

		String expectedMessage = "Flight is not available";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

			
		    
		 
		   

	}

	@Test
	public void testAvailableSeats() {
		assertTrue(availabilityService.checkSeatAvailability(446233628412L, 21));
	}
	}

