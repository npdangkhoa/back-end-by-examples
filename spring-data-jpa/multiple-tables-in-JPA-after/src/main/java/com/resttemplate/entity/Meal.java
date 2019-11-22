package com.resttemplate.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name ="MEAL")
@SecondaryTable(name="", pkJoinColumns = @PrimaryKeyJoinColumn(name="meal_id"))
public class Meal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
	
	@Embedded
	Allergens allergens;
 
    @Column(name = "name")
    String name;
 
    @Column(name = "description")
    String description;
 
    @Column(name = "price")
    BigDecimal price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Allergens getAllergens() {
		return allergens;
	}

	public void setAllergens(Allergens allergens) {
		this.allergens = allergens;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
    
    
}
