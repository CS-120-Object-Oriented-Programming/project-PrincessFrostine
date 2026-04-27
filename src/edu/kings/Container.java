package edu.kings;
import java.util.ArrayList;

public class Container extends Item{
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
			
		} else {
			for(int i = 0; i < containerInventory.size(); i++) {
				if(containerInventory.get(i).getItem().equals(itemName)) {
					containerInventory.remove(i);
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
