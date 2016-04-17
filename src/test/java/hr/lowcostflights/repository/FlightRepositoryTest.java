package hr.lowcostflights.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
		List<Airport> aps = new ArrayList<Airport>();
		aps.add(new Airport("Utirik airport", "UTK"));
		aps.add(new Airport("Zagreb pleso","ZAG"));
		aps.add(new Airport("Ocean Reef Club Airport","OCA"));
        airportRepository.save(aps);
        flightRepository.save(new Flight(aps.get(0), aps.get(1), LocalDateTime.now(), LocalDateTime.now(), 0, 0, 1, 1, 1, "HRK", 123));
        flightRepository.save(new Flight(aps.get(1), aps.get(2), LocalDateTime.now(), LocalDateTime.now(), 1, 1, 1, 2, 3, "USD", 321));
        flightRepository.save(new Flight(aps.get(2), aps.get(0), LocalDateTime.now(), LocalDateTime.now(), 2, 0, 3, 2, 1, "EUR", 896));
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testFindAll() {
		List<Flight> fs = (List<Flight>) flightRepository.findAll();
		Assert.assertNotNull("failure - expected not null", fs);
		Assert.assertEquals("failire - expected size", 3, fs.size());
	}
}
