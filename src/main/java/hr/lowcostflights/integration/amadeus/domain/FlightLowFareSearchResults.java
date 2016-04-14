package hr.lowcostflights.integration.amadeus.domain;

import java.util.List;

public class FlightLowFareSearchResults {

	private String currency;
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
		return "### Results: " + this.getCurrency() + " " + this.getResults().toString();
	}
	
}
