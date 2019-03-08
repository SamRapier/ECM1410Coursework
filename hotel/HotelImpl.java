package hotel;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.time.LocalDate;
import java.io.*;

public class HotelImpl implements Hotel {

	// initialising the arrays for the internal data storage
	private ArrayList<ArrayList<String>> roomsArray = new ArrayList<>();
	private ArrayList<ArrayList<String>> guestsArray = new ArrayList<>();
	private ArrayList<ArrayList<String>> bookingsArray = new ArrayList<>();
	private ArrayList<ArrayList<String>> paymentsArray = new ArrayList<>();

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
			importData(roomsTxtFileName, roomsArray);
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
			importData(guestsTxtFileName, guestsArray);
			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public boolean importBookingsData(String bookingsTxtFileName) {
		try {
			importData(bookingsTxtFileName, bookingsArray);
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
			importData(paymentsTxtFileName, paymentsArray);
			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	/**
	 * This method is a genreal method which imports the data from a file and saves
	 * it to an array, the location of the file and the array to be saved to are
	 * passed as arguments
	 * 
	 * @param txtFileName the fileLocation for the file that we are importing
	 * @param mainArray   the array that the file is being saved to
	 */
	public void importData(String txtFileName, ArrayList<ArrayList<String>> mainArray) throws Exception {

		File file = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			file = new File(txtFileName);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line;

			// loops through each
			while ((line = br.readLine()) != null) {
				// process the line
				// roomsArray.add(line);
				ArrayList<String> dataItems = new ArrayList<>();

				// Could save to an array
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
				// the dataItems array is added to the mainArray
				mainArray.add(dataItems);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			br.close();
		}
	}

	@Override
	public void displayAllRooms() {
		// Prints the ArrayList of the data on each individual room
		System.out.println("Rooms:");
		for (ArrayList<String> room : roomsArray) {
			System.out.println(room);
		}
	}

	@Override
	public void displayAllGuests() {
		// Prints the ArrayList of the data on each individual guest
		System.out.println("Guests:");
		for (ArrayList<String> guest : guestsArray) {
			System.out.println(guest);
		}
	}

	@Override
	public void displayAllBookings() {
		// Prints the ArrayList of the data on each individual booking
		System.out.println("Bookings:");
		for (ArrayList<String> booking : bookingsArray) {
			System.out.println(booking);
		}
	}

	@Override
	public void displayAllPayments() {
		// Prints the ArrayList of the data on each individual payment
		System.out.println("Payments:");
		for (ArrayList<String> payment : paymentsArray) {
			System.out.println(payment);
		}
	}

	@Override
	public boolean addRoom(int roomNumber, RoomType roomType, double price, int capacity, String facilities) {
		try {
			// A pre check is performed to ensure that the roomNumber does not already exist
			// if a room number already exists, false is returned
			for (int i = 0; i < roomsArray.size(); i++) {
				if (Integer.parseInt(roomsArray.get(i).get(0)) == roomNumber) {
					return false;
				}
			}

			// A temporary array is created to add each of the data items to
			ArrayList<String> tempArr = new ArrayList<>();
			tempArr.add(Integer.toString(roomNumber));
			tempArr.add(roomType.toString().toLowerCase());
			tempArr.add(Double.toString(price));
			tempArr.add(Integer.toString(capacity));
			tempArr.add(facilities);

			// this temporary array is then added to the main room array
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
			// Pre check if the room is booked after today, then the room cannot be removed
			// loop through each booking
			for (ArrayList<String> booking : bookingsArray) {
				// finds any correlating room numbers
				if (Integer.parseInt(booking.get(2)) == roomNumber) {
					LocalDate checkout = LocalDate.parse(booking.get(5));
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
				if (Integer.parseInt(roomsArray.get(i).get(0)) == roomNumber) {
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
			ArrayList<String> lastItem = guestsArray.get(lenArr);
			// takes the id of the last item in the guest array
			int prevGuestID = Integer.parseInt(lastItem.get(0));
			// increments the last guestID by 1 to get the newID
			int newID = prevGuestID + 1;

			// A temporary arrayList is created to add all the data items to
			ArrayList<String> tempArr = new ArrayList<>();
			tempArr.add(Integer.toString(newID));
			tempArr.add(fName);
			tempArr.add(lName);
			tempArr.add(dateJoin.toString());

			// the temporary arraylist is added to the guestArray
			guestsArray.add(tempArr);
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
			ArrayList<String> lastItem = guestsArray.get(lenArr);
			// takes the id of the last item in the guest array
			int prevGuestID = Integer.parseInt(lastItem.get(0));
			// increments the last guestID by 1 to get the newID
			int newID = prevGuestID + 1;

			// A temporary arrayList is created to add all the data items for the new guest
			// to
			ArrayList<String> tempArr = new ArrayList<>();
			tempArr.add(Integer.toString(newID));
			tempArr.add(fName);
			tempArr.add(lName);
			tempArr.add(dateJoin.toString());
			tempArr.add(VIPstartDate.toString());
			tempArr.add(VIPexpiryDate.toString());

			// A temporary array to add all the payment data to
			ArrayList<String> paymentTempArr = new ArrayList<>();
			paymentTempArr.add(LocalDate.now().toString());
			paymentTempArr.add(Integer.toString(newID));
			paymentTempArr.add(Double.toString(50.00));
			paymentTempArr.add("VIPmembership");

			// adds the guest temp array to the guestsArray
			guestsArray.add(tempArr);
			// adds the payment temp array to the paymentsArray
			paymentsArray.add(paymentTempArr);
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
			for (ArrayList<String> booking : bookingsArray) {
				if (Integer.parseInt(booking.get(1)) == guestID) {
					// initialises the checkout date and current date
					LocalDate checkout = LocalDate.parse(booking.get(5));
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
				if (Integer.parseInt(guestsArray.get(i).get(0)) == guestID) {
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
			for (ArrayList<String> room : roomsArray) {
				if (roomNumber == Integer.parseInt(room.get(0))) {

					// loops through the booking array
					for (ArrayList<String> booking : bookingsArray) {
						// Checks if the roomNumber in the bookingArray matches the roomNumber being
						// searched for
						if (Integer.parseInt(booking.get(2)) == roomNumber) {
							// initialises the bookingCHeckin date and the bookingCheckout date
							LocalDate bookingCheckin = LocalDate.parse(booking.get(4));
							LocalDate bookingCheckout = LocalDate.parse(booking.get(5));

							// If the chekin date is between the current booking date, return false
							if (!(checkin.isBefore(bookingCheckin) || checkin.isAfter(bookingCheckout))) {
								return false;

								// If the checkout date is between the current booking date, return false
							} else if (!(checkout.isBefore(bookingCheckin) || checkout.isAfter(bookingCheckout))) {
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
			for (ArrayList<String> room : roomsArray) {
				int roomNum = Integer.parseInt(room.get(0));
				if (room.get(1).equals(roomType.toString().toLowerCase())) {
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
				ArrayList<String> lastItem = bookingsArray.get(lenArr);
				int prevBookID = Integer.parseInt(lastItem.get(0));
				int newBookingID = prevBookID + 1;

				ArrayList<String> bookingTempArr = new ArrayList<>();
				bookingTempArr.add(Integer.toString(newBookingID));
				bookingTempArr.add(Integer.toString(guestID));
				bookingTempArr.add(Integer.toString(roomID));
				bookingTempArr.add(LocalDate.now().toString());
				bookingTempArr.add(checkin.toString());
				bookingTempArr.add(checkout.toString());

				// Check if guest is VIP
				boolean guestVIP = false;
				for (ArrayList<String> guest : guestsArray) {
					if (Integer.parseInt(guest.get(0)) == guestID) {
						if (guest.size() > 4) {
							if (LocalDate.parse(guest.get(5)).isBefore(LocalDate.now())) {
								guestVIP = true;
							}
						}
					}
				}

				// Calc price of booking
				double roomPrice = 0;
				for (ArrayList<String> room : roomsArray) {
					if (Integer.parseInt(room.get(0)) == roomID) {
						roomPrice = Double.parseDouble(room.get(2));
						if (guestVIP) {
							roomPrice -= (roomPrice / 10);
						}
					}
				}

				// Add to payment array
				ArrayList<String> paymentTempArr = new ArrayList<>();
				paymentTempArr.add(LocalDate.now().toString());
				paymentTempArr.add(Integer.toString(guestID));
				paymentTempArr.add(Double.toString(roomPrice));
				paymentTempArr.add("booking");

				bookingsArray.add(bookingTempArr);
				paymentsArray.add(paymentTempArr);

				return roomID;
			} else {
				return -1;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
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
		try {
			ArrayList<Integer> IdArray = new ArrayList<>();
			for (int i = 0; i < guestsArray.size(); i++) {
				String guestFName = guestsArray.get(i).get(1).toLowerCase();
				String guestSName = guestsArray.get(i).get(2).toLowerCase();

				firstName = firstName.toLowerCase();
				lastName = lastName.toLowerCase();

				if (guestFName.equals(firstName) && guestSName.equals(lastName)) {
					// Add guestId to array
					IdArray.add(Integer.parseInt(guestsArray.get(i).get(0)));
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
			saveData(roomsTxtFileName, roomsArray);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

	@Override
	public boolean saveGuestsData(String guestsTxtFileName) {
		try {
			saveData(guestsTxtFileName, guestsArray);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean saveBookingsData(String bookingsTxtFileName) {
		try {
			saveData(bookingsTxtFileName, bookingsArray);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean savePaymentsData(String paymentsTxtFileName) {
		try {
			saveData(paymentsTxtFileName, paymentsArray);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public void saveData(String txtFileName, ArrayList<ArrayList<String>> mainArray) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(txtFileName));
		String line = "";

		for (ArrayList<String> item : mainArray) {
			for (String i : item) {
				line += i + ",";
			}
			String newLine = line.substring(0, line.length() - 1);

			writer.write(newLine);
			writer.newLine();

			line = "";
		}

		// remove last line

		writer.close();
	}
}