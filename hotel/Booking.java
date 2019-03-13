package hotel;

import java.time.LocalDate;

public class Booking {
	private int bookingID;
	private int guestID;
	private int roomNumber;
	private LocalDate bookingDate;
	private LocalDate checkin;
	private LocalDate checkout;
	private double price;

	/**
	 * Constructor for the booking class, takes the variables and initialises them.
	 * 
	 * @param bookingID The bookingID for the booking
	 * @param guestID The guestID of the guest making the booking
	 * @param roomNumber The roomNumber of the room which is being booked
	 * @param bookingDate The date on which the booking is made
	 * @param checkin The checking date for the booking
	 * @param checkout The checkout date for the booking
	 * @param price The price of the booking
	 */
	public Booking(int bookingID, int guestID, int roomNumber, LocalDate bookingDate, LocalDate checkin,
			LocalDate checkout, double price) {
		this.bookingID = bookingID;
		this.guestID = guestID;
		this.roomNumber = roomNumber;
		this.bookingDate = bookingDate;
		this.checkin = checkin;
		this.checkout = checkout;
		this.price = price;
	}

	/**
	 * Constructor for the booking class, takes the variables and initialises them.
	 * This constructor takes string variables and converts them all to the correct
	 * data type
	 * 
	 * @param bookingID   The bookingID for the booking
	 * @param guestID     The guestID of the guest making the booking
	 * @param roomNumber  The roomNumber of the room which is being booked
	 * @param bookingDate The date on which the booking is made
	 * @param checkin     The checking date for the booking
	 * @param checkout    The checkout date for the booking
	 * @param price       The price of the booking
	 */
	public Booking(String bookingID, String guestID, String roomNumber, String bookingDate, String checkin,
			String checkout, String price) {
		this.bookingID = Integer.parseInt(bookingID);
		this.guestID = Integer.parseInt(guestID);
		this.roomNumber = Integer.parseInt(roomNumber);
		this.bookingDate = LocalDate.parse(bookingDate);
		this.checkin = LocalDate.parse(checkin);
		this.checkout = LocalDate.parse(checkout);
		this.price = Double.parseDouble(price);
	}

	/**
	 * Getter method for the booking ID
	 * @return bookingID 
	 */
	public int getBookingID() {
		return bookingID;
	}

	/**
	 * Getter method for the guest ID in the booking class
	 * @return guestID of the guest who booked the room
	 */
	public int getBookingGuestID() {
		return guestID;
	}

	/**
	 * Getter method for the room number in the booking class
	 * 
	 * @return roomNumber of the booked room
	 */
	public int getBookingRoomNum() {
		return roomNumber;
	}

	/**
	 * Getter method for the checking date in the booking class
	 * 
	 * @return checkin date of the booking
	 */
	public LocalDate getBookingCheckin() {
		return checkin;
	}

	/**
	 * Getter method for the checkout date in the booking class
	 * 
	 * @return checkout date of the booking
	 */
	public LocalDate getBookingCheckout() {
		return checkout;
	}

	/**
	 * Getter method for the price in a booking
	 * 
	 * @return price of the booking
	 */
	public double getBookingPrice() {
		return price;
	}

	/**
	 * Calculates if a date is between the checkin and checkout date
	 * 
	 * @param givenDate The date provided which is being checked
	 * @return true if the given date is between checkin and checkout
	 * date otherwise it returns false
	 */
	public boolean isBetweenCheckInOut(LocalDate givenDate) {
		// If the chekin date is between the current booking date, return true
		if (!(givenDate.isBefore(checkin) || givenDate.isAfter(checkout))) {
			return true;
		}
		return false;
	}

	/**
	 * @return the string representation of the guest object
	 */
	public String toString() {
		return bookingID + "," + guestID + "," + roomNumber + "," + bookingDate + "," + checkin + "," + checkout + ","
				+ price;
	}
}
