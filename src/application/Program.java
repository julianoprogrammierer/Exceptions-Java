package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {
  public static void main(String[] args) throws ParseException {
    Scanner scan = new Scanner(System.in);
    SimpleDateFormat dateFt = new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("Room number: ");
    int numberRoom = scan.nextInt();

    System.out.print("Check-in date (dd/MM/yyyy): ");
    Date checkIn = dateFt.parse(scan.next());

    System.out.print("Check-out date (dd/MM/yyyy): ");
    Date checkOut = dateFt.parse(scan.next());

    if (!checkOut.after(checkIn)) {
      System.out.println("Error in reservation:" +
              " Check-out date must be after check-in date");
    } else {
      Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
      System.out.println("Reservation: " + reservation);

      System.out.println();
      System.out.println("Enter data to update the reservation:");

      System.out.print("Check-in date (dd/MM/yyyy): ");
      checkIn = dateFt.parse(scan.next());

      System.out.print("Check-out date (dd/MM/yyyy): ");
      checkOut = dateFt.parse(scan.next());


      String error = reservation.updateDates(checkIn, checkOut);
      if (error != null) {
        System.out.println("Error in reservation: " + error);
      } else {
        System.out.println("Reservation: " + reservation);
      }
    }

    scan.close();

  }
}
