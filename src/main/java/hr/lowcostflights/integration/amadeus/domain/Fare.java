package hr.lowcostflights.integration.amadeus.domain;

public class Fare {
	
	private String totalPrice;
	private Price pricePerAdult;
	private Price pricePerChild;
	private Price pricePerInfant;
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
	
}
