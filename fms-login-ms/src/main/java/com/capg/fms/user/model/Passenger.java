package com.capg.fms.user.model;

public class Passenger {
	
    
	private long passengerNum;
	private String passengerName;
	private int passengerAge;
	private long passengerUIN;
	private double luggage;

	public Passenger() {
		super();
	}

	public Passenger(long passengerNum, String passengerName, int passengerAge, long passengerUIN, double luggage) {
		super();
		this.passengerNum = passengerNum;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		this.luggage = luggage;
	}

	public long getPassengerNum() {
		return passengerNum;
	}

	public void setPassengerNum(long passengerNum) {
		this.passengerNum = passengerNum;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public long getPassengerUIN() {
		return passengerUIN;
	}

	public void setPassengerUIN(long passengerUIN) {
		this.passengerUIN = passengerUIN;
	}

	public double getLuggage() {
		return luggage;
	}

	public void setLuggage(double luggage) {
		this.luggage = luggage;
	}

	@Override
	public String toString() {
		return "Passenger [passengerNum=" + passengerNum + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerUIN=" + passengerUIN + ", luggage=" + luggage + "]";
	}

}
