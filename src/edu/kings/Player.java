/** Author Athena.
 * This should keep track of the player and the room that
 * they are in.
 */
package edu.kings;

/**
 * 
 */
public class Player {
    Room room;
   
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
