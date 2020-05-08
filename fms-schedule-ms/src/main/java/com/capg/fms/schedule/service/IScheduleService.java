package com.capg.fms.schedule.service;

import java.util.List;

import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.model.ScheduledFlightList;

public interface IScheduleService {
	
	public ScheduledFlight addScheduleFlight(ScheduledFlight scheduledFlight);

	public ScheduledFlight viewScheduledFlight(int scheduleId);
	
	public ScheduledFlightList viewScheduledFlight();

	public ScheduledFlight modifyScheduledFlight( int scheduledFlightId,int availableSeats, long flightNumber, Schedule schedule);
	
	public void deleteScheduledFlight(int scheduleId);

}


