package hr.lowcostflights;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.h2.server.web.WebServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import hr.lowcostflights.domain.Airport;
import hr.lowcostflights.integration.amadeus.AmadeusConfiguration;
import hr.lowcostflights.integration.amadeus.client.FlightLowFareSearchClient;
import hr.lowcostflights.integration.amadeus.domain.FlightLowFareSearchResults;
import hr.lowcostflights.repository.AirportRepository;

@SpringBootApplication
@EnableConfigurationProperties(AmadeusConfiguration.class)
public class LowCostFlightsApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(LowCostFlightsApplication.class);
	
	@Autowired
	private FlightLowFareSearchClient flightLowFareSearchClient;
	
	@Autowired
	private AirportRepository airportRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LowCostFlightsApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		// amadeus rest client test
        // FlightLowFareSearchResults results = flightLowFareSearchClient.flightLowFareSearch("BOS", "LOS", LocalDate.now(), null, null, null, null, null, null, null, null, null, null, null, null, 5);
        // log.info(results.toString());
        
        // hiberante test
        //Airport ap = new Airport("Utirik airport", "UTK");
        //airportRepository.save(ap);
		//List<Airport> ap1 = airportRepository.findByNameContainingIgnoreCase("TIRIK");
		//log.info(ap1.get(0).toString());
		
        
        //Airport ap1 = airportRepository.findOne(1);
        //log.info(ap1.toString());
        
    }
	
	// expose H2 database console
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
	    registration.addUrlMappings("/console/*");
	    return registration;
	}
	
}
