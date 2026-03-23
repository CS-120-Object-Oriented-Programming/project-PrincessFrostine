/** Author Athena.
 * This should keep track of the player and the room that
 * they are in.
 */
package edu.kings;
/**
 * This is a brand new class.
 */
public class Player {
	// This means that the class Room has an object named room.
    private Room currentRoom;
    private Room previousRoom;
	public Player(Room room) {
		this.currentRoom = room;	
	}
	
	public Room getCurrentRoom() {
		return (currentRoom);
		
	}
	
	public Room getPreviousRoom() {
		return (previousRoom);
	}
	
	public void setCurrentRoom(Room room) {
		this.currentRoom = room;
	}
	
	public void setPreviousRoom(Room room) {
		this.previousRoom = room;
	}
	
}
