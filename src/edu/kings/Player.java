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
    private Room room;
   
	public Player(Room room) {
		this.room = room;	
	}
	
	public Room getRoom() {
		return (room);
		
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
}
