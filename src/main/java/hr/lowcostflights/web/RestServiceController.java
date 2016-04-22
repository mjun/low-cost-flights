package hr.lowcostflights.web;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.lowcostflights.domain.Airport;
import hr.lowcostflights.domain.Flight;
import hr.lowcostflights.service.AirportService;
import hr.lowcostflights.service.SearchService;

/**
 * Main application controller which provides REST methods for frontend
 * application. All REST methods return HTTP status 200 on success, 400 when
 * supplying invalid input parameters, 500 on all other server-side related
 * errors (exceptions).
 * 
 * @author matko
 *
 */

@CrossOrigin
@RestController
public class RestServiceController {

	private class RestErrorResponse {

		private Integer status;
		private String message;

		public RestErrorResponse(Integer status, String message) {
			this.status = status;
			this.message = message;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

	@Autowired
	private AirportService airportService;

	@Autowired
	private SearchService searchService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<?> search(@RequestParam(value = "origin") String originIataCode,
			@RequestParam(value = "destination") String destinationIataCode,
			@RequestParam(value = "departure") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate,
			@RequestParam(value = "return", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate,
			@RequestParam(value = "adults", required = false) Integer adults,
			@RequestParam(value = "children", required = false) Integer children,
			@RequestParam(value = "infants", required = false) Integer infants,
			@RequestParam(value = "currency") String currency) {

		Airport origin = airportService.getByIataCode(originIataCode);
		if (origin == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestErrorResponse(
					HttpStatus.BAD_REQUEST.value(), "Invalid origin IATA code '" + originIataCode + "'"));
		}
		Airport destination = airportService.getByIataCode(destinationIataCode);
		if (destination == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestErrorResponse(
					HttpStatus.BAD_REQUEST.value(), "Invalid origin IATA code '" + destinationIataCode + "'"));
		}

		if (departureDate == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new RestErrorResponse(HttpStatus.BAD_REQUEST.value(), "Departure date must be specified"));
		}

		if (returnDate != null && (returnDate.isBefore(departureDate))) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestErrorResponse(
					HttpStatus.BAD_REQUEST.value(), "Return date can not be before departure date"));
		}

		if (adults != null && adults < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new RestErrorResponse(HttpStatus.BAD_REQUEST.value(),
							"Number of adult passengers should be integer with value 0 or greater"));
		}

		if (adults != null && children < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new RestErrorResponse(HttpStatus.BAD_REQUEST.value(),
							"Number of children passengers should be integer with value 0 or greater"));
		}

		if (adults != null && infants < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new RestErrorResponse(HttpStatus.BAD_REQUEST.value(),
							"Number of infant passengers should be integer with value 0 or greater"));
		}

		if (currency == null || !((List<String>) Arrays.asList("HRK", "EUR", "USD")).contains(currency)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestErrorResponse(
					HttpStatus.BAD_REQUEST.value(), "Allowed values for currency are 'HRK', 'EUR' and 'USD'"));
		}

		try {
			List<Flight> aps = searchService.findFlights(origin, destination, departureDate, returnDate, adults,
					children, infants, currency);
			return ResponseEntity.ok(aps);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
		}
	}

	@RequestMapping(value = "/airport/{iataCode}", method = RequestMethod.GET)
	public ResponseEntity<?> getAirport(@PathVariable String iataCode) {
		if (iataCode.length() != 3 || iataCode != iataCode.toUpperCase()) {
			// Bad request
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new RestErrorResponse(HttpStatus.BAD_REQUEST.value(),
							"URL path variable should be a three letter uppercase designator. E.g. 'ZAG'"));
		}
		try {
			Airport ap = airportService.getByIataCode(iataCode);
			if (ap == null) {
				// Not found
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestErrorResponse(
						HttpStatus.NOT_FOUND.value(), "Airport with IATA code " + iataCode + " does not exist"));
			}
			return ResponseEntity.ok(ap);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
		}

	}

	@RequestMapping(value = "/airport/find", method = RequestMethod.GET)
	public ResponseEntity<?> findAirports(@RequestParam(value = "name") String name) {
		if (name == null || name.length() < 3) {
			// Bad request
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new RestErrorResponse(HttpStatus.BAD_REQUEST.value(),
							"Airport name or part of airport name should be at least 3 letters long"));
		}
		try {
			List<Airport> aps = airportService.findByName(name);
			return ResponseEntity.ok(aps);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
		}
	}

}
