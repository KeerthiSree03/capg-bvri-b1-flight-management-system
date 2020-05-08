package com.capg.fms.user.service;

import com.capg.fms.user.model.Flight;
import com.capg.fms.user.model.ScheduledFlight;

public interface IAdminService {
	
	Flight addFlight(Flight flight);
	Flight viewFlight(long flightId);
	void cancelFlight(long flightId);
	Flight modifyFlight(Flight flight);
	
	ScheduledFlight addScheduledFlight (ScheduledFlight  flight);
	ScheduledFlight  viewScheduledFlight (long scheduledFlightId);
	void cancelScheduledFlight (long scheduledFlightId);
	ScheduledFlight modifyScheduledFlight(ScheduledFlight  flight);

}
