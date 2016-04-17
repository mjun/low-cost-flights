package hr.lowcostflights.integration.amadeus.domain;

import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fare {
	
	@JsonProperty("total_price")
	private String totalPrice;
	
	@JsonProperty("price_per_adult")
	private Price pricePerAdult;
	
	@JsonProperty("price_per_child")
	private Price pricePerChild;
	
	@JsonProperty("price_per_infant")
	private Price pricePerInfant;
	
	@JsonProperty("restrictions")
	private Restrictions restrictions;
	
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Price getPricePerAdult() {
		return pricePerAdult;
	}
	public void setPricePerAdult(Price pricePerAdult) {
		this.pricePerAdult = pricePerAdult;
	}
	public Price getPricePerChild() {
		return pricePerChild;
	}
	public void setPricePerChild(Price pricePerChild) {
		this.pricePerChild = pricePerChild;
	}
	public Price getPricePerInfant() {
		return pricePerInfant;
	}
	public void setPricePerInfant(Price pricePerInfant) {
		this.pricePerInfant = pricePerInfant;
	}
	public Restrictions getRestrictions() {
		return restrictions;
	}
	public void setRestrictions(Restrictions restrictions) {
		this.restrictions = restrictions;
	}
	
	@Override
	public String toString() {
		ToStringCreator builder = new ToStringCreator(this);
		builder.append("totalPrice", totalPrice);
		builder.append("pricePerAdult", pricePerAdult);
		builder.append("pricePerChild", pricePerChild);
		builder.append("pricePerInfant", pricePerInfant);
		builder.append("restrictions", restrictions);
		return builder.toString();
	}
	
	
}
