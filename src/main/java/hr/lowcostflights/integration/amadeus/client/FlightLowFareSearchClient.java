package hr.lowcostflights.integration.amadeus.client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import hr.lowcostflights.integration.amadeus.AmadeusConfiguration;
import hr.lowcostflights.integration.amadeus.domain.FlightLowFareSearchResults;

@Component
@EnableConfigurationProperties(AmadeusConfiguration.class)
public class FlightLowFareSearchClient {

	@Autowired
	private AmadeusConfiguration amadeusConfiguration;
	private final static String resourceUrl = "https://api.sandbox.amadeus.com/v1.2/flights/low-fare-search";

	public FlightLowFareSearchResults flightLowFareSearch(String origin, String destination, LocalDate departureDate,
			LocalDate returnDate, LocalDateTime arriveBy, LocalDateTime returnBy, Integer adults, Integer children,
			Integer infants, List<String> includeAirlines, List<String> excludeAirlines, Boolean nonStop,
			Integer maxPrice, String currency, String travelClass, Integer numberOfResults) {
		
		MultiValueMap<String, String> urlParameters = new LinkedMultiValueMap<String, String>();
		
		/* required parameters */
		urlParameters.add("apikey", amadeusConfiguration.getApiKey());
		urlParameters.add("origin", origin);
		urlParameters.add("destination", destination);
		urlParameters.add("departure_date", departureDate.toString());
		
		/* optional parameters */
		if (returnDate != null)			urlParameters.add("return_date", returnDate.toString());
		if (arriveBy != null) 			urlParameters.add("arrive_by", arriveBy.toString());
		if (returnBy != null) 			urlParameters.add("return_by", returnBy.toString());
		if (adults != null) 			urlParameters.add("adults", adults.toString());
		if (children != null) 			urlParameters.add("children",adults.toString());
		if (infants != null) 			urlParameters.add("infants", infants.toString());
		if (includeAirlines != null 
			&& includeAirlines.size()>0) 
										urlParameters.add("include_airlines", String.join(",", includeAirlines));
		if (excludeAirlines != null 
			&& excludeAirlines.size()>0) 
										urlParameters.add("exclude_airlines", String.join(",", excludeAirlines));
		if (nonStop != null) 			urlParameters.add("non-stop", nonStop.toString());
		if (maxPrice != null) 			urlParameters.add("max_price", maxPrice.toString());
		if (currency != null) 			urlParameters.add("currency", currency);
		if (travelClass != null)		urlParameters.add("travel_class", travelClass);
		if (numberOfResults != null)	urlParameters.add("number_of_results", numberOfResults.toString());

		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(resourceUrl).queryParams(urlParameters).build();
		     		
		RestTemplate restTemplate = new RestTemplate();
		FlightLowFareSearchResults results = restTemplate.getForObject(uriComponents.toString(), FlightLowFareSearchResults.class);
		return results;
	}

}
