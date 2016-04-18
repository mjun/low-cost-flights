package hr.lowcostflights.service;

import java.util.List;

import hr.lowcostflights.domain.Airport;

public interface AirportService {

	public Airport getByIataCode(String iataCode);
	
	public List<Airport> findByName(String name);
	
}
