package hr.lowcostflights.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name="airports")
public class Airport {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="name", nullable=false, length=255)
	private String name;
	
	@Column(name="iata_code", nullable=false, unique=true, length=3)
	private String iataCode;

	protected Airport() {}
	
	public Airport(String name, String iataCode) {
		super();
		this.name = name;
		this.iataCode = iataCode;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	@Override
	public String toString() {
		ToStringCreator builder = new ToStringCreator(this);
		builder.append("id", id);
		builder.append("name", name);
		builder.append("iataCode", iataCode);
		return builder.toString();
	}
	
}
