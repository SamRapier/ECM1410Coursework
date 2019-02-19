package hotel;

public class HotelTestingApp {
	public static void main(String[] args) {
		HotelImpl testHotel = new HotelImpl("data\\rooms.txt", "data\\bookings.txt", "data\\guests.txt",
				"data\\payments.txt");
		// boolean loadedRooms = testHotel.importRoomsData("data\\rooms.txt");
		// System.out.println(loadedRooms);
		testHotel.displayAllRooms();
		testHotel.displayAllGuests();
		testHotel.displayAllBookings();
		testHotel.displayAllPayments();

	}
}