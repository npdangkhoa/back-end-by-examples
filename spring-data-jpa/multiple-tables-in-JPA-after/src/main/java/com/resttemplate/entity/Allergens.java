package com.resttemplate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Allergens {

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "meal_id")
//	Long mealId;
	
//	@OneToOne
//	@PrimaryKeyJoinColumn(name="meal_id")
//	Meal meal;
	
    @Column(name = "peanuts", table="allergens")
    boolean peanuts;
 
    @Column(name = "celery", table ="allergens")
    boolean celery;
 
    @Column(name = "sesame_seeds", table = "allergens")
    boolean sesameSeeds;


	public boolean isPeanuts() {
		return peanuts;
	}

	public void setPeanuts(boolean peanuts) {
		this.peanuts = peanuts;
	}

	public boolean isCelery() {
		return celery;
	}

	public void setCelery(boolean celery) {
		this.celery = celery;
	}

	public boolean isSesameSeeds() {
		return sesameSeeds;
	}

	public void setSesameSeeds(boolean sesameSeeds) {
		this.sesameSeeds = sesameSeeds;
	}
 
 
    
}
