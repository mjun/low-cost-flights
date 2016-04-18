package hr.lowcostflights.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.lowcostflights.domain.Airport;
import hr.lowcostflights.repository.AirportRepository;

@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	private AirportRepository airportRepository;
	
	@Override
	public Airport getByIataCode(String iataCode) {
		return airportRepository.findOneByIataCode(iataCode);
	}

	@Override
	public List<Airport> findByName(String name) {
		return (List<Airport>) airportRepository.findByNameContainingIgnoreCase(name);
	}

}
