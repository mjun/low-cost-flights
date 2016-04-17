package hr.lowcostflights.repository;

import org.springframework.data.repository.CrudRepository;

import hr.lowcostflights.domain.Search;

public interface SearchRepository extends CrudRepository<Search, Integer> {

}
