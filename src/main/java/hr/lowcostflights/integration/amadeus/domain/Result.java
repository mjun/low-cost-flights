package hr.lowcostflights.integration.amadeus.domain;

import java.util.List;

public class Result {

	private List<Itinerary> itineraries;
	private Fare fare;
	
	public List<Itinerary> getItineraries() {
		return itineraries;
	}
	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}
	public Fare getFare() {
		return fare;
	}
	public void setFare(Fare fare) {
		this.fare = fare;
	}
}
