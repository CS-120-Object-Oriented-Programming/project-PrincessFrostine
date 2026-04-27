package edu.kings;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * This class represents the entire world that makes up the "Campus of Kings"
 * application. "Campus of Kings" is a very simple, text based adventure game.
 * Users can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 *
 * This world class creates the world where the game takes place.
 *
 * @author Maria Jump
 * @version 2015.02.01
 *
 * Used with permission from Dr. Maria Jump at Northeastern University
 */
public class World {
	/** The rooms in the world. */
	private HashMap<String, Room> rooms;
	private ArrayList<Item> A4Items = new ArrayList<>();
	/**
	 * Constructor for the world.
	 */
	public World() {
		rooms = new HashMap<String, Room>();
		createRooms();
	}

	/**
	 * This method takes care of creating all of the aspects of the world for
	 * the "Campus of Kings" application.
	 *
	 * @param name
	 *            The provided name of the room.
	 * @return The room associated with the provided name
	 */
	public Room getRoom(String name) {
		return rooms.get(name.toLowerCase());
	}

	/////////////////////////////////////////////////////////////////////////////////////
	// Start of private helper methods

	/**
	 * Helper method for recreating a Room. Ensure that the room is created and
	 * installed in to the collection of Rooms
	 *
	 * @param theRoom
	 *            The room to add to the world.
	 */
	private void addRoom(Room theRoom) {
		rooms.put(theRoom.getName().toLowerCase(), theRoom);
	}
	
	private Item createItem(Item newItem)  {
		return newItem;
	}
	
	private Container createContainer(Container newContainer)  {
		return newContainer;
	}
	
	private NPC createNPC(NPC newNPC) {
		return newNPC;
	}
	
	private KickItems createKickItem(KickItems newKickItem) {
		return newKickItem;
	}
	/**
	* Helper method for creating doors between rooms.
	*
	* @param from The room where the door originates.
	* @param direction The direction of the door in the from room.
	* @param to The room where the door goes.
	*/
	private void createDoor(Room from, String direction, String theKey, Room to) {
		Door aDoor = new Door(to, theKey);
		if (theKey != null) {
			aDoor.setLocked(true);
		}
		rooms.get(from.getName().toLowerCase()).allDoors.put(direction, aDoor);
	}

	/**
	 * This method creates all of the individual places in this world and all
	 * the doors connecting them.
	 */
	private void createRooms() {
		// Creating all the rooms.
		Room A1 = new Room ("A1", "It is a small clearing between the next house and the gate to the garden. ");
		Room A2 = new Room ("A2", "It is another small clearing alongside the house. ");
		Room A3 = new Room ("A3", "It is a small clearing between the houses. ");
		Room A4 = new Room ("A4", "Another small clearing that is surrounded by grass. ");
		Room A5 = new Room ("A5", "You see the mail box of the house. You remember seeing the human herer earlier. Maybe the gate key is in here. ");
		
		Room B1 = new Room ("B1", "The Garden.");
		Room B2 = new Room ("B2", "The house. It is a brick house with grey shingles on the roof. It looks like the humans are home. ");
		Room B3 = new Room ("B3", "It is an open grassy plain with paths to the north, east, and west. You see a barn to the east. ");
		Room B4 = new Room ("B4", "You see a box key on the ground in the middle of the clearing. ");
		Room B5 = new Room ("B5", "You enter onto a concrete sidewalk. You can see the human’s mailbox to the west in the distance. ");
		
		Room C1 = new Room ("C1", "It is a grassy clearing. You can see the garden westward, but you cannot get into it. ");
		Room C2 = new Room ("C2", "There are two mice arguing about who gets the trash can. Maybe you can jump up onto it to see the key to the Garden? You also see fox tracts heading northeast.");
		Room C3 = new Room ("C3", "A grassy clearing. You can see fox tracts heading north. You can see the door to the shed towards the east. ");
		Room C4 = new Room ("C4", "A grassy clearing. ");
		Room C5 = new Room ("C5", "You are now on the side walk by the house. You can see the human’s mailbox towards the west in the distance. ");
		
		Room D1 = new Room ("D1", "The fox! ");
		Room D2 = new Room ("D2", "A small broom closet in the barn. ");
		Room D3 = new Room ("D3", "The inside of the barn. It is old and dusty. You can see three doors.");
		Room D4 = new Room ("D4", "A small closet in the barn. It's got some straw and rotten carrots strewed about. ");
		Room D5 = new Room ("D5", " You can see an abandoned rabbit burrow to the east. You may be able to dig into the barn this way. ");
		
		Room E2_1 = new Room ("E2.1", "You see a human statue.  It is a small statue of a man with a flowy beard and crinkled eyes. There is a plaque on it that reads “King Kandy”.  ");
		Room E3_1 = new Room ("E3.1", "You see a closed enclosure. You see four rabbits stuck in the enclosure. You cannot open the enclosure from here. Maybe you can find another way in. ");
		Room E2_2 = new Room ("E2.2", "You can see a fancy door to the west. ");
		Room E3_2 = new Room ("E3.2", "You are now in the encolsure with the four rabbits. You should tell them that they can escape now. ");
		Room E4 = new Room ("E4", "A small burrow. You can see a new tunnel that was started. ");
		
		Room trashcan = new Room ("Trashcan", "The top of the Trashcan. ");
		Room mailbox = new Room ("Mailbox", "You are in the human's mailbox. ");
		
		// Adding all the rooms to the world.
		this.addRoom(A1);
		this.addRoom(A2);
		this.addRoom(A3);
		this.addRoom(A4);
		this.addRoom(A5);
		
		this.addRoom(B1);
		this.addRoom(B2);
		this.addRoom(B3);
		this.addRoom(B4);
		this.addRoom(B5);
		
		this.addRoom(C1);
		this.addRoom(C2);
		this.addRoom(C3);
		this.addRoom(C4);
		this.addRoom(C5);
		
		this.addRoom(D1);
		this.addRoom(D2);
		this.addRoom(D3);
		this.addRoom(D4);
		this.addRoom(D5);
		
		this.addRoom(E2_1);
		this.addRoom(E3_1);
		this.addRoom(E2_2);
		this.addRoom(E3_2);
		this.addRoom(E4);
		
		this.addRoom(trashcan);
		this.addRoom(mailbox);

		// Creating all the doors between the rooms.
		
		createDoor(A1, "south", null, A2);
		createDoor(A2, "north", null, A1);
		
		createDoor(A2, "south", null, A3);
		createDoor(A3, "north", null, A2);
		
		createDoor(A3, "south", null, A4);
		createDoor(A4, "north", null, A3);
		
		createDoor(A1, "east", "gate key", B1);
		
		createDoor(B2, "south", null, B3);
		createDoor(B3, "north", null, B2);
		
		createDoor(B3, "west", null, A3);
		createDoor(A3, "east", null, B3);
		
		createDoor(B5, "west", null, A5);
		createDoor(A5, "east", null, B5);
		
		createDoor(C1, "south", null, C2);
		createDoor(C2, "north", null, C1);
		
		createDoor(C2, "south", null, C3);
		createDoor(C3, "north", null, C2);
		
		createDoor(C3, "west", null, B3);
		createDoor(B3, "east", null, C3);
		
		createDoor(C3, "south", null, C4);
		createDoor(C4, "north", null, C3);
		
		createDoor(C4, "west", null, B4);
		createDoor(B4, "east", null, C4);
		
		createDoor(C4, "south", null, C5);
		createDoor(C5, "north", null, C4);
		
		createDoor(C5, "west", null, B5);
		createDoor(B5, "east", null, C5);
		
		createDoor(C1, "east", null, D1);
		
		createDoor(D2, "south", null, D3);
		createDoor(D3, "north", null, D2);
		
		createDoor(D3, "west", null, C3);
		createDoor(C3, "east", "shed key", D3);
		
		createDoor(D3, "south", null, D4);
		createDoor(D4, "north", null, D3);
		
		createDoor(D5, "west", null, C5);
		createDoor(C5, "east", null, D5);
		
		createDoor(E2_1, "east", null, E2_2);
		createDoor(E2_2, "west", null, E2_1);
		
		createDoor(E2_2, "south", null, E3_2);
		createDoor(E3_2, "north", null, E2_2);
		
		createDoor(E3_1, "west", null, D3);
		createDoor(D3, "east", null, E3_1);
		
		createDoor(E3_2, "east", null, E4);
		createDoor(E4, "north", null, E3_2);
		
		createDoor(E4, "south", null, D5);
		createDoor(D5, "east", null, E4);
		
		createDoor(C2, "up", null, trashcan);
		
		createDoor(mailbox, "down", null, A5);
		createDoor(A5, "up", "box key", mailbox);
		
		// weights: 0 = intractable item  1 = container  2 = NPC  3 = kick able item
		// Adding all the items into their rooms
		
		B2.addItem(createKickItem(new KickItems("front door", 5, 3, "The front door to the humans house. ", true)));
		E2_1.addItem(createKickItem(new KickItems("statue", 15, 3, "A King Kandy Statue. ", true)));
		A4Items.add(new Item("shed key", 5, 0, "The key to the Shed. "));
		A4.addItem(createContainer(new Container("chest", 0, 1, "a small chest. ", A4Items)));
		mailbox.addItem(createItem(new Item("gate key", 40, 0, "The key to the gate. ")));
		B4.addItem(createItem(new Item("box key", 15, 0, "The key to the mailbox. ")));
		C2.addItem(createNPC(new NPC("mice", 5, 2, "Two arguing mice", "What is going on? ", "Leave us alone! ", true)));
		E3_2.addItem(createNPC(new NPC("bunnies", 15, 2, "four scared bunnies", "You can escape now. ", "Thankyou! Thankyou so much! ", true)));
	}
}
