import Components.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // The opening message in menu file, displayed once
        System.out.println("- Welcome to the Virtual Car Rental service -");
        // Creating an arraylist and adding the 4 different vehicles to it
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Car", "ABC123",1000, 5));
        vehicles.add(new SUV("SUV", "DEF456",1500, true));
        vehicles.add(new Truck("Truck", "GHI789",2000, 15));
        vehicles.add(new Convertible("Convertible", "JKL012", 1800, true));
        // Creating an arraylist so that the vehicles that´s rented can be added to it and returned from it.
        ArrayList<Vehicle> rentedVehicles = new ArrayList<Vehicle>();
        //user1 is the object that´s gonna keep track of what the total cost for renting will be.
        User user1 = new User(0);
        // The While-loop is the "main-loop" that prints out options for main-menu when going back or finishes a chosen option.
        boolean running = true;
        while (running) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("- Main Menu -");
        System.out.println("1. Rent a Vehicle");
        System.out.println("2. Return a Vehicle");
        System.out.println("3. Calculate Rental Cost");
        System.out.println("4. Exit");
        // Try/Catch for being able to print out "invalid" if user doesn't choose from list.
        try {
        int menuChoice = scanner.nextInt();
            // A switch statement that holds the options from Main Menu.
            switch (menuChoice) {
                // Case one - Rent a Vehicle
                case 1:
                    // A condition so that the user can't rent a vehicle if not yet returned what's rented.
                    boolean alreadyRented = rentedVehicles.isEmpty();
                    // If user is able to rent, a menu of vehicle-options will print.
                    if (alreadyRented == true) {
                        System.out.println("\n- Vehicles to choose from -");
                        for (int i = 0; i < vehicles.size(); i++) {
                            System.out.println((i + 1) + ". " + vehicles.get(i).toString());
                        }
                        System.out.println("5. Back to Main Menu");
                        // The user-choice will be treated in a switch-statement.
                        int carChoice = scanner.nextInt();
                        //scanner.nextLine();
                        switch (carChoice) {
                            // Each case retrieves its vehicle to Rentable, then calls rentVehicle on the instance
                            // and at last adds the cost to Users balance.
                            case 1:
                                Rentable rentableCar = (Rentable) vehicles.get(0);
                                int addableCostCar = rentableCar.rentVehicle(vehicles, rentedVehicles);
                                user1.addUserBalance(addableCostCar);
                                break;
                            case 2:
                                Rentable rentableSUV = (Rentable) vehicles.get(1);
                                int addableCostSUV = rentableSUV.rentVehicle(vehicles, rentedVehicles);
                                user1.addUserBalance(addableCostSUV);
                                break;
                            case 3:
                                Rentable rentableTruck = (Rentable) vehicles.get(2);
                                int addableCostTruck = rentableTruck.rentVehicle(vehicles, rentedVehicles);
                                user1.addUserBalance(addableCostTruck);
                                break;
                            case 4:
                                Rentable rentableConvertible = (Rentable) vehicles.get(3);
                                int addableCostConvertible = rentableConvertible.rentVehicle(vehicles, rentedVehicles);
                                user1.addUserBalance(addableCostConvertible);
                                break;
                            case 5:
                                break;
                        }
                    // The -if statement that urges the user to return a rented vehicle before renting another one.
                    } else if (alreadyRented == false) {
                        System.out.println("Sorry. You have to return your rented " + rentedVehicles.get(0).getClass().getSimpleName() + " before you rent another vehicle.");
                    }
                        break;
                // Case two - Return a Vehicle
                case 2:
                    boolean emptyList = rentedVehicles.isEmpty();
                    // If statement that catches if the user have a rented car to return
                    if (emptyList == false) {
                        System.out.println("Do you wish to return your " + rentedVehicles.get(0).getClass().getSimpleName() + "? (y/n)");
                        String answer = scanner.next();
                        // If statements, the user chooses to return or not.
                        if (answer.equalsIgnoreCase("y")) {
                            System.out.println("You have returned your rented " + rentedVehicles.get(0).getClass().getSimpleName() + "\n");
                            // Retrieves the rented vehicle and calls returnVehicle
                            Rentable rentable = (Rentable) rentedVehicles.get(0);
                            rentable.returnVehicle(rentedVehicles);
                            break;
                        } else if (answer.equalsIgnoreCase("n")) {
                            break;
                        } else {
                            System.out.println("Invalid choice");
                            break;
                        }
                    } else {
                        System.out.println("\nYou don't have any rented vehicle to return");
                        break;
                    }
                // Case three - Calculate Rental Cost
                case 3:
                    // Prints out the vehicle-menu
                    System.out.println("\nVehicles to choose from:");
                    for (int i = 0; i < vehicles.size(); i++) {
                        System.out.println((i + 1) + ". " + vehicles.get(i).toString());
                    }
                    System.out.println("5. Back to Main Menu");
                    int priceChoice = scanner.nextInt();
                    // Switch statement to handle the user-chosen vehicle
                    switch (priceChoice) {
                        // Each case creates an object and runs method calculatedRent, then prints it out.
                        case 1:
                            Car car = (Car) vehicles.get(0);
                            int calculatedCost = car.calculatedRent();
                            System.out.println("\nThe price is: " + calculatedCost + " SEK");
                            break;
                        case 2:
                            SUV suv = (SUV) vehicles.get(1);
                            int calculatedCost2 = suv.calculatedRent();
                            System.out.println("\nThe price is: " + calculatedCost2 + " SEK");
                            break;
                        case 3:
                            Truck truck = (Truck) vehicles.get(2);
                            int calculatedCost3 = truck.calculatedRent();
                            System.out.println("\nThe price is: " + calculatedCost3 + " SEK");
                            break;
                        case 4:
                            Convertible convertible = (Convertible) vehicles.get(3);
                            int calculatedCost4 = convertible.calculatedRent();
                            System.out.println("\nThe price is: " + calculatedCost4 + " SEK");
                            break;
                        case 5:
                            break;
                    }
                    break;
                // Case four - Exit
                case 4:
                    // If-statement to make sure the user have returned their vehicle.
                    boolean readyForCheckout = rentedVehicles.isEmpty();
                    // If allowed the user gets a goodbye and given the total cost of renting.
                    if (readyForCheckout == true) {
                        System.out.println("\nThank you for renting at our company!");
                        System.out.println("The total cost is: " + user1.getUserBalance() + " SEK");
                        System.out.println("\nHave a nice day!");
                        running = false;
                    } else {
                        System.out.println("\nSorry. You have not returned your rented car yet.");
                    }
                    break;
                    }
            // The first Try/Catch if the user typed a char instead of an int in Main-Menu.
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }
}