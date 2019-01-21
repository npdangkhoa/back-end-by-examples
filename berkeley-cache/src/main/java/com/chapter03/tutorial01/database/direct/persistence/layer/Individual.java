package com.chapter03.tutorial01.database.direct.persistence.layer;

import com.sleepycat.persist.model.DeleteAction;
import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

//Indicates a persistent entity class.
@Entity
public class Individual {

	// Indicates the primary key field of an entity class
	// @PrimaryKey and will be automatically filled by the BerkeleyDB engine.
	@PrimaryKey(sequence = "individual")
	private long id;

	private String firstName = null;

	@SecondaryKey(relate = Relationship.ONE_TO_ONE)
	private String lastName = null;

	// Those secondary indexes also act as a constraint: references to the parents
	// are allowed only if their ID already exist in the database.
	@SecondaryKey(relate = Relationship.ONE_TO_ONE, relatedEntity = Individual.class, onRelatedEntityDelete = DeleteAction.NULLIFY)
	private Long fatherId = null;

	@SecondaryKey(relate = Relationship.ONE_TO_ONE, relatedEntity = Individual.class, onRelatedEntityDelete = DeleteAction.NULLIFY)
	private Long motherId = null;

	private int gender = 0;

	public Individual() {

	}

	public Individual(String firstName, String lastName, int gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getFatherId() {
		return fatherId;
	}

	public void setFatherId(long fatherId) {
		this.fatherId = fatherId;
	}

	public long getMotherId() {
		return motherId;
	}

	public void setMotherId(long motherId) {
		this.motherId = motherId;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getGender() {
		return gender;
	}

	@Override
	public int hashCode() {
		return 31 + (int) (id ^ (id >>> 32));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (!(obj instanceof Individual))
			return false;
		
		Individual other = (Individual) obj;
		if (id != other.id)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getLastName();
	}
}
