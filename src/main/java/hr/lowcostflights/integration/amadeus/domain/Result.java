package hr.lowcostflights.integration.amadeus.domain;

import java.util.List;

import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

	@JsonProperty("itineraries")
	private List<Itinerary> itineraries;
	
	@JsonProperty("fare")
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
	
	@Override
	public String toString() {
		ToStringCreator builder = new ToStringCreator(this);
		builder.append("itineraries", itineraries);
		builder.append("fare", fare);
		return builder.toString();
	}
	
	
}
