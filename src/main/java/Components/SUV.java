package Components;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SUV extends Vehicle implements Rentable{
    // SUV class has a unique attribute that tells if it's an OffRoadVehicle or not
    boolean offRoadVehicle;
    // The SUV constructor gets it super attributes from Vehicle and its own unique attribute
    public SUV(String vehicleModel, String regNumber, int rentPricePerDay, boolean offRoadVehicle) {
        super(vehicleModel, regNumber, rentPricePerDay);
        this.offRoadVehicle = offRoadVehicle;
    }
    // Overriding toString to make the SUV print out as wanted
    @Override
    public String toString() {
        return vehicleModel + " | Registration Number = " + regNumber + " | Rental Price Per Day = " + rentPricePerDay + " SEK" + " | Off Road Vehicle = " + offRoadVehicle;
    }
    // Overriding rentVehicle
    @Override
    public int rentVehicle(ArrayList<Vehicle> vehicles, ArrayList<Vehicle> rentedVehicles) {
        // Gets the "second" vehicle in Arraylist vehicles and creates an object of it called rentedVehicle
        Vehicle rentedVehicle = vehicles.get(1);
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
