package hotel;

import java.time.LocalDate;

public class Guest {
	private int guestID;
	private String firstName;
	private String lastName;
	private LocalDate dateJoin;

	public Guest(int guestID, String firstName, String lastName, LocalDate dateJoin) {
		this.guestID = guestID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateJoin = dateJoin;
	}

	public Guest(String guestID, String firstName, String lastName, String dateJoin) {
		this.guestID = Integer.parseInt(guestID);
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateJoin = LocalDate.parse(dateJoin);
	}

	public int getGuestID() {
		return guestID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean isGuestVIP() {
		return false;
	}

	public LocalDate getVIPexipryDate() {
		return null;
	}

	public String toString() {
		return guestID + "," + firstName + "," + lastName + "," + dateJoin;
	}
}