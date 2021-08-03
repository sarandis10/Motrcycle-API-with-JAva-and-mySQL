package sarantis.antonakas.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateBikeRequest {
	
	
	private String make;
	
	private String model;
	
	private int hp;

}
