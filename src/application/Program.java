package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = input.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(input.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(input.next());
		
		if(checkout.after(checkin)) {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(input.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(input.next());
			
			Date now = new Date();
			if(checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if(checkout.after(checkin)){
				reservation.updateDates(checkin, checkout);
				System.out.println("Reservation: " + reservation);
			}
			else {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
		}
		else {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
				
		input.close();
	}

}
