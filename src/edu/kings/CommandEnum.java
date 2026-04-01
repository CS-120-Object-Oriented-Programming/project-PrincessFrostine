package edu.kings;

public enum CommandEnum {
	LOOK("look"),
	HELP("help"),
	STATUS("status"),
	BACK("back"),
	QUIT("quit"),
	GO("go");
	
	
	private final String command;
	private CommandEnum(String newCommand) {
		command= newCommand;
	}
	public String getCommand() {
		return command; 
	}

}

	