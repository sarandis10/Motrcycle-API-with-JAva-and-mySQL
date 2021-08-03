package sarantis.antonakas.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sarantis.antonakas.entity.Bike;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
@Data
@AllArgsConstructor
public class BikeResponse {
	
//	@JsonIgnore if you want to ignore one field!
	private Long id;
	
//	@JsonProperty("Manufacturer")
	private String make;
	
	private String model;
	
	private int hp;
	
	public BikeResponse (Bike bike) {
		this.id= bike.getId();
		this.make=bike.getMake();
		this.model= bike.getModel();
		this.hp=bike.getHp();
	}
	

}
