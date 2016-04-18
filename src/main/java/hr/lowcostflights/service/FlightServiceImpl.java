package hr.lowcostflights.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.lowcostflights.domain.Airport;
import hr.lowcostflights.domain.Flight;
import hr.lowcostflights.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;

	@Override
	public Flight findSpecificFlight(Airport origin, Airport destination, LocalDateTime departureDateTime,
			LocalDateTime returnDateTime, Integer outboundStops, Integer inboundStops, Integer adults, Integer children,
			Integer infants, String currency, Integer totalPrice) {
		return flightRepository
				.findOneByOriginAndDestinationAndDepartureDateTimeAndReturnDateTimeAndOutboundStopsAndInboundStopsAndAdultsAndChildrenAndInfantsAndCurrencyAndTotalPrice(
						origin, destination, departureDateTime, returnDateTime, outboundStops, inboundStops, adults,
						children, infants, currency, totalPrice);
	}

}
