package hr.lowcostflights.integration.amadeus.domain;

import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {
	
	@JsonProperty("total_fare")
	private String totalFare;
	
	@JsonProperty("tax")
	private String tax;
	
	public String getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(String totalFare) {
		this.totalFare = totalFare;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	
	@Override
	public String toString() {
		ToStringCreator builder = new ToStringCreator(this);
		builder.append("totalFare", totalFare);
		builder.append("tax", tax);
		return builder.toString();
	}
}
