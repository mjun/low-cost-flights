package hr.lowcostflights.integration.amadeus.domain;

public class BookingInfo {
	
	private String travelClass;
	private String bookingCode;
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
	
}
