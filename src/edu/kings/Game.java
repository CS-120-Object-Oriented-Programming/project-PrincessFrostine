package edu.kings;
import java.util.ArrayList;
/**
 * This class is the main class of the "Campus of Kings" application.
 * "Campus of Kings" is a very simple, text based adventure game. Users can walk
 * around some scenery. That's all. It should really be extended to make it more
 * interesting!
 *
 * This game class creates and initializes all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 *
 * @author Maria Jump
 * @version 2015.02.01
 *
 * Used with permission from Dr. Maria Jump at Northeastern University
 */
// Collei.getRoom  Collei.setRoom
public class Game {
	/** The world where the game takes place. */
	private World world;
	/** The room the player character is currently in. */
		Player collei;
	private int score;
	private int turns;
	private ArrayList<Item> items;
	/**
	 * Create the game and initialize its internal map.
	 */
	public Game() {
		world = new World();
		// set the starting room
		collei = new Player(world.getRoom("outside"), new ArrayList<>());
	}
	
	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();

		// Enter the main game loop. Here we repeatedly read commands and
		// execute them until the game is over.
		boolean wantToQuit = false;
		while (!wantToQuit) {
			Command command = Reader.getCommand();
			wantToQuit = processCommand(command);
			// other stuff that needs to happen every turn can be added here.
		}
		printGoodbye();
	}

	///////////////////////////////////////////////////////////////////////////
	// Helper methods for processing the commands

	/**
	 * Given a command, process (that is: execute) the command.
	 *
	 * @param command
	 *            The command to be processed.
	 * @return true If the command ends the game, false otherwise.
	 */
	private boolean processCommand(Command command) {
		boolean wantToQuit = false;
		
		if (command.isUnknown()) {
			Writer.println("I don't know what you mean...");
		} else {

			CommandEnum commandWord = command.getCommandWord();
			if (commandWord == CommandEnum.HELP) {
				printHelp();
			} else if (commandWord == CommandEnum.GO) {
				goRoom(command);
			} else if (commandWord == CommandEnum.QUIT) {
				wantToQuit = quit(command);
			} else if (commandWord == CommandEnum.LOOK) {
				lookAround();
			} else if (commandWord == CommandEnum.BACK) {
				goBack();
			} else if (commandWord == CommandEnum.STATUS) {
				getStatus();
			} else if (commandWord == CommandEnum.EXAMINE){
				examineItem(command);
			} else if (commandWord == CommandEnum.INVENTORY) {
				myInventory();
			} else if (commandWord == CommandEnum.TAKE) {
				takeItem(command);
			} else if(commandWord == CommandEnum.DROP) {
				dropItem(command);
			} else if (commandWord == CommandEnum.LOCK) {
				lockDoor(command);
			} else if (commandWord == CommandEnum.UNLOCK) {
				unlockDoor(command);
			} else if (commandWord == CommandEnum.UNPACK) {
				unPack(command);
			} else if (commandWord == CommandEnum.PACK) {
				pack(command);
			}
			
			else {
				Writer.println(commandWord + " is not implemented yet!");
			}
		}
		return wantToQuit;
	}

	///////////////////////////////////////////////////////////////////////////
	// Helper methods for implementing all of the commands.
	// It helps if you organize these in alphabetical order.

	
	
	/** Dropping an item and adding it to the room. */
	private void dropItem(Command command) {
		Boolean val = false;
		if (!command.hasSecondWord()) {
			Writer.println("Drop what? ");
		} else {
			String theItem = command.getRestOfLine();
			for (int i = 0; i < collei.getInventory().size(); i++ ) {
				if (collei.getInventory().get(i).getItem().equals(theItem)) {
					collei.getCurrentRoom().getItems().add(collei.getInventory().get(i));
					Writer.println("you dropped " + collei.getInventory().get(i) );
					collei.getInventory().remove(i);
					val = true;
				} 
			} if (val == false) {
				Writer.println("You do not have this item. ");
			}
		}
	}

	
	
	/** How to examine items. */	
	private void examineItem(Command command) {
		Boolean val = false;
		if (!command.hasSecondWord()) {
			Writer.println("Examine what? ");
		} else {
			String theItem = command.getRestOfLine();
			for (int i = 0; i < collei.getCurrentRoom().getItems().size(); i++ ) {
				if (collei.getCurrentRoom().getItems().get(i).getItem().equals(theItem)) {
					Writer.println(collei.getCurrentRoom().getItems().get(i).toString());
					val = true;
				}
			}
			for (int index = 0; index < collei.getInventory().size(); index ++) {
					if (collei.getInventory().get(index).getItem().equals(theItem)) {
						Writer.println(collei.getInventory().get(index).getDescription());
						val = true;
				}
			} if (val == false) {
				Writer.println("There is no such item. ");
			}
		}
	}
	
	

	/** Prints the current score of the game. */
	private void getStatus() {
		Writer.println("Score: " + score + " Turns: " + turns + " ");
		printLocationInformation();
	}
	
	
	
	/**
	 * makes the current room the previous room so you can go back.
	 */
		private void goBack() {
			if (collei.getPreviousRoom() == null) {
				Writer.println("You cannot go back. ");
			} else {
				collei.setCurrentRoom(collei.getPreviousRoom()); 
				turns++;
				Writer.println(collei.getCurrentRoom().toString());
			}
		}
	
		
		
	/**
	 * Try to go to one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 *
	 * @param command
	 *            The command to be processed.
	 */
	private void goRoom(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			Writer.println("Go where?");
		} else {
			String direction = command.getRestOfLine();
			boolean val = false;
			// Try to leave current.
			Door doorway = null;
			if (direction.equals("north")) {
				if (collei.getCurrentRoom().getExit(direction) == null) {
				
				} else if (collei.getCurrentRoom().getExit(direction).isLocked() == false) {
					doorway = collei.getCurrentRoom().getExit(direction);
					val = true;
				} else if (collei.getCurrentRoom().getExit(direction).isLocked() == true) {
					Writer.println("The door is locked. ");
					val = true;
				}
			}
			if (direction.equals("east")) {
				if (collei.getCurrentRoom().getExit(direction) == null) {
					
				} else if (collei.getCurrentRoom().getExit(direction).isLocked() == false) {
					doorway = collei.getCurrentRoom().getExit(direction);
					val = true;
				} else {
					Writer.println("The door is locked. ");
					val = true;
				}
			}
			if (direction.equals("south")) {
				if (collei.getCurrentRoom().getExit(direction) == null) {
					
				} else if (collei.getCurrentRoom().getExit(direction).isLocked() == false) {
					doorway = collei.getCurrentRoom().getExit(direction);
					val = true;
				} else {
					Writer.println("The door is locked. ");
					val = true;
				}
				}
			if (direction.equals("west")) {
				if (collei.getCurrentRoom().getExit(direction) == null) {
				
				} else if (collei.getCurrentRoom().getExit(direction).isLocked() == false) {
					doorway = collei.getCurrentRoom().getExit(direction);
					val = true;
				} else {
					Writer.println("The door is locked. ");
					val = true;
				}
			}
			if (doorway == null) {
				if (val == false) {
					Writer.println("There is no door. ");
				}
			} else {
				Room newRoom = doorway.getDestination();
				collei.setPreviousRoom(collei.getCurrentRoom());
				collei.setCurrentRoom(newRoom);
				printLocationInformation();
				turns++;
			}
			
		}
	}
	
	
	
	private void lockDoor(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			Writer.println("Lock What?");
		} else {
			String lockDirection = command.getRestOfLine();
			Boolean val = false;
			if (collei.getCurrentRoom().getExit(lockDirection) == null) {
				Writer.println("There is no door");
			} else if (collei.getCurrentRoom().getExit(lockDirection).isLocked() == true) {
				Writer.println("The door is already locked. ");
			} else if (collei.getCurrentRoom().getExit(lockDirection).isLocked() == false && collei.getCurrentRoom().getExit(lockDirection).getKey() == null) {
				Writer.println("This door can not be locked. ");
			} else if (collei.getCurrentRoom().getExit(lockDirection).isLocked() == false && collei.getCurrentRoom().getExit(lockDirection).getKey() != null) {
				Writer.println("Which key? ");
				String theAnswer = Reader.getResponse();
				for (int i = 0; i < collei.getInventory().size(); i++) {
					if(collei.getInventory().get(i).getItem().equals(theAnswer) && collei.getCurrentRoom().getExit(lockDirection).getKey().equals(theAnswer)) {
						collei.getCurrentRoom().getExit(lockDirection).setLocked(true);
						Writer.println("The door has been locked. ");
						val = true;
					} else if(collei.getInventory().get(i).getItem().equals(theAnswer) && collei.getCurrentRoom().getExit(lockDirection).getKey() != theAnswer) {
						Writer.println("That is the wrong key. ");
						val = true;
					} 
				}
				if (val == false) {
					Writer.println("You do not have that key. ");
				}
			}
		}
	}
	
	
	
	/**
	 * Prints out the location information.
	 */
	private void lookAround() {
		Writer.println(collei.getCurrentRoom().toString());
	}


	
	/** Prints out what is in the inventory. */
	private void myInventory(){
		 Writer.println(collei.getInventory());
	}
	
	
	
	private void pack(Command command) {
		if(!command.hasSecondWord()) {
			Writer.println("Pack what? ");
		} else {
			String theItem = command.getRestOfLine();
			boolean val = true;
			boolean isInRoom = false;
			boolean isInInventory = false;
			
			for(int i = 0; i < collei.getCurrentRoom().getItems().size(); i++) {
				if(collei.getCurrentRoom().getItems().get(i).getItem().equals(theItem)) {
					Writer.println("What would you like to pack it in? ");
					String containerItem = Reader.getResponse();
					isInRoom = true;
					for(int index = 0; index < collei.getCurrentRoom().getItems().size(); index++) {
						val = false;
						if(collei.getCurrentRoom().getItems().get(index) instanceof Container && collei.getCurrentRoom().getItems().get(index).getItem().equals(containerItem)) {
							((Container)collei.getCurrentRoom().getItems().get(index)).addItem(collei.getCurrentRoom().getItems().get(i));
							collei.getCurrentRoom().getItems().remove(collei.getCurrentRoom().getItems().get(i));
							Writer.println("The item has been packed into the container. ");
							val = true;
						} 
					}
				}
			} for(int anotherI = 0; anotherI < collei.getInventory().size(); anotherI++) {
				if(collei.getInventory().get(anotherI).getItem().equals(theItem)) {
					Writer.println("What would you like to pack it in? ");
					String newContainerItem = Reader.getResponse();
					isInInventory = true;
					for(int anotherIndex = 0; anotherIndex < collei.getCurrentRoom().getItems().size(); anotherIndex++) {
						val = false;
						if(collei.getCurrentRoom().getItems().get(anotherIndex) instanceof Container && collei.getCurrentRoom().getItems().get(anotherIndex).getItem().equals(newContainerItem)) {
							((Container)collei.getCurrentRoom().getItems().get(anotherIndex)).addItem(collei.getInventory().get(anotherI));
							collei.getCurrentRoom().getItems().remove(collei.getInventory().get(anotherI));
							Writer.println("The item has been packed into the container. ");
							val = true;
						}
					}
				}		
			} if(val == false) {
				Writer.println("That item is not a container. ");
			} if (isInRoom == false && isInInventory == false) {
				Writer.println("That item is not available. ");
			} 
		}
	}
	
	
	
	/**
	 * Print out the closing message for the player.
	 */
	private void printGoodbye() {
		Writer.println("I hope you weren't too bored here on the Campus of Kings!");
		Writer.println("You have earned " + score + " points in " + turns + " turns");
		Writer.println("Thank you for playing.  Good bye.");
	}

	
	
	/**
	 * Print out some help information. Here we print some stupid, cryptic
	 * message and a list of the command words.
	 */
	private void printHelp() {
		Writer.println("You are lost. You are alone. You wander");
		Writer.println("around at the university.");
		Writer.println();
		Writer.println("Your command words are:");
		for (CommandEnum commandWord: CommandEnum.values()) {
			Writer.print(commandWord.getCommand() + " ");
		}
		Writer.println();
	}

	
	
	/**
	* Prints out the current location and exits.
	*/
	private void printLocationInformation() {
		Writer.println(collei.getCurrentRoom().toString());
	}
	
	
	
	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		Writer.println();
		Writer.println("Welcome to the Campus of Kings!");
		Writer.println("Campus of Kings is a new, incredibly boring adventure game.");
		Writer.println("Type 'help' if you need help.");
		Writer.println();
		printLocationInformation();
	}
	
	
	
	/** Taking an item from the world and adding it to the players inventory. */
	private void takeItem(Command command) {
		Boolean val = false;
		if (!command.hasSecondWord()) {
			Writer.println("Take what? ");
		} else {
			String theItem = command.getRestOfLine();
			for (int i = 0; i < collei.getCurrentRoom().getItems().size(); i++ ) {
				if (collei.getCurrentRoom().getItems().get(i).getItem().equals(theItem)) {
					collei.setInventory(collei.getCurrentRoom().getItems().get(i));
					collei.getCurrentRoom().getItems().remove(i);
					val = true;
				} 
			} if (val == false) {
				Writer.println("There is no such item. ");
			}
		}
	}

	
	
	/**
	 * "Quit" was entered. Check the rest of the command to see whether we
	 * really quit the game.
	 *
	 * @param command
	 *            The command to be processed.
	 * @return true, if this command quits the game, false otherwise.
	 */
	private boolean quit(Command command) {
		boolean wantToQuit = true;
		if (command.hasSecondWord()) {
			Writer.println("Quit what?");
			wantToQuit = false;
		}
		return wantToQuit;
	}



	private void unlockDoor(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			Writer.println("Unlock What?");
		} else {
		String lockDirection = command.getRestOfLine();
		Boolean val = false;
		if (collei.getCurrentRoom().getExit(lockDirection) == null) {
			Writer.println("There is no door");
		} else if (collei.getCurrentRoom().getExit(lockDirection).isLocked() == false) {
			Writer.println("The door is not locked. ");
		} else if (collei.getCurrentRoom().getExit(lockDirection).isLocked() == true) {
			Writer.println("Which key? ");
			String theAnswer = Reader.getResponse();
			for (int i = 0; i < collei.getInventory().size(); i++) {
				if(collei.getInventory().get(i).getItem().equals(theAnswer) && collei.getCurrentRoom().getExit(lockDirection).getKey().equals(theAnswer)) {
					collei.getCurrentRoom().getExit(lockDirection).setLocked(false);
					Writer.println("The door has been unlocked. ");
					val = true;
				} else if(collei.getInventory().get(i).getItem().equals(theAnswer) && collei.getCurrentRoom().getExit(lockDirection).getKey() != theAnswer) {
					Writer.println("The key does not fit. ");
					val = true;
				} 
			}
			if (val == false) {
				Writer.println("You do not have that key. ");
			}
			}
		}
	}

	
	
	/** The command to get an item from a container. */
	public void unPack(Command command) {
		if (!command.hasSecondWord()) {
			Writer.println("Unpack what? ");
		} else {
			String container = command.getRestOfLine();
			boolean val = false;
			for (int i = 0; i < collei.getCurrentRoom().getItems().size(); i++ ) {
				if (collei.getCurrentRoom().getItems().get(i).getItem().equals(container)) {
					if(collei.getCurrentRoom().getItems().get(i) instanceof Container == true) {
						Writer.println("What item would you like to unpack?");
						String theAnswer = Reader.getResponse();
						for (int index = 0; index < ((Container)collei.getCurrentRoom().getItems().get(i)).getContainerInventory().size(); index++) {
							if (((Container)collei.getCurrentRoom().getItems().get(i)).getContainerInventory().get(index).getItem().equals(theAnswer)) {
								collei.setInventory(((Container)collei.getCurrentRoom().getItems().get(i)).getContainerInventory().get(index));
								((Container)collei.getCurrentRoom().getItems().get(i)).getContainerInventory().remove(index);
								Writer.println("The item has been unpacked. ");
								val = true;
							} else if(val == false){
								Writer.println("There is no such item in this container. ");
								val = true;
							}
						}
					} else {
						Writer.println("That item is not a container. ");
						val = true;
					}
				}
			} if (val == false) {
				Writer.println("That item is not in this room. ");
			}
			
		}
	}
	
	
	
	
}


