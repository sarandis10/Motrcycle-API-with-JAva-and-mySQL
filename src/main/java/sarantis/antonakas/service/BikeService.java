package sarantis.antonakas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	public String deleteBike (long id) {
		bikeRepository.deleteById(id);
		return "motorcycle is deleted!";
	}
	
	public List<Bike> getByMake (String make){
		return bikeRepository.findByMake(make);
	}
	
	public List<Bike> getByMakeAndHp (String make, int hp){
		return bikeRepository.findByMakeAndHp(make, hp);
	}
	
	public List<Bike> getByMakeOrHp (String make, int hp){
		return bikeRepository.findByMakeOrHp(make, hp);
	}
	
	public List<Bike> getAllBikesWithPagination (int pageNo, int pageSize){
		Pageable pageable= PageRequest.of(pageNo-1, pageSize);
		
		return bikeRepository.findAll(pageable).getContent();
	}
	
	public List<Bike> getAllBikesSorted (){
		Sort sort =Sort.by(Sort.Direction.ASC, "hp");
		
		return bikeRepository.findAll(sort);
		
	}
	
}
