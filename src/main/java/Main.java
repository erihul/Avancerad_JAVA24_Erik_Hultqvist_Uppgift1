import Components.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("- Welcome to the Virtual Car Rental service -");
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Car", "ABC123",1000, 5));
        vehicles.add(new SUV("SUV", "DEF456",1500, true));
        vehicles.add(new Truck("Truck", "GHI789",2000, 15));
        vehicles.add(new Convertible("Convertible", "JKL012", 1800, true));

        ArrayList<Vehicle> rentedVehicles = new ArrayList<Vehicle>();

        User user1 = new User(0);

        boolean running = true;


        while (running) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("- Main Menu -");
        System.out.println("1. Rent a Vehicle");
        System.out.println("2. Return a Vehicle");
        System.out.println("3. Calculate Rental Cost");
        System.out.println("4. Exit");

        try {
        int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    boolean alreadyRented = rentedVehicles.isEmpty();
                    if (alreadyRented == true) {
                        System.out.println("\n- Vehicles to choose from -");
                        for (int i = 0; i < vehicles.size(); i++) {
                            System.out.println((i + 1) + ". " + vehicles.get(i).toString());
                        }
                        System.out.println("5. Back to Main Menu");

                        int carChoice = scanner.nextInt();
                        //scanner.nextLine();
                        switch (carChoice) {
                            case 1:
                                Rentable rentableCar = (Rentable) vehicles.get(0); // Get the first vehicle and cast it to Rentable
                                int addableCostCar = rentableCar.rentVehicle(vehicles, rentedVehicles); // Call rentVehicle on the instance
                                user1.addUserBalance(addableCostCar);
                                break;
                            case 2:
                                Rentable rentableSUV = (Rentable) vehicles.get(1); // Get the first vehicle and cast it to Rentable
                                int addableCostSUV = rentableSUV.rentVehicle(vehicles, rentedVehicles); // Call rentVehicle on the instance
                                user1.addUserBalance(addableCostSUV);
                                break;
                            case 3:
                                Rentable rentableTruck = (Rentable) vehicles.get(2); // Get the first vehicle and cast it to Rentable
                                int addableCostTruck = rentableTruck.rentVehicle(vehicles, rentedVehicles); // Call rentVehicle on the instance
                                user1.addUserBalance(addableCostTruck);
                                break;
                            case 4:
                                Rentable rentableConvertible = (Rentable) vehicles.get(3); // Get the first vehicle and cast it to Rentable
                                int addableCostConvertible = rentableConvertible.rentVehicle(vehicles, rentedVehicles); // Call rentVehicle on the instance
                                user1.addUserBalance(addableCostConvertible);
                                break;
                            case 5:
                                break;
                        }
                    } else if (alreadyRented == false) {
                        System.out.println("Sorry. You have to return your rented " + rentedVehicles.get(0).getClass().getSimpleName() + " before you rent another vehicle.");
                    }
                        break;
                case 2:
                    boolean emptyList = rentedVehicles.isEmpty();

                    if (emptyList == false) {
                        System.out.println("Do you wish to return your " + rentedVehicles.get(0).getClass().getSimpleName() + "? (y/n)");

                        String answer = scanner.next();
                        if (answer.equalsIgnoreCase("y")) {
                            System.out.println("You have returned your rented " + rentedVehicles.get(0).getClass().getSimpleName() + "\n");
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

                case 3:
                    System.out.println("\nVehicles to choose from:");
                    for (int i = 0; i < vehicles.size(); i++) {
                        System.out.println((i + 1) + ". " + vehicles.get(i).toString());
                    }
                    System.out.println("5. Back to Main Menu");
                    int priceChoice = scanner.nextInt();

                    switch (priceChoice) {
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
                case 4:
                    boolean readyForCheckout = rentedVehicles.isEmpty();
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
            } catch (Exception e) {
                System.out.println("Invalid input");
            }

        }
    }
}