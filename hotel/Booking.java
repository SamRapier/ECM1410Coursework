package hotel;

import java.time.LocalDate;

public class Booking {
	private int bookingID;
	private int guestID;
	private int roomNumber;
	private LocalDate bookingDate;
	private LocalDate checkin;
	private LocalDate checkout;

	public Booking(int bookingID, int guestID, int roomNumber, LocalDate bookingDate, LocalDate checkin,
			LocalDate checkout) {
		this.bookingID = bookingID;
		this.guestID = guestID;
		this.roomNumber = roomNumber;
		this.bookingDate = bookingDate;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Booking(String bookingID, String guestID, String roomNumber, String bookingDate, String checkin,
			String checkout) {
		this.bookingID = Integer.parseInt(bookingID);
		this.guestID = Integer.parseInt(guestID);
		this.roomNumber = Integer.parseInt(roomNumber);
		this.bookingDate = LocalDate.parse(bookingDate);
		this.checkin = LocalDate.parse(checkin);
		this.checkout = LocalDate.parse(checkout);
	}

	public int getBookingID() {
		return bookingID;
	}

	public int getBookingGuestID() {
		return guestID;
	}

	public int getBookingRoomNum() {
		return roomNumber;
	}

	public LocalDate getBookingCheckin() {
		return checkin;
	}

	public LocalDate getBookingCheckout() {
		return checkout;
	}

	public boolean isBetweenCheckInOut(LocalDate givenDate) {
		// If the chekin date is between the current booking date, return true
		if (!(givenDate.isBefore(checkin) || givenDate.isAfter(checkout))) {
			return true;
		}
		return false;
	}

	public String toString() {
		return bookingID + "," + guestID + "," + roomNumber + "," + bookingDate + "," + checkin + "," + checkout;
	}
}
