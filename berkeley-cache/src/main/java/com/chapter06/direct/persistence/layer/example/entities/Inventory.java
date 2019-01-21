package com.chapter06.direct.persistence.layer.example.entities;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

@Entity
public class Inventory {

	//stock keeping unit (SKU) 
	@PrimaryKey
	private String sku;
	
	//In our data set, the product SKU is required to be unique, so we use that as the primary key
	//The product name, however, is not a unique value so we set this up as a secondary key
	@SecondaryKey(relate=Relationship.MANY_TO_ONE)
	private String itemName;
	private String category;
	private String vendor;
	private int vendorInventory;
	private float vendorPrice;
	
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sKU) {
		sku = sKU;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public int getVendorInventory() {
		return vendorInventory;
	}
	public void setVendorInventory(int vendorInventory) {
		this.vendorInventory = vendorInventory;
	}
	public float getVendorPrice() {
		return vendorPrice;
	}
	public void setVendorPrice(float vendorPrice) {
		this.vendorPrice = vendorPrice;
	}
	
	
	
}
