package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;


public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Room Number");
			int number = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyy)");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out date (dd/MM/yyy)");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			System.out.println("Reservation: " + reservation);
		} catch (ParseException error) {
			System.out.println("Invalid date format");
		} catch (DomainException error) {
			System.out.println("Erro in reservation: " + error.getMessage());
		}catch (RunTimeException error) {
			System.out.println("Unexpected Error");
		}
		sc.close();
	}
}
