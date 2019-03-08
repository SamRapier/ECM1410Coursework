package hotel;

import java.time.LocalDate;

public class Guest {
	private int guestID;
	private String firstName;
	private String lastName;
	private LocalDate dateJoin;
	private LocalDate VIPstartDate;
	private LocalDate VIPexpiryDate;

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

	public Guest(int guestID, String firstName, String lastName, LocalDate dateJoin, LocalDate VIPstartDate,
			LocalDate VIPexpiryDate) {
		this(guestID, firstName, lastName, dateJoin);
		this.VIPstartDate = VIPstartDate;
		this.VIPexpiryDate = VIPexpiryDate;
	}

	public Guest(String guestID, String firstName, String lastName, String dateJoin, String VIPstartDate,
			String VIPexpiryDate) {
		this(guestID, firstName, lastName, dateJoin);
		this.VIPstartDate = LocalDate.parse(VIPstartDate);
		this.VIPexpiryDate = LocalDate.parse(VIPexpiryDate);
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

	public LocalDate getVIPexipryDate() {
		if (isGuestVIP())
			return VIPexpiryDate;
		else
			return null;
	}

	public boolean isGuestVIP() {
		if (VIPexpiryDate != null && LocalDate.now().isBefore(VIPexpiryDate)) {
			return true;
		}
		return false;
	}

	public String toString() {
		if (isGuestVIP())
			return guestID + "," + firstName + "," + lastName + "," + dateJoin + "," + VIPstartDate + ","
					+ VIPexpiryDate;
		else
			return guestID + "," + firstName + "," + lastName + "," + dateJoin;
	}
}