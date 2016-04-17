package hr.lowcostflights.integration.amadeus.domain;

import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingInfo {
	
	@JsonProperty("travel_class")
	private String travelClass;
	
	@JsonProperty("booking_code")
	private String bookingCode;
	
	@JsonProperty("seats_remaining")
	private Integer seatsRemaining;
	
	public String getTravelClass() {
		return travelClass;
	}
	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}
	public String getBookingCode() {
		return bookingCode;
	}
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}
	public Integer getSeatsRemaining() {
		return seatsRemaining;
	}
	public void setSeatsRemaining(Integer seatsRemaining) {
		this.seatsRemaining = seatsRemaining;
	}
	
	@Override
	public String toString() {
		ToStringCreator builder = new ToStringCreator(this);
		builder.append("travelClass", travelClass);
		builder.append("bookingCode", bookingCode);
		builder.append("seatsRemaining", seatsRemaining);
		return builder.toString();
	}
	
}
