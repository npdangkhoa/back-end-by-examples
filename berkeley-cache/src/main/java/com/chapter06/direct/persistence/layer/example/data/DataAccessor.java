package com.chapter06.direct.persistence.layer.example.data;

import com.chapter06.direct.persistence.layer.example.entities.Inventory;
import com.chapter06.direct.persistence.layer.example.entities.Vendor;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.PrimaryIndex;
import com.sleepycat.persist.SecondaryIndex;

public class DataAccessor {
	
	public PrimaryIndex<String, Inventory> inventoryBySkuPrimaryKey;
	public PrimaryIndex<String, Vendor> vendorByNamePrimaryKey;

	public SecondaryIndex<String, String, Inventory> inventoryByNameSecondaryKey;
	// Open the indices
	
	
	
	// open the indicate
	public DataAccessor(EntityStore store) throws DatabaseException {
		
		// Primary key for Inventory classes
		inventoryBySkuPrimaryKey = store.getPrimaryIndex(String.class, Inventory.class);
		
		// Secondary key for Inventory classes
		// Last field in the getSecondaryIndex() method must be
		// the name of a class member; in this case, an Inventory.class
		// data member.
		inventoryByNameSecondaryKey = store.getSecondaryIndex(inventoryBySkuPrimaryKey, String.class, "itemName");
		
		// Primary key for Vendor class
		vendorByNamePrimaryKey = store.getPrimaryIndex(String.class, Vendor.class);
	}
}
