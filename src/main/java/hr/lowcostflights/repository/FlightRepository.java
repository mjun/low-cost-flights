package hr.lowcostflights.repository;

import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;

import hr.lowcostflights.domain.Airport;
import hr.lowcostflights.domain.Flight;

public interface FlightRepository extends CrudRepository<Flight, Integer> {

	Flight findOneByOriginAndDestinationAndDepartureDateTimeAndReturnDateTimeAndOutboundStopsAndInboundStopsAndAdultsAndChildrenAndInfantsAndCurrencyAndTotalPrice(
			Airport origin, Airport destination, LocalDateTime departureDateTime, LocalDateTime returnDateTime,
			Integer outboundStops, Integer inboundStops, Integer adults, Integer children, Integer infants,
			String currency, Double totalPrice);
	
}
