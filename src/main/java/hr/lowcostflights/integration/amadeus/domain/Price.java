package hr.lowcostflights.integration.amadeus.domain;

public class Price {
	
	private String totalFare;
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
	
}
