package hr.lowcostflights.repository;

import java.time.LocalDate;
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
import hr.lowcostflights.domain.Search;

@Transactional
public class SearchRepositoryTest extends AbstractLowCostFlightsApplicationTest {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private AirportRepository airportRepository;

	@Autowired
	private SearchRepository searchRepository;

	@Before
	public void setUp() {
		Airport ap1 = airportRepository.findOneByIataCode("IST");
		Airport ap2 = airportRepository.findOneByIataCode("BOS");
		List<Flight> fs = new ArrayList<Flight>();
		fs.add(new Flight(ap1, ap2, LocalDateTime.now(), LocalDateTime.now(), 0, 0, 1, 1, 1, "HRK", 123.0));
		flightRepository.save(fs);
		searchRepository.save(new Search(ap1, ap2, LocalDate.now(), LocalDate.now(), 0, 0, 1, "HRK", fs));
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testFindAll() {
		List<Search> s = (List<Search>) searchRepository.findAll();
		Assert.assertNotNull("failure - expected not null", s);
	}
}
