package hr.lowcostflights.service;

import java.time.LocalDate;
import java.util.List;

import hr.lowcostflights.domain.Airport;
import hr.lowcostflights.domain.Flight;

public interface SearchService {

	public List<Flight> findFlights(Airport origin, Airport destination, LocalDate departureDate, LocalDate returnDate,
			Integer adults, Integer children, Integer infants, String currency);

}
