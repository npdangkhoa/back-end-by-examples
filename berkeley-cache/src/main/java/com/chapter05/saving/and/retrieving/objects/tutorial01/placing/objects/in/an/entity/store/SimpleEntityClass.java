package com.chapter05.saving.and.retrieving.objects.tutorial01.placing.objects.in.an.entity.store;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

/**
 * For clarity's sake, this entity class is a simple a class as we can write. It contains only two data
 * members, both of which are set and retrieved by simple setter and getter methods. Beyond
 * that, by design this class does not do anything or particular interest.
 * @author knguyen97
 *
 */
@Entity
public class SimpleEntityClass {
	@PrimaryKey
	private String pKey;
	
	// Secondary key is the sKey
	@SecondaryKey(relate = Relationship.MANY_TO_ONE)
	private String sKey;

	public String getPKey() {
		return pKey;
	}

	public void setPKey(String pKey) {
		this.pKey = pKey;
	}

	public String getSKey() {
		return sKey;
	}

	public void setSKey(String sKey) {
		this.sKey = sKey;
	}
	
	
}
