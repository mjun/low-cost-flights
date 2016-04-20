package hr.lowcostflights.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import hr.lowcostflights.AbstractLowCostFlightsApplicationTest;
import hr.lowcostflights.domain.Airport;
import hr.lowcostflights.domain.Flight;
import hr.lowcostflights.repository.AirportRepository;
import hr.lowcostflights.repository.FlightRepository;

@Transactional
public class FlightServiceTest extends AbstractLowCostFlightsApplicationTest {

	@Autowired
	private AirportRepository airportRepository;

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private FlightService flightService;

	@Before
	public void setUp() {
		Airport ap1 = airportRepository.findOneByIataCode("IST");
		Airport ap2 = airportRepository.findOneByIataCode("BOS");
		Airport ap3 = airportRepository.findOneByIataCode("ZAG");
		flightRepository.save(new Flight(ap1, ap2, LocalDateTime.parse("1999-01-01T08:00:00"),
				LocalDateTime.parse("1999-01-05T08:00:00"), 0, 0, 1, 1, 1, "HRK", 123.0));
		flightRepository.save(new Flight(ap2, ap3, LocalDateTime.parse("1999-01-01T08:00:00"),
				LocalDateTime.parse("1999-01-05T08:00:00"), 1, 1, 1, 2, 3, "USD", 321.0));
		flightRepository.save(new Flight(ap3, ap1, LocalDateTime.parse("1999-01-01T08:00:00"),
				LocalDateTime.parse("1999-01-05T08:00:00"), 2, 0, 3, 2, 1, "EUR", 896.0));
	}

	@Test
	public void testFindSpecificFlight() {
		Airport origin = airportRepository.findOneByIataCode("IST");
		Airport destination = airportRepository.findOneByIataCode("BOS");

		Flight fs = flightService.findSpecificFlight(origin, destination, LocalDateTime.parse("1999-01-01T08:00:00"),
				LocalDateTime.parse("1999-01-05T08:00:00"), 0, 0, 1, 1, 1, "HRK", 123.0);

		Assert.assertNotNull("failure - expected not null", fs);
	}
}
