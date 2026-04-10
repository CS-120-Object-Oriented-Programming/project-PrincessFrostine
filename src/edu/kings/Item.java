package edu.kings;

public class Item {
	private String aItem;
	private int itemScore;
	private int itemWeight;
	private String itemDescription;
	
	public Item(String newItem, int newScore, int newWeight, String newDescription) {
		aItem = newItem;
		itemScore = newScore;
		itemWeight = newWeight;
		itemDescription = newDescription;
	}
	
	public String getItem() {
		return aItem;
	}
	
	public int getScore() {
		return itemScore;
	}
	
	public int getWeight() {
		return itemWeight;
	}
	
	public String getDescription() {
		return itemDescription;
	}
	
	public void setDescription(String newDescription) {
		itemDescription = newDescription;
	}
	
	
	public String toString() {
		String retVal = 
		getItem() + ": " + getDescription() ;
		return retVal;
	}
}
