package hr.lowcostflights.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import hr.lowcostflights.AbstractLowCostFlightsApplicationTest;
import hr.lowcostflights.domain.Airport;
import hr.lowcostflights.domain.Flight;
import hr.lowcostflights.repository.AirportRepository;

@Transactional
public class SearchServiceTest extends AbstractLowCostFlightsApplicationTest {

	@Autowired
	private AirportRepository airportRepository;

	@Autowired
	private SearchService searchService;

	@Test
	public void testFindFlights() {
		Airport origin = airportRepository.findOneByIataCode("IST");
		Airport destination = airportRepository.findOneByIataCode("BOS");

		List<Flight> fs = searchService.findFlights(origin, destination, LocalDate.now().plusDays(1),
				null, null, null, null, "USD");

		Assert.assertNotNull("failure - expected not null", fs);
	}

}
