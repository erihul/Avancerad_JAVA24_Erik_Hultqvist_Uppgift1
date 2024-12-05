package Components;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Truck extends Vehicle implements Rentable{
    // Truck class has a unique attribute in: Cargo space
    int cargoSpace;
    // The Truck constructor gets it super attributes from Vehicle and its own unique attribute
    public Truck(String vehicleModel, String regNumber, int rentPricePerDay, int cargoSpace) {
        super(vehicleModel, regNumber, rentPricePerDay);
        this.cargoSpace = 15;
    }
    // Overriding toString to make the Truck print out as wanted
    @Override
    public String toString() {
        return vehicleModel + " | Registration Number = " + regNumber + " | Rental Price Per Day = " + rentPricePerDay + " SEK" + " | Cargo Space = " + cargoSpace + " m3";
    }
    // Overriding rentVehicle
    @Override
    public int rentVehicle(ArrayList<Vehicle> vehicles, ArrayList<Vehicle> rentedVehicles) {
        // Gets the "third" vehicle in Arraylist vehicles and creates an object of it called rentedVehicle
        Vehicle rentedVehicle = vehicles.get(2);
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
