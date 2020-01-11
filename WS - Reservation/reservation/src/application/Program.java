package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// -------------------------------------------------------------------- >
		try {

			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());

			Reservation reservation = new Reservation(roomNumber, checkin, checkout);

			System.out.println("Reservation: " + reservation);
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			// -------------------------------------------------------------------- >

			reservation.updateDates(checkin, checkout);

			System.out.println("Reservation: " + reservation);

			// -------------------------------------------------------------------- >
		} catch (ParseException e) {
			System.out.println("Invalid Date Format");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}

		finally {

			sc.close();
		}

	}

}
