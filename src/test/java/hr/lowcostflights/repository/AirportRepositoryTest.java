package hr.lowcostflights.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import hr.lowcostflights.AbstractLowCostFlightsApplicationTest;
import hr.lowcostflights.domain.Airport;

@Transactional
public class AirportRepositoryTest extends AbstractLowCostFlightsApplicationTest {

	@Autowired
	private AirportRepository airportRepository;
	
	@Before
	public void setUp() {
        airportRepository.save(new Airport("Utirik airport", "-T1"));
        airportRepository.save(new Airport("Zagreb pleso","-T2"));
        airportRepository.save(new Airport("Ocean Reef Club Airport","-T3"));
	}
	
	@After
	public void tearDown() {
	}
	
	
	@Test
	public void testFindAll() {
		List<Airport> aps = (List<Airport>) airportRepository.findAll();
		Assert.assertNotNull("failure - expected not null", aps);
	}
	
	@Test
	public void testFindByNameContainingIgnoreCase() {
		List<Airport> aps = (List<Airport>) airportRepository.findByNameContainingIgnoreCase("AIRPORT");
		Assert.assertNotNull("failure - expected not null", aps);
	}
	
}
