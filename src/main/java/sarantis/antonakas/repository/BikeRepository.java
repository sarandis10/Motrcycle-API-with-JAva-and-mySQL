package sarantis.antonakas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sarantis.antonakas.entity.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long>{
	

}
