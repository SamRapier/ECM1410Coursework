package hotel;

public class Room {
	private int roomNumber;
	private RoomType roomType;
	private double price;
	private int capacity;
	private String facilities;

	public Room(int roomNumber, RoomType roomType, double price, int capacity, String facilities) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.price = price;
		this.capacity = capacity;
		this.facilities = facilities;
	}

	public Room(String roomNumber, String roomType, String price, String capacity, String facilities) {
		this.roomNumber = Integer.parseInt(roomNumber);
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

	public int getRoomNumber() {
		return roomNumber;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return roomNumber + "," + roomType + "," + price + "," + capacity + "," + facilities;
	}
}