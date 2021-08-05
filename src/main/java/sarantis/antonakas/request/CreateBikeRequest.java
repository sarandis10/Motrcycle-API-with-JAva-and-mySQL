package sarantis.antonakas.request;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CreateBikeRequest {
	
	@NotBlank (message="make required")
	private String make;
	@NotBlank (message="model required")
	private String model;
	
	private int hp;

}
