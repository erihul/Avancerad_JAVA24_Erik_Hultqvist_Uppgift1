package Components;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Convertible extends Vehicle implements Rentable{
    // Convertible class has a unique attribute in: Soft Top
    boolean softTop;
    // The Convertible constructor gets it super attributes from Vehicle and its own unique attribute
    public Convertible(String vehicleModel, String regNumber, int rentPricePerDay, boolean softTop) {
        super(vehicleModel, regNumber, rentPricePerDay);
        this.softTop = true;
    }
    // Overriding toString to make the Convertible print out as wanted
    @Override
    public String toString() {
        return vehicleModel + " | Registration Number = " + regNumber + " | Rental Price Per Day = " + rentPricePerDay + " SEK" + " | Soft Top = " + softTop;
    }
    // Overriding rentVehicle
    @Override
    public int rentVehicle(ArrayList<Vehicle> vehicles, ArrayList<Vehicle> rentedVehicles) {
        // Gets the "fourth" vehicle in Arraylist vehicles and creates an object of it called rentedVehicle
        Vehicle rentedVehicle = vehicles.get(3);
        // Adds rentedVehicle to the Arraylist rentedVehicle
        rentedVehicles.add(rentedVehicle);
        // Stores the calculatedRent outcome in integer rentalCost
        int rentalCost = calculatedRent();
        // Prints what vehicle was rented
        System.out.println("\nVehicle rented: " + rentedVehicle);
        // Prints the cost
        System.out.println("Rental Cost: " + rentalCost + " SEK\n");
        return rentalCost;
    }
    // Overriding calculatedRent - a method that finds out how many days the user want to rent
    // and multiplies it with the integer rentPricePerDay
    @Override
    public int calculatedRent() {
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        int days = 0;
        while (running == true) {
            System.out.println("How many days would you like to rent the vehicle?");
            try{
                days = scan.nextInt();
                running = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid, Please enter a number.");
                scan.next();
            }
        }
        return rentPricePerDay * days;
    }
}
