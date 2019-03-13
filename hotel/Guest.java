package hotel;

import java.time.LocalDate;

public class Guest {
	private int guestID;
	private String firstName;
	private String lastName;
	private LocalDate dateJoin;

	/**
	 * This is the constructor for the guest class
	 * 
	 * @param guestID - int
	 * @param firstName - String
	 * @param lastName - String
	 * @param dateJoin - LocalDate
	 */
	public Guest(int guestID, String firstName, String lastName, LocalDate dateJoin) {
		this.guestID = guestID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateJoin = dateJoin;
	}

	/**
	 * This is a second constructor for the guest class that converts string data
	 * types into the correct data type for the corresponding variables.
	 * 
	 * This constructor is used when reading from the file.
	 * 
	 * @param guestID   - String
	 * @param firstName - String
	 * @param lastName  - String
	 * @param dateJoin  - String
	 */
	public Guest(String guestID, String firstName, String lastName, String dateJoin) {
		this.guestID = Integer.parseInt(guestID);
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateJoin = LocalDate.parse(dateJoin);
	}

	/**
	 * Getter method which returns the guest ID
	 * 
	 * @return guestID
	 */
	public int getGuestID() {
		return guestID;
	}

	/**
	 * Getter method which returns the first name
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Getter method which returns the last name
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Getter method which returns the a true or false, depending on whether the
	 * guest is a VIP
	 */
	public boolean isGuestVIP() {
		return false;
	}

	/**
	 * Getter method which returns VIP exipry date
	 */
	public LocalDate getVIPexipryDate() {
		return null;
	}

	/**
	 * Returns the string representation of the guest object
	 */
	public String toString() {
		return guestID + "," + firstName + "," + lastName + "," + dateJoin;
	}
}