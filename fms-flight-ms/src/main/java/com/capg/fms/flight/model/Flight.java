package com.capg.fms.flight.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Flight {
    @Id
   
   // @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long flightNumber;
    
  
//    @NotEmpty(message="FlightModel is Mandatory field, Please provide flighttModel")
//    @Size(min=4, message="Name should have atleast:4 characters")
	private String flightModel;
    
	/*
	 * @NotEmpty(
	 * message="CarrierName is Mandatory field, Please provide carrierName")
	 * 
	 * @Size(min=4, message="Name should have atleast:4 characters")
	 */
    private String carrierName;
    
  
	/*
	 * //@NotEmpty(
	 * message="FlightModel is Mandatory field, Please provide flighttModel")
	 * 
	 * @NotNull(message="SeatCapacity cannot be null")
	 * 
	 * @Min(value=1,message="SeatCapacity cannot be smaller than 1")
	 * 
	 * @Max(value=100,message="SeatCapacity cannot be greater than 100")
	 */
    private int seatCapacity;
    
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(long flightNumber, String flightModel, String carrierName, int seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.flightModel = flightModel;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
	}

	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", flightModel=" + flightModel + ", carrierName=" + carrierName
				+ ", seatCapacity=" + seatCapacity + "]";
	}
    
	
    
    
    
    

}