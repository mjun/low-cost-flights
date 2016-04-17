package hr.lowcostflights.integration.amadeus;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import hr.lowcostflights.AbstractLowCostFlightsApplicationTest;
import hr.lowcostflights.integration.amadeus.client.FlightLowFareSearchClient;
import hr.lowcostflights.integration.amadeus.domain.FlightLowFareSearchResults;

public class FlightLowFareSearchClientTest extends AbstractLowCostFlightsApplicationTest {
	
	@Autowired
	private FlightLowFareSearchClient flightLowFareSearchClient;
	
	@Test
	public void testFlightLowFareSearch() {
		FlightLowFareSearchResults results = flightLowFareSearchClient.flightLowFareSearch("BOS", "LOS", LocalDate.now(), null, null, null, null, null, null, null, null, null, null, null, null, 5);
	
		Assert.assertNotNull("failure - expected not null", results);
	}

}
