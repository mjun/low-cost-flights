package hr.lowcostflights.integration.amadeus.domain;

import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Airport {
    
	@JsonProperty("airport")
    private String airport;
	
	@JsonProperty("terminal")
    private String terminal;
    
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	
	@Override
	public String toString() {
		ToStringCreator builder = new ToStringCreator(this);
		builder.append("airport", airport);
		builder.append("terminal", terminal);
		return builder.toString();
	}

	
}
