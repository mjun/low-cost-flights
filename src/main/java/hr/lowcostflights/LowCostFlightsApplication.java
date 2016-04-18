package hr.lowcostflights;

import org.h2.server.web.WebServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import hr.lowcostflights.integration.amadeus.AmadeusConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(AmadeusConfiguration.class)
public class LowCostFlightsApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(LowCostFlightsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LowCostFlightsApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {        
    }
	
	// expose H2 database console
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
	    registration.addUrlMappings("/console/*");
	    return registration;
	}
	
}
