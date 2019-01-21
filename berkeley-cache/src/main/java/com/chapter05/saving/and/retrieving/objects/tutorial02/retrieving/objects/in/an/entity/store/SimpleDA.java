package com.chapter05.saving.and.retrieving.objects.tutorial02.retrieving.objects.in.an.entity.store;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.PrimaryIndex;
import com.sleepycat.persist.SecondaryIndex;


public class SimpleDA {
	
	// Index Accessors
	PrimaryIndex<String, SimpleEntityClass> pIdx;
	SecondaryIndex<String, String, SimpleEntityClass> sIdx;
	
	
	// Open the indices
	public SimpleDA(EntityStore store) throws DatabaseException {
		
		// Primary key for SimpleEntityClass classes
		pIdx = store.getPrimaryIndex(String.class, SimpleEntityClass.class);
		
		// Secondary key for SimpleEntityClass classes
		// Last field in the getSecondaryIndex() method must be
		// the name of a class member; in this case, an
		// SimpleEntityClass.class data member.
		sIdx = store.getSecondaryIndex(pIdx, String.class, "sKey");
	}


}