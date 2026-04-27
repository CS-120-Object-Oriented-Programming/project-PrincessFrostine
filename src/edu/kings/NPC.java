package edu.kings;

public class NPC extends Item{
	private String playerR;
	private String response;
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
