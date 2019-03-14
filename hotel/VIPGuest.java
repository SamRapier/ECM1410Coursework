package hotel;

import java.time.LocalDate;

public class VIPGuest extends Guest {

	private LocalDate VIPstartDate;
	private LocalDate VIPexpiryDate;

	/**
	 * This is a second constructor for the VIP guest class
	 * 
	 * @param guestID       The unique ID of the guest
	 * @param firstName     The first name of the guest
	 * @param lastName      The last name of the guest
	 * @param dateJoin      The date the guest joined
	 * @param VIPstartDate  The date on which the VIP memebership starts
	 * @param VIPexpiryDate The date on which the VIP memebership ends
	 */
	public VIPGuest(int guestID, String firstName, String lastName, LocalDate dateJoin, LocalDate VIPstartDate,
			LocalDate VIPexpiryDate) {
		super(guestID, firstName, lastName, dateJoin);
		this.VIPstartDate = VIPstartDate;
		this.VIPexpiryDate = VIPexpiryDate;
	}

	/**
	 * This is a second constructor for the VIP guest class that converts string
	 * data types into the correct data type for the corresponding variables.
	 * 
	 * This constructor is used when reading from the file.
	 * 
	 * @param guestID       The unique ID of the guest
	 * @param firstName     The first name of the guest
	 * @param lastName      The last name of the guest
	 * @param dateJoin      The date the guest joined
	 * @param VIPstartDate  The date on which the VIP memebership starts
	 * @param VIPexpiryDate The date on which the VIP memebership ends
	 */
	public VIPGuest(String guestID, String firstName, String lastName, String dateJoin, String VIPstartDate,
			String VIPexpiryDate) {
		super(guestID, firstName, lastName, dateJoin);
		this.VIPstartDate = LocalDate.parse(VIPstartDate);
		this.VIPexpiryDate = LocalDate.parse(VIPexpiryDate);
	}

	@Override
	public boolean isGuestVIP() {
		return true;
	}

	@Override
	public LocalDate getVIPexipryDate() {
		return VIPexpiryDate;
	}

	@Override
	public String toString() {
		return super.toString() + "," + VIPstartDate + "," + VIPexpiryDate;
	}
}