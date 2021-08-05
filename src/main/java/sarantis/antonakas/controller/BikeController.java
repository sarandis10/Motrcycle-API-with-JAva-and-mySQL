package sarantis.antonakas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sarantis.antonakas.entity.Bike;
import sarantis.antonakas.repository.BikeRepository;
import sarantis.antonakas.request.CreateBikeRequest;
import sarantis.antonakas.request.UpdateBikeRequest;
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
	
	
	@PutMapping("updatebike")
	public BikeResponse updateBike(@Valid @RequestBody UpdateBikeRequest updateBikeRequest) {
		Bike bike =bikeService.updateBike(updateBikeRequest);
		return new BikeResponse(bike);
	}
	// i will try to do it below with the pathvariable instead
//	@DeleteMapping("deletebike")
//	public String deleteBike(@RequestParam long id) {
//		return bikeService.deleteBike(id);
//	}
	
	
	@DeleteMapping("deletebike/{id}")
	public String deleteBike(@PathVariable long id) {
		return bikeService.deleteBike(id);
	}
	
	@GetMapping("getbymake/{make}")
	public List<BikeResponse> getByMake(@PathVariable String make){
		List<Bike> bikeList=bikeService.getByMake(make);
		
		List <BikeResponse> bikeResponseList = new ArrayList<BikeResponse>();
		
		bikeList.stream().forEach(bike->{
			bikeResponseList.add(new BikeResponse(bike));
		});
		return bikeResponseList;
	}
	
	@GetMapping("getbymakeandhp/{make}/{hp}")
	public List<BikeResponse> getByMakeAndHp(@PathVariable String make,@PathVariable int hp){
		List<Bike> bikeList=bikeService.getByMakeAndHp(make,hp);
		
		List <BikeResponse> bikeResponseList = new ArrayList<BikeResponse>();
		
		bikeList.stream().forEach(bike->{
			bikeResponseList.add(new BikeResponse(bike));
		});
		return bikeResponseList;
	}
	
	
	@GetMapping("getbymakeorhp/{make}/{hp}")
	public List<BikeResponse> getByMakeOrHp(@PathVariable String make,
			@PathVariable int hp){
		List<Bike> bikeList=bikeService.getByMakeOrHp(make,hp);
		
		List <BikeResponse> bikeResponseList = new ArrayList<BikeResponse>();
		
		bikeList.stream().forEach(bike->{
			bikeResponseList.add(new BikeResponse(bike));
		});
		return bikeResponseList;
	}
	
	@GetMapping("getallwithpagination")
			public List<BikeResponse> getAllBikesWithPagination(@RequestParam int pageNo,
					@RequestParam int pageSize){
				
		List<Bike> bikeList=bikeService.getAllBikesWithPagination(pageNo,pageSize);
		
		List <BikeResponse> bikeResponseList = new ArrayList<BikeResponse>();
		
		bikeList.stream().forEach(bike->{
			bikeResponseList.add(new BikeResponse(bike));
		});
		return bikeResponseList;
	}
	
	@GetMapping("getallwithsorting")
	public List<BikeResponse> getAllWithSorting(){
		
		List<Bike> bikeList=bikeService.getAllBikesSorted();
		
		List <BikeResponse> bikeResponseList = new ArrayList<BikeResponse>();
		
		bikeList.stream().forEach(bike->{
			bikeResponseList.add(new BikeResponse(bike));
		});
		return bikeResponseList;
}
	
	
	
	
}
