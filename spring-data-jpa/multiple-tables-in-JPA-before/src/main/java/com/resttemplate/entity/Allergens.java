package com.resttemplate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ALLERGENS")
public class Allergens {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "meal_id")
	Long mealId;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="meal_id")
	Meal meal;
	
    @Column(name = "peanuts")
    boolean peanuts;
 
    @Column(name = "celery")
    boolean celery;
 
    @Column(name = "sesame_seeds")
    boolean sesameSeeds;

    
	public Long getMealId() {
		return mealId;
	}

	public void setMealId(Long mealId) {
		this.mealId = mealId;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

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
