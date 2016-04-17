package hr.lowcostflights.integration.amadeus.domain;

import java.time.LocalDateTime;

import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class Flight {

	@JsonProperty("departs_at")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime departsAt;
	
	@JsonProperty("arrives_at")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime arrivesAt;
	
	@JsonProperty("origin")
	private Airport origin;
	
	@JsonProperty("destination")
	private Airport destination;
	
	@JsonProperty("marketing_airline")
	private String marketingAirline;
	
	@JsonProperty("operating_airline")
	private String operatingAirline;
	
	@JsonProperty("flight_number")
	private String flightNumber;
	
	@JsonProperty("aircraft")
	private String aircraft;
	
	@JsonProperty("booking_info")
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
	@Override
	public String toString() {
		ToStringCreator builder = new ToStringCreator(this);
		builder.append("departsAt", departsAt);
		builder.append("arrivesAt", arrivesAt);
		builder.append("origin", origin);
		builder.append("destination", destination);
		builder.append("marketingAirline", marketingAirline);
		builder.append("operatingAirline", operatingAirline);
		builder.append("flightNumber", flightNumber);
		builder.append("aircraft", aircraft);
		builder.append("bookingInfo", bookingInfo);
		return builder.toString();
	}
	
	
}
