package hr.lowcostflights.integration.amadeus.domain;

import java.util.List;

public class Outbound {
	
	private List<Flight> flights;

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

}
