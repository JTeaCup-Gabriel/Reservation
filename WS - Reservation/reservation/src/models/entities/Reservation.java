package models.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;

	// ------------------------------------------------------------------------ >
	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	// ------------------------------------------------------------------------ >
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	// ------------------------------------------------------------------------ >

	public long duration() {

		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	public void updateDates(Date checkin, Date checkout) {

		this.checkin = checkin;
		this.checkout = checkout;

	}

	// ------------------------------------------------------------------------ >
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Room " + roomNumber);
		sb.append(", check-in: " + sdf.format(checkin));
		sb.append(", check-out: " + sdf.format(checkout));
		sb.append(", " + duration());
		sb.append(" nights" + "\n");

		return sb.toString();
	}

}