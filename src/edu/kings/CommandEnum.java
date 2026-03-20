package edu.kings;

public enum CommandEnum {
	LOOK("look"),
	HELP("help"),
	QUIT("quit"),
	GO("go");
	
	private final String command;
	private CommandEnum(String newCommand) {
		command= newCommand;
	}
	public String getCommand() {
		return command; 
	}
	public String toString() {
		String retVal = "You're command is " + getCommand();
		return retVal;
	}
}

	