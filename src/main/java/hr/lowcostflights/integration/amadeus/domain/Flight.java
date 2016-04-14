package hr.lowcostflights.integration.amadeus.domain;

import java.time.LocalDateTime;

public class Flight {

	private LocalDateTime departsAt;
	private LocalDateTime arrivesAt;
	private Airport origin;
	private Airport destination;
	private String marketingAirline;
	private String operatingAirline;
	private String flightNumber;
	private String aircraft;
	private BookingInfo bookingInfo;
	
	public LocalDateTime getDepartsAt() {
		return departsAt;
	}
	public void setDepartsAt(LocalDateTime departsAt) {
		this.departsAt = departsAt;
	}
	public LocalDateTime getArrivesAt() {
		return arrivesAt;
	}
	public void setArrivesAt(LocalDateTime arrivesAt) {
		this.arrivesAt = arrivesAt;
	}
	public Airport getOrigin() {
		return origin;
	}
	public void setOrigin(Airport origin) {
		this.origin = origin;
	}
	public Airport getDestination() {
		return destination;
	}
	public void setDestination(Airport destination) {
		this.destination = destination;
	}
	public String getMarketingAirline() {
		return marketingAirline;
	}
	public void setMarketingAirline(String marketingAirline) {
		this.marketingAirline = marketingAirline;
	}
	public String getOperatingAirline() {
		return operatingAirline;
	}
	public void setOperatingAirline(String operatingAirline) {
		this.operatingAirline = operatingAirline;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAircraft() {
		return aircraft;
	}
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}
	public BookingInfo getBookingInfo() {
		return bookingInfo;
	}
	public void setBookingInfo(BookingInfo bookingInfo) {
		this.bookingInfo = bookingInfo;
	}
	
	
}
