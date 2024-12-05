package Components;

import java.util.ArrayList;
// The interface Rentable contains of three methods
public interface Rentable {
    // the method used when renting a vehicle
    int rentVehicle(ArrayList<Vehicle> vehicles, ArrayList<Vehicle> rentedVehicles);
    // Method for calculating the cost
    int calculatedRent();
    // Method for returning a vehicle, removing it from rentedVehicles(ArrayList)
    default void returnVehicle(ArrayList<Vehicle> rentedVehicles) {
        rentedVehicles.remove(0);
    }

}




