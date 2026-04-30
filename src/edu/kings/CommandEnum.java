package edu.kings;

public enum CommandEnum {
	LOOK ("look"),
	HELP ("help"),
	STATUS ("status"),
	BACK ("back"),
	QUIT ("quit"),
	EXAMINE ("examine"),
	DROP ("drop"),
	INVENTORY ("inventory"),
	TAKE ("take"),
	LOCK ("lock"),
	UNLOCK ("unlock"),
	UNPACK ("unpack"),
	PACK ("pack"),
	TALK ("talk"),
	KICK ("kick"),
	GO ("go");
	
	
	private final String command;
	private CommandEnum(String newCommand) {
		command= newCommand;
	}
	public String getCommand() {
		return command; 
	}

}

	