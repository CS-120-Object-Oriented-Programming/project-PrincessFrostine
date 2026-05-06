package edu.kings;
import java.util.ArrayList;

public class Container extends Item{
	/** This initializes an array that holds all of the items in a container. */
	private ArrayList<Item> containerInventory = new ArrayList<>();
	
	
	public Container(String newItem, int newScore, int newWeight, String newDescription, ArrayList<Item> newList) {
		super(newItem, newScore, newWeight, newDescription);
		containerInventory = newList;
	}
	
	public ArrayList<Item> getContainerInventory() {
		return containerInventory;
	}
	
	
	public void addItem(Item item) {
		containerInventory.add(item);
	}
	
	public void removeItem(String itemName) {
		if (containerInventory == null) {
			Writer.println("There is nothing in the container. ");
		} else {
			for(int index = 0; index < containerInventory.size(); index++) {
				if(containerInventory.get(index).getItem().equals(itemName)) {
					containerInventory.remove(index);
				} else {
					Writer.println("That item is not in here. ");
				}
			}
		}
	}
	
	public String toString() {
		String retVal = 
		getItem() + ": " + getDescription() + "\nThe " + getItem() + " has: " + getContainerInventory();
		return retVal;
	}

}
