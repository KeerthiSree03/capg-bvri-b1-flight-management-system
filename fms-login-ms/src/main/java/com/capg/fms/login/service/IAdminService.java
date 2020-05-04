package com.capg.fms.login.service;

import com.capg.fms.login.model.Flight;
import com.capg.fms.login.model.ScheduledFlight;

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
