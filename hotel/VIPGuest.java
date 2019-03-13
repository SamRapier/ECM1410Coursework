package hotel;

import java.time.LocalDate;

public class VIPGuest extends Guest {

	private LocalDate VIPstartDate;
	private LocalDate VIPexpiryDate;

	public VIPGuest(int guestID, String firstName, String lastName, LocalDate dateJoin, LocalDate VIPstartDate,
			LocalDate VIPexpiryDate) {
		super(guestID, firstName, lastName, dateJoin);
		this.VIPstartDate = VIPstartDate;
		this.VIPexpiryDate = VIPexpiryDate;
	}

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