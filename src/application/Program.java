package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    SimpleDateFormat dateFt = new SimpleDateFormat("dd/MM/yyyy");


    try {
      System.out.print("Room number: ");
      int numberRoom = scan.nextInt();
      System.out.print("Check-in date (dd/MM/yyyy): ");
      Date checkIn = dateFt.parse(scan.next());
      System.out.print("Check-out date (dd/MM/yyyy): ");
      Date checkOut = dateFt.parse(scan.next());


      Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
      System.out.println("Reservation: " + reservation);

      System.out.println();
      System.out.println("Enter data to update the reservation:");
      System.out.print("Check-in date (dd/MM/yyyy): ");
      checkIn = dateFt.parse(scan.next());
      System.out.print("Check-out date (dd/MM/yyyy): ");
      checkOut = dateFt.parse(scan.next());

      reservation.updateDates(checkIn, checkOut);
      System.out.println("Reservation: " + reservation);
    } catch (DomainException e) {
      System.out.println("Error in reservation: " + e.getMessage());

    } catch (ParseException e) {
      System.out.println("Invalid date format");
      
    } catch (RuntimeException e) {
      System.out.println("Unexpected error!");
    }

    scan.close();

  }
}
