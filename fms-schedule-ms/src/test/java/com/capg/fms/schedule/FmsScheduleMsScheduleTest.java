package com.capg.fms.schedule;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.repository.IScheduleRepo;
import com.capg.fms.schedule.service.IScheduleService;

@SpringBootTest
class FmsScheduleMsScheduleTest {
	
	@Autowired
	IScheduleService service;
	IScheduleRepo repo;

	Schedule schedule = new Schedule(101, "DEL", "PAK", LocalDateTime.of(2020, 05, 05, 10, 30, 55),
			LocalDateTime.of(2020, 05, 03, 05, 10, 55));

	ScheduledFlight scheduledFlight = new ScheduledFlight(101, 30, 143, schedule);

	@Test
	public void validateScheduleFlightById() {
		
		assertEquals(scheduledFlight.getScheduledFlightId(), service.viewScheduledFlight(101).getScheduledFlightId());
		
	}
	@Test
	public void validateScheduleFlightByFlightNumber() {
		
		assertEquals(scheduledFlight.getFlightNumber(), service.viewScheduledFlight(101).getFlightNumber());
		
	} 
	@Test
    public void validateScheduleFlightByAvailableSeats() {
		
		assertEquals(scheduledFlight.getAvailableSeats(), service.viewScheduledFlight(101).getAvailableSeats());
		
	}
	@Test
	public void validateScheduleFlightByScheduleId() {
		
		assertEquals(scheduledFlight.getSchedule().getScheduleId(), service.viewScheduledFlight(101).getSchedule().getScheduleId());
		
	}
	@Test
	public void validateScheduleFlightByScheduleSourceAirport() {
		
		assertEquals(scheduledFlight.getSchedule().getSourceAirport(), service.viewScheduledFlight(101).getSchedule().getSourceAirport());
		
	}	
	@Test
	public void validateScheduleFlightByScheduleDestinationAirport() {
		
		assertEquals(scheduledFlight.getSchedule().getDestinationAirport(), service.viewScheduledFlight(101).getSchedule().getDestinationAirport());
		
	}
	@Test
	public void validateScheduleFlightByScheduleArrivalTime() {
		
		assertEquals(scheduledFlight.getSchedule().getArrivalTime(), service.viewScheduledFlight(101).getSchedule().getArrivalTime());
		
	}
	@Test
	public void validateScheduleFlightByScheduleDepartureAirport() {
		
		assertEquals(scheduledFlight.getSchedule().getDepartureTime(), service.viewScheduledFlight(101).getSchedule().getDepartureTime());
		
	}

	
	
}


