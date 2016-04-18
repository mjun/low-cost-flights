package hr.lowcostflights.service;

import java.time.LocalDateTime;

import hr.lowcostflights.domain.Airport;
import hr.lowcostflights.domain.Flight;

public interface FlightService {

	public Flight findSpecificFlight(Airport origin, Airport destination, LocalDateTime departureDateTime, LocalDateTime returnDateTime,
			Integer outboundStops, Integer inboundStops, Integer adults, Integer children, Integer infants,
			String currency, Integer totalPrice);
	
}
