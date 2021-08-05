package sarantis.antonakas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sarantis.antonakas.entity.Bike;
import sarantis.antonakas.repository.BikeRepository;
import sarantis.antonakas.request.CreateBikeRequest;
import sarantis.antonakas.request.UpdateBikeRequest;

@Service
public class BikeService {
	
	@Autowired
	BikeRepository bikeRepository;
	
	public List<Bike> getAllBikes() {
		 return bikeRepository.findAll();
	}
	
	
	public Bike createBike(CreateBikeRequest createBikeRequest) {
		Bike bike=new Bike(createBikeRequest);
		
		bike = bikeRepository.save(bike);
		return bike;
	}
	
	public Bike updateBike (UpdateBikeRequest updateBikeRequest ) {
		Bike bike = bikeRepository.findById(updateBikeRequest.getId()).get();
		
		if (updateBikeRequest.getMake()!=null && !updateBikeRequest.getMake().isEmpty()) {
			bike.setMake(updateBikeRequest.getMake());
		}
		
		bike = bikeRepository.save(bike);
		return bike;
		
	}
}