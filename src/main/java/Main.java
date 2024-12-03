import Components.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Object> vehicles = new ArrayList<>();
        vehicles.add(new Car("Car", "ABC123",1000, 5));
        vehicles.add(new SUV("SUV", "DEF456",1500, true));
        vehicles.add(new Truck("Truck", "GHI789",2000, 15));
        vehicles.add(new Convertible("Convertible", "JKL012", 1800, true));

        ArrayList<Object> rentedVehicles = new ArrayList<>();

        User user1 = new User(0);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;


        while (running) {
        System.out.println("User Menu");
        System.out.println("1. Rent a vehicle");
        System.out.println("2. Return a vehicle");
        System.out.println("3. Current rental cost");
        System.out.println("4. Exit");

        int menuChoice = scanner.nextInt();
        scanner.nextLine();
            switch (menuChoice) {
                case 1:
                    System.out.println("\nVehicles to choose from:");
                    for (int i = 0; i < vehicles.size(); i++) {
                        System.out.println((i + 1) + ". " + vehicles.get(i).getClass().getSimpleName());
                    }
                    System.out.println("5. Back to main menu");

                    int carChoice = scanner.nextInt();
                    scanner.nextLine();
                        switch (carChoice) {
                            case 1:
                                rentedVehicles.add(vehicles.get(0));
                                System.out.println("\n" + "You have rented a " + rentedVehicles.get(0).getClass().getSimpleName());

                            case 5:
                                continue;
                        }

                    /*for (Object vehicleDisplay : vehicles.get(carModel)) {
                        System.out.println(vehicleDisplay + ": " + vehicles());
                    }*/

                case 2:
                    boolean emptyList = rentedVehicles.isEmpty();
                    if (emptyList == false) {
                        System.out.println("Do you wish to return your " + rentedVehicles.get(0).getClass().getSimpleName() + "? (y/n)");

                        String answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("y")) {
                            vehicles.add(rentedVehicles.get(0));
                            System.out.println("You have returned your rented " + rentedVehicles.get(0).getClass().getSimpleName());
                            rentedVehicles.remove(0);
                            break;
                        } else if (answer.equalsIgnoreCase("n")) {
                            break;
                        } else {
                            System.out.println("Invalid choice");
                            break;
                        }
                    } else {
                        System.out.println("You don't have any rented vehicles");
                        break;
                    }

                case 3:
                    System.out.println("Your total cost so far is: " +  +" SEK");

                case 4:
                    running = false;



            }

        }

    }
}