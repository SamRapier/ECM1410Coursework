package hotel;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.time.LocalDate;
import java.io.*;

public class HotelImpl implements Hotel {

	// initialising the arrays for the internal data storage
	private ArrayList<Room> roomsArray = new ArrayList<>();
	private ArrayList<Guest> guestsArray = new ArrayList<>();
	private ArrayList<Booking> bookingsArray = new ArrayList<>();
	private ArrayList<Payment> paymentsArray = new ArrayList<>();

	/**
	 * Constructor for the HotelImpl Loads all of the files into respective arrays
	 * 
	 * @param roomsTxtFileName
	 * @param bookingsTxtFileName
	 * @param guestsTxtFileName
	 * @param paymentsTxtFileName
	 */
	public HotelImpl(String roomsTxtFileName, String bookingsTxtFileName, String guestsTxtFileName,
			String paymentsTxtFileName) {

		// imports all the files, outputs that the file has loaded if it has been
		// successful.
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
		// Attempts to import the data to the array, otherwise the exception is
		// outputted
		try {
			File file = new File(roomsTxtFileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;

			// loops through each line in the file
			while ((line = br.readLine()) != null) {
				ArrayList<String> dataItems = new ArrayList<>();
				// loop each letter until a comma is found, add all data before that comma to
				// array element

				separateDataItems(line, dataItems);

				// The newRoom object is made and then added to the roomsArray
				Room newRoom = new Room(dataItems.get(0), dataItems.get(1), dataItems.get(2), dataItems.get(3),
						dataItems.get(4));

				roomsArray.add(newRoom);
			}
			br.close();
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean importGuestsData(String guestsTxtFileName) {
		// Attempts to import the data to the array, otherwise the exception is
		// outputted
		try {
			File file = new File(guestsTxtFileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;

			// loops through each line in the file
			while ((line = br.readLine()) != null) {
				ArrayList<String> dataItems = new ArrayList<>();
				separateDataItems(line, dataItems);

				// The newGuest object is made and then added to the guestArray
				Guest newGuest;
				if (dataItems.size() == 6) {
					newGuest = new VIPGuest(dataItems.get(0), dataItems.get(1), dataItems.get(2), dataItems.get(3),
							dataItems.get(4), dataItems.get(5));
				} else {
					newGuest = new Guest(dataItems.get(0), dataItems.get(1), dataItems.get(2), dataItems.get(3));
				}

				guestsArray.add(newGuest);
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

			// loops through each line in the file
			while ((line = br.readLine()) != null) {
				ArrayList<String> dataItems = new ArrayList<>();
				separateDataItems(line, dataItems);

				// The newBooking object is made and then added to the bookingsArray
				Booking newBooking = new Booking(dataItems.get(0), dataItems.get(1), dataItems.get(2), dataItems.get(3),
						dataItems.get(4), dataItems.get(5));

				bookingsArray.add(newBooking);
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
		// Attempts to import the data to the array, otherwise the exception is
		// outputted
		try {
			File file = new File(paymentsTxtFileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;

			// loops through each line in the file
			while ((line = br.readLine()) != null) {
				ArrayList<String> dataItems = new ArrayList<>();
				separateDataItems(line, dataItems);

				// The newPayment object is made and then added to the paymentsArray
				Payment newPayment = new Payment(dataItems.get(0), dataItems.get(1), dataItems.get(2),
						dataItems.get(3));

				paymentsArray.add(newPayment);
			}
			br.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	/**
	 * 
	 * @param dataItems
	 * @param line
	 */
	public void separateDataItems(String line, ArrayList<String> dataItems) {
		// loop each letter until a comma is found, add all data before that comma to
		// array element
		String currentItem = "";
		// Loops through the character in the line
		for (int i = 0, n = line.length(); i < n; i++) {
			// every character in the line is checked to see if it is a comma
			// if it is a comma, the currentItem string is added to the dataItems ArrayList
			// if it is not a comma, the character is added to the currentItem string
			char c = line.charAt(i);
			if (c == ',') {
				dataItems.add(currentItem);
				currentItem = "";
			} else {
				currentItem += c;
			}
		}
		// the final dataItem is added to the dataItem array
		dataItems.add(currentItem);
		// return dataItems;
	}

	@Override
	public void displayAllRooms() {
		// Prints the ArrayList of the data on each individual room
		System.out.println("Rooms:");
		for (Room room : roomsArray) {
			System.out.println(room.toString());
		}
	}

	@Override
	public void displayAllGuests() {
		// Prints the ArrayList of the data on each individual guest
		System.out.println("Guests:");
		for (Guest guest : guestsArray) {
			System.out.println(guest.toString());
		}
	}

	@Override
	public void displayAllBookings() {
		// Prints the ArrayList of the data on each individual booking
		System.out.println("Bookings:");
		for (Booking booking : bookingsArray) {
			System.out.println(booking.toString());
		}
	}

	@Override
	public void displayAllPayments() {
		// Prints the ArrayList of the data on each individual payment
		System.out.println("Payments:");
		for (Payment payment : paymentsArray) {
			System.out.println(payment.toString());
		}
	}

	@Override
	public boolean addRoom(int roomNumber, RoomType roomType, double price, int capacity, String facilities) {
		try {
			// A pre check is performed to ensure that the roomNumber does not already exist
			// if a room number already exists, false is returned
			for (int i = 0; i < roomsArray.size(); i++) {
				if (roomsArray.get(i).getRoomNumber() == roomNumber) {
					return false;
				}
			}

			roomsArray.add(new Room(roomNumber, roomType, price, capacity, facilities));
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean removeRoom(int roomNumber) {
		try {
			// Pre check if the room is booked after today, then the room cannot be removed
			// loop through each booking
			for (Booking booking : bookingsArray) {
				// finds any correlating room numbers
				if (booking.getBookingRoomNum() == roomNumber) {
					LocalDate checkout = booking.getBookingCheckout();
					LocalDate currentDate = LocalDate.now();

					// if the current date is before the checkout date then the room cannot be
					// removed
					if (currentDate.isBefore(checkout)) {
						System.out.println("Error - Cannot remove room - Room has a booking in future");
						return false;
					}
				}
			}

			// Loops through the room array and finds the corresponding room number
			for (int i = 0; i < roomsArray.size(); i++) {
				if (roomsArray.get(i).getRoomNumber() == roomNumber) {
					// removes the room from the array
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
		try {
			// This creates a new unique ID for each guest
			// gets the last item in the guestArray
			int lenArr = guestsArray.size() - 1;
			Guest lastGuest = guestsArray.get(lenArr);
			// takes the id of the last item in the guest array
			int prevGuestID = lastGuest.getGuestID();
			// increments the last guestID by 1 to get the newID
			int newID = prevGuestID + 1;

			guestsArray.add(new Guest(newID, fName, lName, dateJoin));
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean addGuest(String fName, String lName, LocalDate dateJoin, LocalDate VIPstartDate,
			LocalDate VIPexpiryDate) {
		try {
			// This creates a new unique ID for each guest
			// gets the last item in the guestArray
			int lenArr = guestsArray.size() - 1;
			Guest lastGuest = guestsArray.get(lenArr);
			// takes the id of the last item in the guest array
			int prevGuestID = lastGuest.getGuestID();
			// increments the last guestID by 1 to get the newID
			int newID = prevGuestID + 1;

			guestsArray.add(new VIPGuest(newID, fName, lName, dateJoin, VIPstartDate, VIPexpiryDate));
			paymentsArray.add(new Payment(LocalDate.now(), newID, 50.00, "VIPmembership"));
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean removeGuest(int guestID) {
		try {
			// Pre check if guest is booked in a room in the future
			for (Booking booking : bookingsArray) {
				if (booking.getBookingGuestID() == guestID) {
					// initialises the checkout date and current date
					LocalDate checkout = booking.getBookingCheckout();
					LocalDate currentDate = LocalDate.now();

					// is the current date is before the checkout date, then the guest cannot be
					// removed
					if (currentDate.isBefore(checkout)) {
						System.out.println("Error - Cannot remove guest - Guest has a booking in future");
						return false;
					}
				}
			}

			// loops through the guest array unitl the guestID matches
			for (int i = 0; i < guestsArray.size(); i++) {
				if (guestsArray.get(i).getGuestID() == guestID) {
					// removes the guest if the ID matches
					guestsArray.remove(i);
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
	public boolean isAvailable(int roomNumber, LocalDate checkin, LocalDate checkout) {
		try {
			// loops through the room array and checks if the roomNumber exists
			for (Room room : roomsArray) {
				if (roomNumber == room.getRoomNumber()) {

					// loops through the booking array
					for (Booking booking : bookingsArray) {
						// Checks if the roomNumber in the bookingArray matches the roomNumber being
						// searched for
						if (booking.getBookingRoomNum() == roomNumber) {
							// initialises the bookingCHeckin date and the bookingCheckout date

							// If the chekin date is between the current booking date, return false
							if (booking.isBetweenCheckInOut(checkin)) {
								return false;

								// If the checkout date is between the current booking date, return false
							} else if (booking.isBetweenCheckInOut(checkout)) {
								return false;
							}

							// If the checkin date and checkout date are not between the booking checkin and
							// checkout date then return true
							return true;
						}
					}
					// if the roomNumber cannot be found in the booking array, but is in the room
					// array it must be available
					return true;
				}
			}
			// if the roomnumber does not exist, return false
			return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public int[] availableRooms(RoomType roomType, LocalDate checkin, LocalDate checkout) {
		try {
			ArrayList<Integer> roomNums = new ArrayList<>();
			for (Room room : roomsArray) {
				int roomNum = room.getRoomNumber();
				if (room.getRoomType().equals(roomType)) {
					if (isAvailable(roomNum, checkin, checkout)) {
						roomNums.add(roomNum);
					}
				}
			}

			if (roomNums.size() > 0) {
				int[] rooms = new int[roomNums.size()];
				for (int i = 0; i < roomNums.size(); i++) {
					rooms[i] = roomNums.get(i);
				}
				return rooms;
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public int bookOneRoom(int guestID, RoomType roomType, LocalDate checkin, LocalDate checkout) {
		try {
			int[] roomChoice = availableRooms(roomType, checkin, checkout);
			// checks to ensure there are values in the roomChoice array
			if (roomChoice != null) {

				int roomID = roomChoice[0];

				int lenArr = bookingsArray.size() - 1;
				Booking lastBooking = bookingsArray.get(lenArr);
				int prevBookID = lastBooking.getBookingID();
				int newBookingID = prevBookID + 1;

				double roomPrice = calcPaymentPrice(guestID, roomID);

				bookingsArray.add(new Booking(newBookingID, guestID, roomID, LocalDate.now(), checkin, checkout));
				paymentsArray.add(new Payment(LocalDate.now(), guestID, roomPrice, "booking"));

				return roomID;
			} else {
				return -1;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

	public double calcPaymentPrice(int guestID, int roomID) {
		try {
			// Check if guest is VIP
			boolean guestVIP = false;
			for (Guest guest : guestsArray) {
				if (guest.getGuestID() == guestID) {
					guestVIP = guest.isGuestVIP();
				}
			}

			// Calc price of booking
			double roomPrice = 0;
			for (Room room : roomsArray) {
				if (room.getRoomNumber() == roomID) {
					roomPrice = room.getPrice();
					if (guestVIP) {
						roomPrice -= (roomPrice / 10);
					}
				}
			}
			return roomPrice;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert false;
			return -1;
		}

	}

	@Override
	public boolean checkOut(int bookingID, LocalDate actualCheckoutDate) {
		for (int i = 0; i < bookingsArray.size(); i++) {
			Booking booking = bookingsArray.get(i);
			if (booking.getBookingID() == bookingID) {
				if (booking.isBetweenCheckInOut(actualCheckoutDate)) {
					bookingsArray.remove(i);
					return true;
				}
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean cancelBooking(int bookingID) {
		for (int i = 0; i < bookingsArray.size(); i++) {
			Booking booking = bookingsArray.get(i);

			if (booking.getBookingID() == bookingID) {
				LocalDate today = LocalDate.now();

				if (today.plusDays(2).isBefore(booking.getBookingCheckin())) {
					double refundAmount = calcPaymentPrice(booking.getBookingGuestID(), booking.getBookingRoomNum());
					paymentsArray.add(new Payment(today, booking.getBookingGuestID(), -refundAmount, "refund"));
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public int[] searchGuest(String firstName, String lastName) {
		try {
			ArrayList<Integer> IdArray = new ArrayList<>();
			for (Guest guest : guestsArray) {
				String guestFName = guest.getFirstName().toLowerCase();
				String guestSName = guest.getLastName().toLowerCase();

				firstName = firstName.toLowerCase();
				lastName = lastName.toLowerCase();

				if (guestFName.equals(firstName) && guestSName.equals(lastName)) {
					// Add guestId to array
					IdArray.add(guest.getGuestID());
					System.out.println(guest.toString());
					displayGuestBooking(guest.getGuestID());
				}
			}

			if (IdArray.size() > 0) {
				int[] guestIDs = new int[IdArray.size()];
				for (int i = 0; i < IdArray.size(); i++) {
					guestIDs[i] = IdArray.get(i);
				}
				return guestIDs;

			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public void displayGuestBooking(int guestID) {
		for (Guest guest : guestsArray) {
			for (Booking booking : bookingsArray){
				if(guest.getGuestID() == booking.getBookingGuestID()){
					System.out.println(booking.toString());
				}
			}
		}
	}

	@Override
	public void displayBookingsOn(LocalDate thisDate) {
		for (Booking booking : bookingsArray) {
			LocalDate currentCheckin = booking.getBookingCheckin();
			LocalDate currentCheckout = booking.getBookingCheckout();

			// If the chekin date is between the current booking date, return false
			if (!(thisDate.isBefore(currentCheckin) || thisDate.isAfter(currentCheckout))) {
				System.out.println(booking);
			}
		}
	}

	@Override
	public void displayPaymentsOn(LocalDate thisDate) {
		for (Payment payment : paymentsArray) {
			if (payment.getPaymentDate() == thisDate) {
				System.out.println(payment.toString());
			}
		}
	}

	@Override
	public boolean saveRoomsData(String roomsTxtFileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(roomsTxtFileName));

			for (Room room : roomsArray) {
				writer.write(room.toString());
				writer.newLine();
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
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(guestsTxtFileName));

			for (Guest guest : guestsArray) {
				writer.write(guest.toString());
				writer.newLine();
			}

			writer.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean saveBookingsData(String bookingsTxtFileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(bookingsTxtFileName));

			for (Booking booking : bookingsArray) {
				writer.write(booking.toString());
				writer.newLine();
			}

			writer.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean savePaymentsData(String paymentsTxtFileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(paymentsTxtFileName));

			for (Payment payment : paymentsArray) {
				writer.write(payment.toString());
				writer.newLine();
			}

			writer.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}