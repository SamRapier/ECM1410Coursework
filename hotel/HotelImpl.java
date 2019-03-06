package hotel;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.time.LocalDate;
import java.io.*;

public class HotelImpl implements Hotel {

	private ArrayList<ArrayList<String>> roomsArray = new ArrayList<>();
	private ArrayList<String> guestsArray = new ArrayList<>();
	private ArrayList<ArrayList<String>> bookingsArray = new ArrayList<>();
	private ArrayList<String> paymentsArray = new ArrayList<>();

	public HotelImpl(String roomsTxtFileName, String bookingsTxtFileName, String guestsTxtFileName,
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
			roomsArray = importData(roomsTxtFileName, roomsArray);
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
			bookingsArray = importData(bookingsTxtFileName, bookingsArray);
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

	public ArrayList<ArrayList<String>> importData(String txtFileName, ArrayList<ArrayList<String>> mainArray)
			throws Exception {
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			file = new File(txtFileName);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
				// process the line
				// roomsArray.add(line);
				ArrayList<String> dataItems = new ArrayList<>();

				// Could save to an array
				// loop each letter until a comma is found, add all data before that comma to
				// array element

				// int prevItem = 0;
				String currentItem = "";
				for (int i = 0, n = line.length(); i < n; i++) {
					char c = line.charAt(i);
					if (c == ',') {
						dataItems.add(currentItem);
						currentItem = "";
					} else {
						currentItem += c;
					}
				}
				mainArray.add(dataItems);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			br.close();
		}

		return mainArray;
	}

	@Override
	public void displayAllRooms() {
		for (ArrayList<String> room : roomsArray) {
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
		for (ArrayList<String> booking : bookingsArray) {
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
		try {
			ArrayList<String> tempArr = new ArrayList<>();
			tempArr.add(Integer.toString(roomNumber));
			tempArr.add(roomType.toString().toLowerCase());
			tempArr.add(Double.toString(price));
			tempArr.add(Integer.toString(capacity));
			tempArr.add(facilities);

			roomsArray.add(tempArr);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean removeRoom(int roomNumber) {
		try {
			for (int i = 0; i < roomsArray.size(); i++) {
				if (Integer.parseInt(roomsArray.get(i).get(0)) == roomNumber) {
					roomsArray.remove(i);
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
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
		for (ArrayList<String> booking : bookingsArray) {
			if (Integer.parseInt(booking.get(2)) == roomNumber) {
				LocalDate currentCheckin = LocalDate.parse(booking.get(4));
				LocalDate currentCheckout = LocalDate.parse(booking.get(5));

				// If the chekin date is between the current booking date, return false
				if (!(checkin.isBefore(currentCheckin) || checkin.isAfter(currentCheckout))) {
					return false;

					// If the checkout date is between the current booking date, return false
				} else if (!(checkout.isBefore(currentCheckin) || checkout.isAfter(currentCheckout))) {
					return false;
				}
			}
		}
		return true;

	}

	@Override
	public int[] availableRooms(RoomType roomType, LocalDate checkin, LocalDate checkout) {
		ArrayList<Integer> roomNums = new ArrayList<>();
		for (ArrayList<String> room : roomsArray) {
			int roomNum = Integer.parseInt(room.get(0));
			if (room.get(1).equals(roomType.toString().toLowerCase())) {
				if (isAvailable(roomNum, checkin, checkout)) {
					roomNums.add(roomNum);
				}
			}
		}

		int[] rooms = new int[roomNums.size()];
		for (int i = 0; i < roomNums.size(); i++) {
			rooms[i] = roomNums.get(i);
		}

		return rooms;
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
		for (ArrayList<String> booking : bookingsArray) {
			LocalDate currentCheckin = LocalDate.parse(booking.get(4));
			LocalDate currentCheckout = LocalDate.parse(booking.get(5));

			// If the chekin date is between the current booking date, return false
			if (!(thisDate.isBefore(currentCheckin) || thisDate.isAfter(currentCheckout))) {
				System.out.println(booking);
			}
		}
	}

	@Override
	public void displayPaymentsOn(LocalDate thisDate) {

	}

	@Override
	public boolean saveRoomsData(String roomsTxtFileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(roomsTxtFileName));
			String line = "";

			StringBuilder lineBuilder = new StringBuilder();

			for (ArrayList<String> room : roomsArray) {
				for (String i : room) {
					// lineBuilder.append("'").append(i.replace("'", "\\'")).append("',");
					line += i + ",";
				}
				// lineBuilder.deleteCharAt(line.length() - 1);
				System.out.println(line);

				// writer.write(lineBuilder.toString());

				line = "";
			}

			writer.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}

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