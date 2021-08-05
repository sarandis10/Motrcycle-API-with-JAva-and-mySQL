package sarantis.antonakas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sarantis.antonakas.entity.Bike;
import sarantis.antonakas.request.CreateBikeRequest;
import sarantis.antonakas.response.BikeResponse;
import sarantis.antonakas.service.BikeService;


@RestController //combination of @controller and @Responcebody on the methods 
@RequestMapping("/api/bike/")
public class BikeController {
	
	@Autowired
	BikeService bikeService; 
	
	@GetMapping("getAll")
	public List <BikeResponse> getAllBikes() {
		List <Bike> bikeList=bikeService.getAllBikes();
		List <BikeResponse> bikeResponseList = new ArrayList<BikeResponse>();
		
		bikeList.stream().forEach(bike->{
			bikeResponseList.add(new BikeResponse(bike));
		});
		return bikeResponseList;
	}
	
	@PostMapping("addbike")
	public BikeResponse createBike(@Valid @RequestBody CreateBikeRequest createBikeRequest) {
		Bike bike = bikeService.createBike(createBikeRequest);
		
		return new BikeResponse(bike);
	}
}
