package hr.lowcostflights.service;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import hr.lowcostflights.AbstractLowCostFlightsApplicationTest;
import hr.lowcostflights.domain.Airport;

@Transactional
public class AirportServiceTest extends AbstractLowCostFlightsApplicationTest {

	@Autowired
	private AirportService airportService;
	
	@Test
	public void testGetByIataCode() {
		Airport ap = airportService.getByIataCode("ZAG");
		Assert.assertNotNull("failure - expected not null", ap);
	}
	
	@Test
	public void testFindByName() {
		List<Airport> aps = (List<Airport>) airportService.findByName("AIRPORT");
		Assert.assertNotNull("failure - expected not null", aps);
		
	}
	
	
}
