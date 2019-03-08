package hotel;

import java.time.LocalDate;

public class Payment {
	private LocalDate paymentDate;
	private int guestID;
	private double paymentAmount;
	private String paymentType;

	public Payment(LocalDate paymentDate, int guestID, double paymentAmount, String paymentType) {
		this.paymentDate = paymentDate;
		this.guestID = guestID;
		this.paymentAmount = paymentAmount;
		this.paymentType = paymentType;
	}

	public Payment(String paymentDate, String guestID, String paymentAmount, String paymentType) {
		this.paymentDate = LocalDate.parse(paymentDate);
		this.guestID = Integer.parseInt(guestID);
		this.paymentAmount = Double.parseDouble(paymentAmount);
		this.paymentType = paymentType;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public int getPaymentGuestID() {
		return guestID;
	}

	public String toString() {
		return paymentDate + "," + guestID + "," + paymentAmount + "," + paymentType;
	}

}