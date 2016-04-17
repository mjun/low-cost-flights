package hr.lowcostflights.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "searches", uniqueConstraints = { @UniqueConstraint(columnNames = { "origin_id", "destination_id",
		"departure", "arrival", "adults", "children", "infants", "currency" }) })
public class Search {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Airport origin;

	@ManyToOne(cascade = CascadeType.ALL)
	private Airport destination;

	@Column(name = "departure")
	private LocalDate departure;

	@Column(name = "arrival")
	private LocalDate arrival;

	@Column(name = "adults")
	private Integer adults;

	@Column(name = "children")
	private Integer children;

	@Column(name = "infants")
	private Integer infants;

	@Column(name = "currency")
	private String currency;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "flight_search", joinColumns = @JoinColumn(name = "search_id"), inverseJoinColumns = @JoinColumn(name = "flight_id"))
	private List<Flight> flights;

	protected Search() {}
	
	public Search(Airport origin, Airport destination, LocalDate departure, LocalDate arrival, Integer adults,
			Integer children, Integer infants, String currency, List<Flight> flights) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		this.adults = adults;
		this.children = children;
		this.infants = infants;
		this.currency = currency;
		this.flights = flights;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Airport getOrigin() {
		return origin;
	}

	public void setOrigin(Airport origin) {
		this.origin = origin;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	public LocalDate getDeparture() {
		return departure;
	}

	public void setDeparture(LocalDate departure) {
		this.departure = departure;
	}

	public LocalDate getArrival() {
		return arrival;
	}

	public void setArrival(LocalDate arrival) {
		this.arrival = arrival;
	}

	public Integer getAdults() {
		return adults;
	}

	public void setAdults(Integer adults) {
		this.adults = adults;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public Integer getInfants() {
		return infants;
	}

	public void setInfants(Integer infants) {
		this.infants = infants;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		ToStringCreator builder = new ToStringCreator(this);
		builder.append("id", id);
		builder.append("origin", origin);
		builder.append("destination", destination);
		builder.append("departure", departure);
		builder.append("arrival", arrival);
		builder.append("adults", adults);
		builder.append("children", children);
		builder.append("infants", infants);
		builder.append("currency", currency);
		builder.append("flights", flights);
		return builder.toString();
	}

}