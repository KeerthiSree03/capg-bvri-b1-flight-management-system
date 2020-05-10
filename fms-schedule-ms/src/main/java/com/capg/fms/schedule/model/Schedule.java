package com.capg.fms.schedule.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Schedule {

	@Id
	@Column(name = "scheduleId")
	private int scheduleId;// not mentioned in case study .......

	// private Airport sourceAirport;

	@Column(name = "sourceAirport")
	private String sourceAirport;

	// private Airport destinationAirport;
	@Column(name = "destinationAirport")
	private String destinationAirport;

	@Column(name = "arrivalTime")
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	// @JsonFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDateTime arrivalTime;
	@Column(name = "departureTime")
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	// @JsonFormat(pattern = "yyyy/MM/ddThh:mm:ss")

	private LocalDateTime departureTime;

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Schedule(int scheduleId, String sourceAirport, String destinationAirport, LocalDateTime arrivalTime,
			LocalDateTime departureTime) {
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

	public void setArrivalTime(@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss") LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss") LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", sourceAirport=" + sourceAirport + ", destinationAirport="
				+ destinationAirport + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
	}

}