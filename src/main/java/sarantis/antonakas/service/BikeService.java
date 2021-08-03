package sarantis.antonakas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sarantis.antonakas.entity.Bike;
import sarantis.antonakas.repository.BikeRepository;

@Service
public class BikeService {
	
	@Autowired
	BikeRepository bikeRepository;
	
	public List<Bike> getAllBikes() {
		 return bikeRepository.findAll();
	}

}
