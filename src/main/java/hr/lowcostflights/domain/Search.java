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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Entity
@Table(name = "searches", uniqueConstraints = { @UniqueConstraint(columnNames = { "origin_id", "destination_id",
		"departure_date", "return_date", "adults", "children", "infants", "currency" }) })
public class Search {

	@Id
	@GeneratedValue
	@JsonProperty("id")
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonProperty("origin")
	private Airport origin;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonProperty("destination")
	private Airport destination;

	@Column(name = "departure_date")
	@JsonProperty("departure_date")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDate departureDate;

	@Column(name = "return_date")
	@JsonProperty("return_date")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDate returnDate;

	@Column(name = "adults")
	@JsonProperty("adults")
	private Integer adults;

	@Column(name = "children")
	@JsonProperty("children")
	private Integer children;

	@Column(name = "infants")
	@JsonProperty("infants")
	private Integer infants;

	@Column(name = "currency")
	@JsonProperty("currency")
	private String currency;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "flight_search", joinColumns = @JoinColumn(name = "search_id"), inverseJoinColumns = @JoinColumn(name = "flight_id"))
	private List<Flight> flights;

	protected Search() {
	}

	public Search(Airport origin, Airport destination, LocalDate departureDate, LocalDate returnDate, Integer adults,
			Integer children, Integer infants, String currency, List<Flight> flights) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
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

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
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
		builder.append("departureDate", departureDate);
		builder.append("returnDate", returnDate);
		builder.append("adults", adults);
		builder.append("children", children);
		builder.append("infants", infants);
		builder.append("currency", currency);
		builder.append("flights", flights);
		return builder.toString();
	}

}
