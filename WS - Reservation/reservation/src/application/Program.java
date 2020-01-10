package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import models.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// -------------------------------------------------------------------- >
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();

		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());

		// -------------------------------------------------------------------- >

		int cxa = (checkin.after(checkout)) ? 1 : 2;

		switch (cxa) {

		case 1:

			System.out.println("Error in reservation: Check-out date must be after check-in date ");
			break;

		case 2:

			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);

			Date now = new Date();
			System.out.println("Reservations only from this date: " + sdf.format(now));

			System.out.println("Enter data to update the reservation: ");

			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			// -------------------------------------------------------------------- >

			int cxb = (checkin.before(now) || checkout.before(now)) ? 1 : ((checkout.before(checkin)) ? 2 : 3);

			switch (cxb) {

			case 1:

				System.out.println("Error in reservation: Reservation dates for update must be future dates");

				break;

			case 2:

				System.out.println("Error in reservation: Check-out date must be after check-in date");

				break;

			default:

				reservation.updateDates(checkin, checkout);
				System.out.println("Reservation: " + reservation);

				break;

			}

			break;

		}

		// -------------------------------------------------------------------- >
		// -------------------------------------------------------------------- >
		// -------------------------------------------------------------------- >

		sc.close();

	}

}
