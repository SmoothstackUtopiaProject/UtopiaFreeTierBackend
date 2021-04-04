package com.ss.utopia.airportms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport {

	@Id
	@Column(name = "iata_id")
	private String airportIataId;

	@Column(name = "name")
	private String airportName;

	@Column(name = "city")
	private String airportCityName;

	public Airport() {}
	public Airport(String airportIataId, String airportName, String airportCityName) {
		this.airportIataId = airportIataId;
		this.airportName = airportName;
		this.airportCityName = airportCityName;
	}

	public String getAirportIataId() {
		return airportIataId;
	}

	public void setAirportIataId(String airportIataId) {
		this.airportIataId = airportIataId;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportCityName() {
		return airportCityName;
	}

	public void setAirportCityName(String airportCityName) {
		this.airportCityName = airportCityName;
	}
}