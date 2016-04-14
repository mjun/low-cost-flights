package hr.lowcostflights;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import hr.lowcostflights.integration.amadeus.AmadeusConfiguration;
import hr.lowcostflights.integration.amadeus.client.FlightLowFareSearchClient;
import hr.lowcostflights.integration.amadeus.domain.FlightLowFareSearchResults;

@SpringBootApplication
@EnableConfigurationProperties(AmadeusConfiguration.class)
public class LowCostFlightsApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(LowCostFlightsApplication.class);
	
	@Autowired
	private FlightLowFareSearchClient flightLowFareSearchClient;
	
	public static void main(String[] args) {
		SpringApplication.run(LowCostFlightsApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		// amadeus rest client test
        FlightLowFareSearchResults results = flightLowFareSearchClient.flightLowFareSearch("BOS", "LOS", LocalDate.now(), null, null, null, null, null, null, null, null, null, null, null, null, 5);
        log.info(results.toString());
    }
	
}
