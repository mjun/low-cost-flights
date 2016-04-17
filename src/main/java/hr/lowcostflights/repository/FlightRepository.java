package hr.lowcostflights.repository;

import org.springframework.data.repository.CrudRepository;

import hr.lowcostflights.domain.Flight;

public interface FlightRepository extends CrudRepository<Flight, Integer> {

}
