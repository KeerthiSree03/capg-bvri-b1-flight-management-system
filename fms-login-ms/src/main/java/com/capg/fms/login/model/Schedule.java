package com.capg.fms.login.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Schedule {

	
	private int scheduleId;// not mentioned in case study .......
	
	//private Airport sourceAirport;


	private String sourceAirport;
	
	
	//private Airport destinationAirport;
	
	private String destinationAirport;
	
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	//@JsonFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDateTime arrivalTime;
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	//@JsonFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDateTime departureTime;

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Schedule(int scheduleId, String sourceAirport, String destinationAirport, @DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")LocalDateTime arrivalTime,
			@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")LocalDateTime departureTime) {
		super();
		this.scheduleId = scheduleId;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", sourceAirport=" + sourceAirport + ", destinationAirport="
				+ destinationAirport + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
	}

}