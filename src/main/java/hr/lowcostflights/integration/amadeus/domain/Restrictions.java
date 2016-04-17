package hr.lowcostflights.integration.amadeus.domain;

import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Restrictions {

	@JsonProperty("refundable")
	private Boolean refundable;
	
	@JsonProperty("change_penalties")
	private Boolean changePenalties;
	
	public Boolean getRefundable() {
		return refundable;
	}
	public void setRefundable(Boolean refundable) {
		this.refundable = refundable;
	}
	public Boolean getChangePenalties() {
		return changePenalties;
	}
	public void setChangePenalties(Boolean changePenalties) {
		this.changePenalties = changePenalties;
	}
	
	@Override
	public String toString() {
		ToStringCreator builder = new ToStringCreator(this);
		builder.append("refundable", refundable);
		builder.append("changePenalties", changePenalties);
		return builder.toString();
	}

}
