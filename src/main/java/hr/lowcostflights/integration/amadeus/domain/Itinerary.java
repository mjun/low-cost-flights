package hr.lowcostflights.integration.amadeus.domain;

import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Itinerary {

	@JsonProperty("outbound")
	private Outbound outbound;
	
	@JsonProperty("inbound")
	private Inbound inbound;
	
	public Outbound getOutbound() {
		return outbound;
	}
	public void setOutbound(Outbound outbound) {
		this.outbound = outbound;
	}
	public Inbound getInbound() {
		return inbound;
	}
	public void setInbound(Inbound inbound) {
		this.inbound = inbound;
	}
	
	@Override
	public String toString() {
		ToStringCreator builder = new ToStringCreator(this);
		builder.append("outbound", outbound);
		builder.append("inbound", inbound);
		return builder.toString();
	}
	
	
}
