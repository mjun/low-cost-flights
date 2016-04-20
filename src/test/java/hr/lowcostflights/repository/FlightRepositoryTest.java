package hr.lowcostflights.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import hr.lowcostflights.AbstractLowCostFlightsApplicationTest;
import hr.lowcostflights.domain.Airport;
import hr.lowcostflights.domain.Flight;

@Transactional
public class FlightRepositoryTest extends AbstractLowCostFlightsApplicationTest {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private AirportRepository airportRepository;

	@Before
	public void setUp() {
		Airport ap1 = airportRepository.findOneByIataCode("IST");
		Airport ap2 = airportRepository.findOneByIataCode("BOS");
		Airport ap3 = airportRepository.findOneByIataCode("ZAG");
		flightRepository
				.save(new Flight(ap1, ap2, LocalDateTime.now(), LocalDateTime.now(), 0, 0, 1, 1, 1, "HRK", 123.0));
		flightRepository
				.save(new Flight(ap2, ap3, LocalDateTime.now(), LocalDateTime.now(), 1, 1, 1, 2, 3, "USD", 321.0));
		flightRepository
				.save(new Flight(ap3, ap2, LocalDateTime.now(), LocalDateTime.now(), 2, 0, 3, 2, 1, "EUR", 896.0));
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testFindAll() {
		List<Flight> fs = (List<Flight>) flightRepository.findAll();
		Assert.assertNotNull("failure - expected not null", fs);
	}
}
