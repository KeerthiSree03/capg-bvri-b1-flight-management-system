
package com.capg.fms.passenger.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.passenger.model.Passenger;
import com.capg.fms.passenger.model.PassengerList;
import com.capg.fms.passenger.service.PassengerServiceImpl;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired(required=false)
	PassengerServiceImpl passengerService;
	
	@PostMapping("/add")
	public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger)
	{
	   	return new ResponseEntity<Passenger>(passengerService.addPassenger(passenger),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/num/{passengerNum}")
    public boolean deletePassenger(@PathVariable("passengerNum") long passengerNum)
    {
		    return passengerService.deletePassenger(passengerNum);
    }
	
	
	@GetMapping("/num/{passengerNum}")
	public ResponseEntity<Passenger> getPassenger(@PathVariable("passengerNum") long passengerNum)
	{
		
		return new ResponseEntity<Passenger>(passengerService.getPassenger(passengerNum),HttpStatus.OK); 
			
    }

	@GetMapping("/all")
public ResponseEntity<PassengerList> getAllPassengers()
{
	return new ResponseEntity<PassengerList>(passengerService.getAllPasssengers(),HttpStatus.OK);
}

	@PutMapping("/update")
	public ResponseEntity<Passenger> updatePassenger(@RequestBody Passenger passenger)
	{
		   return new ResponseEntity<Passenger>(passengerService.updatePassenger(passenger),HttpStatus.OK);
	}

	@GetMapping("/getcount")
	public long getCountOfPassenger() {
		
		return passengerService.getCountOfPassenger();
	}
	
}
