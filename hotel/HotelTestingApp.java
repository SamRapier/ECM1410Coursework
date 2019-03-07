package hotel;

import java.time.LocalDate;

public class HotelTestingApp {
	public static void main(String[] args) {
		HotelImpl testHotel = new HotelImpl("data\\rooms.txt", "data\\bookings.txt", "data\\guests.txt",
				"data\\payments.txt");
		// boolean loadedRooms = testHotel.importRoomsData("data\\rooms.txt");
		// System.out.println(loadedRooms);

		System.out.println("Rooms:");
		testHotel.displayAllRooms();

		System.out.println("Guests:");
		testHotel.displayAllGuests();

		System.out.println("Bookings:");
		testHotel.displayAllBookings();

		System.out.println("Payments:");
		testHotel.displayAllPayments();

		// testHotel.addRoom(105, RoomType.SINGLE, 80.00, 2, "own bathroom");
		// testHotel.addRoom(302, RoomType.FAMILY, 100.00, 5, "own bathroom");

		System.out.println(testHotel.isAvailable(102, LocalDate.parse("2019-04-04"), LocalDate.parse("2019-04-06")));
		System.out.println(testHotel.isAvailable(102, LocalDate.parse("2019-04-08"), LocalDate.parse("2019-04-09")));

		testHotel.displayBookingsOn(LocalDate.parse("2019-04-02"));
		int[] rooms = testHotel.availableRooms(RoomType.DOUBLE, LocalDate.parse("2019-03-02"),
				LocalDate.parse("2019-03-06"));

		for (int room : rooms) {
			System.out.println(room);
		}

		testHotel.addGuest("Joe", "Rogan", LocalDate.parse("2019-03-07"), LocalDate.parse("2019-03-07"),
				LocalDate.parse("2020-03-07"));

		testHotel.removeGuest(10006);
		System.out.println("Guests:");
		testHotel.displayAllGuests();

		// testHotel.saveRoomsData("data\\rooms.txt");

	}
}