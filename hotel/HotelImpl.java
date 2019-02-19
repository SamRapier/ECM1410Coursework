
package hotel;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.time.LocalDate;

public class HotelImpl implements Hotel {

	private ArrayList<String> roomsArray = new ArrayList<>();
	private ArrayList<String> guestsArray = new ArrayList<>();
	private ArrayList<String> bookingsArray = new ArrayList<>();
	private ArrayList<String> paymentsArray = new ArrayList<>();

	public HotelImpl(String roomsTxtFileName, String guestsTxtFileName, String bookingsTxtFileName,
			String paymentsTxtFileName) {

		if (importRoomsData(roomsTxtFileName)) {
			System.out.println("Rooms file loaded");
		}
		if (importGuestsData(guestsTxtFileName)) {
			System.out.println("Guests file loaded");
		}
		if (importBookingsData(bookingsTxtFileName)) {
			System.out.println("Bookings file loaded");
		}
		if (importPaymentsData(paymentsTxtFileName)) {
			System.out.println("Payments file loaded");
		}
	}

	@Override
	public boolean importRoomsData(String roomsTxtFileName) {
		try {
			File file = new File(roomsTxtFileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				// process the line
				// System.out.println(line);
				roomsArray.add(line);
			}
			br.close();
			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public boolean importGuestsData(String guestsTxtFileName) {
		try {
			File file = new File(guestsTxtFileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				// process the line
				// System.out.println(line);
				guestsArray.add(line);
			}
			br.close();
			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public boolean importBookingsData(String bookingsTxtFileName) {
		try {
			File file = new File(bookingsTxtFileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				// process the line
				// System.out.println(line);
				bookingsArray.add(line);
			}
			br.close();
			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public boolean importPaymentsData(String paymentsTxtFileName) {
		try {
			File file = new File(paymentsTxtFileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				// process the line
				// System.out.println(line);
				paymentsArray.add(line);
			}
			br.close();
			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public void displayAllRooms() {
		for (String room : roomsArray) {
			System.out.println(room);
		}
	}

	@Override
	public void displayAllGuests() {
		for (String guest : guestsArray) {
			System.out.println(guest);
		}
	}

	@Override
	public void displayAllBookings() {
		for (String booking : bookingsArray) {
			System.out.println(booking);
		}
	}

	@Override
	public void displayAllPayments() {
		for (String payment : paymentsArray) {
			System.out.println(payment);
		}
	}

	@Override
	public boolean addRoom(int roomNumber, RoomType roomType, double price, int capacity, String facilities) {
		return false;
	}

	@Override
	public boolean removeRoom(int roomNumber) {
		return false;
	}

	@Override
	public boolean addGuest(String fName, String lName, LocalDate dateJoin) {
		return false;
	}

	@Override
	public boolean addGuest(String fName, String lName, LocalDate dateJoin, LocalDate VIPstartDate,
			LocalDate VIPexpiryDate) {
		return false;
	}

	@Override
	public boolean removeGuest(int guestID) {
		return false;
	}

	@Override
	public boolean isAvailable(int roomNumber, LocalDate checkin, LocalDate checkout) {
		return false;
	}

	@Override
	public int[] availableRooms(RoomType roomType, LocalDate checkin, LocalDate checkout) {
		return null;
	}

	@Override
	public int bookOneRoom(int guestID, RoomType roomType, LocalDate checkin, LocalDate checkout) {
		return 0;
	}

	@Override
	public boolean checkOut(int bookingID, LocalDate actualCheckoutDate) {
		return false;
	}

	@Override
	public boolean cancelBooking(int bookingID) {
		return false;
	}

	@Override
	public int[] searchGuest(String firstName, String lastName) {
		return null;
	}

	@Override
	public void displayGuestBooking(int guestID) {

	}

	@Override
	public void displayBookingsOn(LocalDate thisDate) {

	}

	@Override
	public void displayPaymentsOn(LocalDate thisDate) {

	}

	@Override
	public boolean saveRoomsData(String roomsTxtFileName) {
		return false;
	}

	@Override
	public boolean saveGuestsData(String guestsTxtFileName) {
		return false;
	}

	@Override
	public boolean saveBookingsData(String bookingsTxtFileName) {
		return false;
	}

	@Override
	public boolean savePaymentsData(String paymentsTxtFileName) {
		return false;
	}
}