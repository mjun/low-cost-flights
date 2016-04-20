package hr.lowcostflights.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "flights", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "origin_id", "destination_id", "departure_datetime", "return_datetime",
				"outbound_stops", "inbound_stops", "adults", "children", "infants", "currency", "total_price" }) })
public class Flight {

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

	@Column(name = "departure_datetime")
	@JsonProperty("departure_datetime")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime departureDateTime;

	@Column(name = "return_datetime")
	@JsonProperty("return_datetime")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime returnDateTime;

	@Column(name = "outbound_stops")
	@JsonProperty("outbound_stops")
	private Integer outboundStops;

	@Column(name = "inbound_stops")
	@JsonProperty("inbound_stops")
	private Integer inboundStops;

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

	@Column(name = "total_price")
	@JsonProperty("total_price")
	private Double totalPrice;

	protected Flight() {
	}

	public Flight(Airport origin, Airport destination, LocalDateTime departureDateTime, LocalDateTime returnDateTime,
			Integer outboundStops, Integer inboundStops, Integer adults, Integer children, Integer infants,
			String currency, Double totalPrice) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.departureDateTime = departureDateTime;
		this.returnDateTime = returnDateTime;
		this.outboundStops = outboundStops;
		this.inboundStops = inboundStops;
		this.adults = adults;
		this.children = children;
		this.infants = infants;
		this.currency = currency;
		this.totalPrice = totalPrice;
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

	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public LocalDateTime getReturnDateTime() {
		return returnDateTime;
	}

	public void setArrival(LocalDateTime returnDateTime) {
		this.returnDateTime = returnDateTime;
	}

	public Integer getOutboundStops() {
		return outboundStops;
	}

	public void setOutboundStops(Integer outboundStops) {
		this.outboundStops = outboundStops;
	}

	public Integer getInboundStops() {
		return inboundStops;
	}

	public void setInboundStops(Integer inboundStops) {
		this.inboundStops = inboundStops;
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

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		ToStringCreator builder = new ToStringCreator(this);
		builder.append("id", id);
		builder.append("origin", origin);
		builder.append("destination", destination);
		builder.append("departureDateTime", departureDateTime);
		builder.append("returnDateTime", returnDateTime);
		builder.append("outboundStops", outboundStops);
		builder.append("inboundStops", inboundStops);
		builder.append("adults", adults);
		builder.append("children", children);
		builder.append("infants", infants);
		builder.append("currency", currency);
		builder.append("totalPrice", totalPrice);
		return builder.toString();
	}

}
