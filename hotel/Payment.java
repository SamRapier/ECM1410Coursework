package hotel;

import java.time.LocalDate;

public class Payment {
	private LocalDate paymentDate;
	private int guestID;
	private double paymentAmount;
	private String paymentType;

	/**
	 * Constructor for the payment class, takes the variables and initialises them.
	 * 
	 * @param paymentDate   The date the payment was made
	 * @param guestID       The guestID of the guest who made the payment
	 * @param paymentAmount The amount of the payment
	 * @param paymentType   The type of the payment
	 */
	public Payment(LocalDate paymentDate, int guestID, double paymentAmount, String paymentType) {
		this.paymentDate = paymentDate;
		this.guestID = guestID;
		this.paymentAmount = paymentAmount;
		this.paymentType = paymentType;
	}

	/**
	 * Constructor for the payment class, takes the variables and initialises them.
	 * This constructor takes string variables and converts them all to the correct
	 * data type
	 * 
	 * @param paymentDate The date the payment was made
	 * @param guestID The guestID of the guest who made the payment
	 * @param paymentAmount The amount of the payment
	 * @param paymentType The type of the payment
	 */
	public Payment(String paymentDate, String guestID, String paymentAmount, String paymentType) {
		this.paymentDate = LocalDate.parse(paymentDate);
		this.guestID = Integer.parseInt(guestID);
		this.paymentAmount = Double.parseDouble(paymentAmount);
		this.paymentType = paymentType;
	}

	/**
	 * Getter method for the payment date for the payment
	 * 
	 * @return paymentDate of the payment
	 */
	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	/**
	 * Getter method for the guestID for the payment
	 * 
	 * @return guestID of the payment
	 */
	public int getPaymentGuestID() {
		return guestID;
	}

	/**
	 * @return the string representation of the payment object
	 */
	public String toString() {
		return paymentDate + "," + guestID + "," + paymentAmount + "," + paymentType;
	}

}