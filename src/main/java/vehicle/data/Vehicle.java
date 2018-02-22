package vehicle.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "vehicles")
public class Vehicle {
	
	

	public Vehicle() {
		super();

	}

	// Variables used in the API
	
	@Id @GeneratedValue
	@Column(name="id")
	private Long id;
	@Column(name="make")
	private String make;
	
	@Column(name="year")
	private Long year;
	
	@Column(name="VIN")
	private String VIN;
	
	
	// Getter and Setters
	
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vin) {
		this.VIN = vin;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	// Constructor
	
	public Vehicle(Long id, String make, Long year, String vin) {
		this.id = id;
		this.make = make;
		this.year = year;
		this.VIN = vin;
	}
	
	// to String Method
	
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", make=" + make + ", year=" + year + ", VIN=" + VIN + "]";
	}
	
	
	
	
}
