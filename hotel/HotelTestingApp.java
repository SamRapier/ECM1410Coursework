package hotel;

import java.time.LocalDate;

public class HotelTestingApp {
	public static void main(String[] args) {
		HotelImpl testHotel = new HotelImpl("data\\rooms.txt", "data\\bookings.txt", "data\\guests.txt",
				"data\\payments.txt");

		testHotel.displayAllRooms();
		testHotel.displayAllGuests();
		testHotel.displayAllBookings();
		testHotel.displayAllPayments();

		System.out.println("Adding room 107: " + testHotel.addRoom(107, RoomType.TWIN, 85.00, 4, "own bathroom"));

		System.out.println("Removing room 202(false): " + testHotel.removeRoom(202));
		System.out.println("Removing room 102(true): " + testHotel.removeRoom(201));

		System.out.println("Adding guest John Wick: " + testHotel.addGuest("John", "Wick", LocalDate.now()));
		System.out.println("Adding VIPguest Mike Tyson: "
				+ testHotel.addGuest("Mike", "Tyson", LocalDate.now(), LocalDate.now(), LocalDate.now().plusYears(1)));

		System.out.println("Removing guest 10003: " + testHotel.removeGuest(10003));

		System.out.println("is room 301 Available (false): "
				+ testHotel.isAvailable(301, LocalDate.parse("2019-04-02"), LocalDate.parse("2019-04-08")));
		System.out.println("is room 301 Available (true): "
				+ testHotel.isAvailable(301, LocalDate.parse("2019-04-12"), LocalDate.parse("2019-04-18")));

		int[] availableRooms = testHotel.availableRooms(RoomType.SINGLE, LocalDate.parse("2019-04-12"),
				LocalDate.parse("2019-04-14"));
		for (int i : availableRooms) {
			System.out.println("This room is available: " + i);
		}

		int bookedRoomNum = testHotel.bookOneRoom(10007, RoomType.TWIN, LocalDate.parse("2019-04-01"),
				LocalDate.parse("2019-04-06"));
		System.out.println(bookedRoomNum);

		System.out.println("Check out id 100008(true): " + testHotel.checkOut(100008, LocalDate.parse("2019-04-04")));

		System.out.println("Cancel booking 100003(true): " + testHotel.cancelBooking(100003));

		int[] searchGuestIDs = testHotel.searchGuest("John", "cooper");
		System.out.println("searchGuestIds: ");
		for (int i : searchGuestIDs) {
			System.out.println(i);
		}

		testHotel.displayGuestBooking(10005);

		testHotel.displayBookingsOn(LocalDate.parse("2019-04-02"));

		testHotel.displayPaymentsOn(LocalDate.parse("2019-02-10"));

		testHotel.saveRoomsData("data\\rooms.txt");
		testHotel.saveGuestsData("data\\guests.txt");
		testHotel.saveBookingsData("data\\bookings.txt");
		testHotel.savePaymentsData("data\\payments.txt");

	}
}