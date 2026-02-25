/** Author Athena.
 * This should keep track of the player and the room that
 * they are in.
 */
package edu.kings;

/**
 * 
 */
public class Player {
    String room = "Garden";
	public Player(String room) {
		this.room = room;	
	}
	
	public String getRoom() {
		return (room);
		
	}
	
	public void setRoom(String room) {
		this.room = room;
	}
	
}
