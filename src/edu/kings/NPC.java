package edu.kings;

public class NPC extends Item{
	/** Saves what the player will say when talking to this npc. */
	private String playerR;
	/** Saves what the npc's response to the player will be. */
	private String response;
	/** Saves a boolean value that says if an npc can be talked to or not. */
	private boolean canTalkTo;
	
	public NPC (String newName, int newWeight, int newScore, String newDescription, String newPlayerR, String newResponse, boolean newCanTalk) {
		super(newName, newWeight, newScore, newDescription);
		playerR = newPlayerR;
		response = newResponse;
		canTalkTo = newCanTalk;
	}
	
	public String getResponse() {
		return response;
	}
	
	public String getPlayerR() {
		return playerR;
	}
	
	public boolean getCanTalk() {
		return canTalkTo;
	}
	
	public void setCanTalk(boolean newCanTalk) {
		canTalkTo = newCanTalk;
	}
}
