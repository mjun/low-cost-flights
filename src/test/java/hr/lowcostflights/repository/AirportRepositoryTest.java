package hr.lowcostflights.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import hr.lowcostflights.AbstractLowCostFlightsApplicationTest;
import hr.lowcostflights.domain.Airport;

@Transactional
public class AirportRepositoryTest extends AbstractLowCostFlightsApplicationTest {

	@Autowired
	private AirportRepository airportRepository;

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
