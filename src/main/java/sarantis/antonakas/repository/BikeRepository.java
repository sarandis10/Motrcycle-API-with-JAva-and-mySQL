package sarantis.antonakas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sarantis.antonakas.entity.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long>{
	
	
	List<Bike> findByMake(String make);
	
	List<Bike> findByMakeAndHp(String make,int hp);
	
	List<Bike> findByMakeOrHp(String make,int hp);
}
