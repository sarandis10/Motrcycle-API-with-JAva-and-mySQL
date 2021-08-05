package sarantis.antonakas.request;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBikeRequest {
	
	@NotNull
	private Long id;
	
	private String make;
	
	private String model;
	
	private int hp;

}
