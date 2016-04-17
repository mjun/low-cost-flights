package hr.lowcostflights.integration.amadeus.domain;

import java.util.List;

import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightLowFareSearchResults {

	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("results")
	private List<Result> results;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		ToStringCreator builder = new ToStringCreator(this);
		builder.append("currency", currency);
		builder.append("results", results);
		return builder.toString();
	}
	
}
