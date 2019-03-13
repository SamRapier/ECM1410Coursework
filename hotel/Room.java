package hotel;

public class Room {
	private int roomNumber;
	private RoomType roomType;
	private double price;
	private int capacity;
	private String facilities;

	/**
	 * Constructor for the room class, takes the variables and initialises them.
	 * 
	 * @param roomNumber The roomNumber for the room
	 * @param roomType   The roomType of the room
	 * @param price      The price of the room
	 * @param capacity   The number of people that can fit in the room
	 * @param facilities The facilities provided for the room
	 */
	public Room(int roomNumber, RoomType roomType, double price, int capacity, String facilities) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.price = price;
		this.capacity = capacity;
		this.facilities = facilities;
	}

	/**
	 * Constructor for the room class, takes the variables and initialises them.
	 * This constructor takes string variables and converts them all to the correct
	 * data type
	 * 
	 * @param roomNumber The roomNumber for the room
	 * @param roomType   The roomType of the room
	 * @param price      The price of the room
	 * @param capacity   The number of people that can fit in the room
	 * @param facilities The facilities provided for the room
	 */
	public Room(String roomNumber, String roomType, String price, String capacity, String facilities) {
		this.roomNumber = Integer.parseInt(roomNumber);

		// This switch case ensures that the correct roomType is selected depending on
		// what the string type is
		switch (roomType.toUpperCase()) {
		case "DOUBLE":
			this.roomType = RoomType.DOUBLE;
			break;
		case "SINGLE":
			this.roomType = RoomType.SINGLE;
			break;
		case "FAMILY":
			this.roomType = RoomType.FAMILY;
			break;
		case "TWIN":
			this.roomType = RoomType.TWIN;
			break;
		default:
			assert false;
		}
		this.price = Double.parseDouble(price);
		this.capacity = Integer.parseInt(capacity);
		this.facilities = facilities;
	}

	/**
	 * Getter method for the room number for the room
	 * 
	 * @return roomNumber of the room
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Getter method for the room type for the room
	 * 
	 * @return roomType of the room
	 */
	public RoomType getRoomType() {
		return roomType;
	}

	/**
	 * Getter method for the price of the room
	 * 
	 * @return price of the room
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the string representation of the room object
	 */
	public String toString() {
		return roomNumber + "," + roomType + "," + price + "," + capacity + "," + facilities;
	}
}