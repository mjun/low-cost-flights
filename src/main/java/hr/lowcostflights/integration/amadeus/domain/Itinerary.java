package hr.lowcostflights.integration.amadeus.domain;

public class Itinerary {

	private Outbound outbound;
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
	
}
