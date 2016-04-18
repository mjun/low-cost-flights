package hr.lowcostflights.repository;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;

import hr.lowcostflights.domain.Airport;
import hr.lowcostflights.domain.Search;

public interface SearchRepository extends CrudRepository<Search, Integer> {

	Search findOneByOriginAndDestinationAndDepartureDateAndReturnDateAndAdultsAndChildrenAndInfantsAndCurrency(
			Airport origin, Airport destination, LocalDate departureDate, LocalDate returnDate, Integer adults,
			Integer children, Integer infants, String currency);
	
}
