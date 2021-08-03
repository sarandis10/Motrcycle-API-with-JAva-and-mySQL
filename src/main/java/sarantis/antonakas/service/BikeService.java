package sarantis.antonakas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sarantis.antonakas.entity.Bike;
import sarantis.antonakas.repository.BikeRepository;
import sarantis.antonakas.request.CreateBikeRequest;

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
}
