
package hotel;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

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

	public void displayAllRooms() {
		for (String room : roomsArray) {
			System.out.println(room);
		}
	}

	public void displayAllGuests() {
		for (String guest : guestsArray) {
			System.out.println(guest);
		}
	}

	public void displayAllBookings() {
		for (String booking : bookingsArray) {
			System.out.println(booking);
		}
	}

	public void displayAllPayments() {
		for (String payment : paymentsArray) {
			System.out.println(payment);
		}
	}

}