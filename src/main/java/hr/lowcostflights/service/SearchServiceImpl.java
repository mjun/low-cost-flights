package hr.lowcostflights.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.lowcostflights.domain.Airport;
import hr.lowcostflights.domain.Flight;
import hr.lowcostflights.domain.Search;
import hr.lowcostflights.integration.amadeus.client.FlightLowFareSearchClient;
import hr.lowcostflights.integration.amadeus.domain.FlightLowFareSearchResults;
import hr.lowcostflights.integration.amadeus.domain.Itinerary;
import hr.lowcostflights.integration.amadeus.domain.Result;
import hr.lowcostflights.repository.FlightRepository;
import hr.lowcostflights.repository.SearchRepository;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchRepository searchRepository;
	
	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private FlightLowFareSearchClient amadeusflightLowFareSearchClient;

	@Autowired
	private FlightService flightService;

	@Override
	@Transactional
	public List<Flight> findFlights(Airport origin, Airport destination, LocalDate departureDate, LocalDate returnDate,
			Integer adults, Integer children, Integer infants, String currency) {

		// treat passenger null values as 0 value integers
		if (adults == null) {
			adults = 0;
		}
		if (children == null) {
			children = 0;
		}
		if (infants == null) {
			infants = 0;
		}
		
		// see if there already was a search with these parameters
		Search search = searchRepository
				.findOneByOriginAndDestinationAndDepartureDateAndReturnDateAndAdultsAndChildrenAndInfantsAndCurrency(
						origin, destination, departureDate, returnDate, adults, children, infants, currency);

		// this is a brand new search
		if (search == null) {
			// create new search object
			search = new Search(origin, destination, departureDate, returnDate, adults, children, infants, currency,
					null);

			// fetch flights from Amadeus API
			FlightLowFareSearchResults amadeusResults = amadeusflightLowFareSearchClient.flightLowFareSearch(
					origin.getIataCode(), destination.getIataCode(), departureDate, returnDate, null, null, adults,
					children, infants, null, null, null, null, currency, null, null);

			if (amadeusResults.getResults() != null) {
				List<Flight> flights = new ArrayList<Flight>();

				for (Result amadeusFlight : amadeusResults.getResults()) {
					for (Itinerary amadeusItinerary : amadeusFlight.getItineraries()) {
						Flight flight = flightService.findSpecificFlight(origin, destination,
								amadeusItinerary.getOutbound().getFlights().get(0).getDepartsAt(),
								(amadeusItinerary.getInbound() != null)
										? amadeusItinerary.getInbound().getFlights().get(0).getDepartsAt() : null,
								amadeusItinerary.getOutbound().getFlights().size() - 1,
								(amadeusItinerary.getInbound() != null)
										? amadeusItinerary.getInbound().getFlights().size() - 1 : null,
								adults, children, infants, currency,
								Double.parseDouble(amadeusFlight.getFare().getTotalPrice()));
						if (flight == null) {
							flight = new Flight(origin, destination,
									amadeusItinerary.getOutbound().getFlights().get(0).getDepartsAt(),
									(amadeusItinerary.getInbound() != null)
											? amadeusItinerary.getInbound().getFlights().get(0).getDepartsAt() : null,
									amadeusItinerary.getOutbound().getFlights().size() - 1,
									(amadeusItinerary.getInbound() != null)
											? amadeusItinerary.getInbound().getFlights().size() - 1 : null,
									adults, children, infants, currency,
									Double.parseDouble(amadeusFlight.getFare().getTotalPrice()));
							flightRepository.save(flight);
						}
						flights.add(flight);
					}
				}
				search.setFlights(flights);
			}
			searchRepository.save(search);
		}

		// return flights for this search
		return search.getFlights();
	}

}
