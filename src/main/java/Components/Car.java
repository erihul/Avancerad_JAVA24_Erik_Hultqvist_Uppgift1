package Components;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Car extends Vehicle implements Rentable {

    int seats;

    public Car(String vehicleModel, String regNumber, int rentPricePerDay, int seats) {
        super(vehicleModel, regNumber, rentPricePerDay);
        this.seats = 5;
    }

    @Override
    public String toString() {
        return vehicleModel + " | Registration Number = " + regNumber + " | Rental Price Per Day = " + rentPricePerDay + " SEK" + " | Number of Seats = " + seats;
    }

    @Override
    public int rentVehicle(ArrayList<Vehicle> vehicles, ArrayList<Vehicle> rentedVehicles) {
        Vehicle rentedVehicle = vehicles.get(0); // Gets the first vehicle
        rentedVehicles.add(rentedVehicle); // Adds it to rented vehicles
        int rentalCost = calculatedRent();
        System.out.println("\nVehicle rented: " + rentedVehicle);
        System.out.println("Rental Cost: " + rentalCost + "\n");

        return rentalCost;
    }

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