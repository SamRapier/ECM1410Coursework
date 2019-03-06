package hotel;

import java.time.LocalDate;

public class HotelTestingApp {
	public static void main(String[] args) {
		HotelImpl testHotel = new HotelImpl("data\\rooms.txt", "data\\bookings.txt", "data\\guests.txt",
				"data\\payments.txt");
		// boolean loadedRooms = testHotel.importRoomsData("data\\rooms.txt");
		// System.out.println(loadedRooms);

		// testHotel.displayAllRooms();
		// testHotel.displayAllGuests();
		// testHotel.displayAllBookings();
		// testHotel.displayAllPayments();
		testHotel.addRoom(105, RoomType.SINGLE, 80.00, 2, "own bathroom");
		testHotel.addRoom(302, RoomType.FAMILY, 100.00, 5, "own bathroom");

		testHotel.displayAllRooms();
		testHotel.displayAllBookings();
		// testHotel.displayAllGuests();
		// testHotel.displayAllPayments();

		System.out.println(testHotel.isAvailable(102, LocalDate.parse("2019-04-04"), LocalDate.parse("2019-04-06")));
		System.out.println(testHotel.isAvailable(102, LocalDate.parse("2019-04-08"), LocalDate.parse("2019-04-09")));

		testHotel.displayBookingsOn(LocalDate.parse("2019-04-02"));
		int[] rooms = testHotel.availableRooms(RoomType.DOUBLE, LocalDate.parse("2019-03-02"),
				LocalDate.parse("2019-03-06"));

		for (int room : rooms) {
			System.out.println(room);
		}

		testHotel.saveRoomsData("data\\rooms.txt");
	}
}


// comment