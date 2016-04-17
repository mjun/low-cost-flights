package hr.lowcostflights.repository;

import org.springframework.data.repository.CrudRepository;

import hr.lowcostflights.domain.Airport;

public interface AirportRepository extends CrudRepository<Airport, Integer> {

	Iterable<Airport> findByNameContainingIgnoreCase(String name);
	
}
