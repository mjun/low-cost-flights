package hr.lowcostflights.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import hr.lowcostflights.domain.Airport;

public interface AirportRepository extends CrudRepository<Airport, Integer>, JpaSpecificationExecutor<Airport> {

	Airport findOneByIataCode(String iataCode);
	
	List<Airport> findByNameContainingIgnoreCase(String name);
	
	List<Airport> findByNameContainingIgnoreCase(String name, Pageable pageable);
	
}
