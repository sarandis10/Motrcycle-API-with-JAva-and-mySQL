package sarantis.antonakas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sarantis.antonakas.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
