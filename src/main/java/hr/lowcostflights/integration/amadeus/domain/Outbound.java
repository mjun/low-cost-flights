package hr.lowcostflights.integration.amadeus.domain;

import java.util.List;

import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Outbound {
	
	@JsonProperty("flights")
	private List<Flight> flights;

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		ToStringCreator builder = new ToStringCreator(this);
		builder.append("flights", flights);
		return builder.toString();
	}

}
