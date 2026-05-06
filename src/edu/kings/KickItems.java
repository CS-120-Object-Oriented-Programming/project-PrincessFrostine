package edu.kings;

public class KickItems extends Item{
	/** Holds a boolean saying if the item can be kicked or not. */
	private boolean canKick;
	
	public KickItems(String newName, int newScore, int newWeight, String newDescription, boolean newCanKick) {
		super(newName, newScore, newWeight, newDescription);
		canKick = newCanKick;
	}
	
	public boolean getCanKick() {
		return canKick;
	}
	
	public void setCanKick(boolean newCanKick) {
		canKick = newCanKick;
	}
}
