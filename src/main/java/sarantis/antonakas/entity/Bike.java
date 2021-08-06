package sarantis.antonakas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sarantis.antonakas.request.CreateBikeRequest;

@Getter
@Setter
@Entity
@Table(name="bikes")
@NoArgsConstructor
public class Bike {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="make")
	private String make;
	
	@Column(name="model")
	private String model;
	
	@Column(name="hp")
	private int hp;
	
	@OneToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	public Bike (CreateBikeRequest createBikeRequest) {
		this.make=createBikeRequest.getMake();
		this.model=createBikeRequest.getModel();
		this.hp=createBikeRequest.getHp();
	}

}
