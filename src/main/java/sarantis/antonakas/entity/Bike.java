package sarantis.antonakas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="bikes")
public class Bike {
	
	@Id
//	@GeneratedValue i don't have auto generated on the db
	@Column(name="id")
	private Long id;
	
	@Column(name="make")
	private String make;
	
	@Column(name="model")
	private String model;
	
	@Column(name="hp")
	private int hp;

}
