package sarantis.antonakas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sarantis.antonakas.entity.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long>{
	
	
	List<Bike> findByMake(String make);
	
	List<Bike> findByMakeAndHp(String make,int hp);
	
	List<Bike> findByMakeOrHp(String make,int hp);
	
	
	// these are JPQL
	
	@Query("from Bike where make=:make and hp=:hp")
	List<Bike> getByMakeAndHp(String make,int hp);
	
	@Modifying
	@Transactional
	@Query("Update Bike set model = :model where id = :id")
	Integer updateModel (Long id, String model);

}
