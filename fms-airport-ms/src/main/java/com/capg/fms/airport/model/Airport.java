package com.capg.fms.airport.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//Author                : G.Harshitha
//Created/Modified Date : 22/04/2020
//Description           : Airport Bean class for Airport Management System 
@Entity
public class Airport {
	
	 		//@NotEmpty(message="please provide Airport Name")
			private String airportName;
	 		
	        @Id
	/*
	 * @NotEmpty(message="please provide AirportCode of type String")
	 * 
	 * @Size(min=3, message="AirportCode should be of 3 characters")
	 */			private String airportCode;
	        
	       // @NotEmpty(message="please provide Airport Location ")
	        private String airportLocation;

			public Airport(String airportName, String airportCode, String airportLocation) {
				super();
				this.airportName = airportName;
				this.airportCode = airportCode;
				this.airportLocation = airportLocation;
			}

			public Airport() {
				super();
			}

			public String getAirportName() {
				return airportName;
			}

			public void setAirportName(String airportName) {
				this.airportName = airportName;
			}

			public String getAirportCode() {
				return airportCode;
			}

			public void setAirportCode(String airportCode) {
				this.airportCode = airportCode;
			}

			public String getAirportLocation() {
				return airportLocation;
			}

			public void setAirportLocation(String airportLocation) {
				this.airportLocation = airportLocation;
			}

			@Override
			public String toString() {
				return "Airport [airportName=" + airportName + ", airportCode=" + airportCode + ", airportLocation="
						+ airportLocation + "]";
			}

		}




