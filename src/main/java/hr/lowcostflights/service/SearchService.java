package hr.lowcostflights.service;

import java.time.LocalDate;
import java.util.List;

import hr.lowcostflights.domain.Airport;
import hr.lowcostflights.domain.Flight;

public interface SearchService {

	/**
	 * Returns list of possible flight intineraries for given input parameters.
	 * <p>
	 * Method relies on external Amadeus REST API for retrieval of possible
	 * flight itineraries. Once retrieved from Amadeus, results are stored in
	 * local database so they can be fetched for subsequent searches without 
	 * contacting Amadeus API.
	 * <p>
	 * Search logic workflow is as follows:
	 * <ol>
	 * <li>1. Try to find if there already was a search with given parameters,
	 * if such search exists just return already stored flight itineraries from
	 * local database.
	 * <li>2. If this is a brand new search, retrieve flight itineraries from 
	 * Amadeus API.
	 * <li>3. Save each unique flight itinerary from Amadeus to local database.
	 * <li>4. Assign retrieved (and saved) flight itinerararies to search instance.
	 * <li>5. Return list of stored flight itineraries.  
	 * 
	 * @param origin Originating airport
	 * @param destination Destination airport
	 * @param departureDate Departure date
	 * @param returnDate Return date (optional)
	 * @param adults Number of adult passengers (optional)
	 * @param children Number of children passengers (optional)
	 * @param infants Number of infant passengers (optional)
	 * @param currency Flight total price currency (optional) 
	 * @return List of Flight instances
	 */
	public List<Flight> findFlights(Airport origin, Airport destination, LocalDate departureDate, LocalDate returnDate,
			Integer adults, Integer children, Integer infants, String currency);

}
