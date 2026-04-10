/** Author Athena.
 * This should keep track of the player and the room that
 * they are in.
 */
package edu.kings;
import java.util.ArrayList;
/**
 * This is a brand new class.
 */
public class Player {
	// This means that the class Room has an object named room.
    private Room currentRoom;
    private Room previousRoom;
    private ArrayList<Item> inventory;
    
	public Player(Room room, ArrayList<Item> inventory) {
		this.currentRoom = room;	
		this.inventory = inventory;
	}
	//Beautiful getter for my current room
	public Room getCurrentRoom() {
		return (currentRoom);
	}
	//the same but for my previous room
	public Room getPreviousRoom() {
		return (previousRoom);
	}
	//the same but for my inventory
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	//the same for any single item in the inventory
	public Item getItem(String theItem) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getItem() == theItem) {
				return inventory.get(i);
			}
		} 
		return null;
	}
	
	//Beautiful setter for my current room
	public void setCurrentRoom(Room room) {
		this.currentRoom = room;
	}
	//the same but for my previous room
	public void setPreviousRoom(Room room) {
		this.previousRoom = room;
	}
	// the same but for my inventory
	public String setInventory(Item newItem) {
		if (newItem.getWeight() == 0) {
			inventory.add(newItem);
			Writer.println("Succsessfuly picked up " + newItem.getItem() + ". ");
			return newItem.getItem();
		} else {
			Writer.println("Item is too heavy. ");
			return "Item is too heavy. ";
		}
			
	}
}
