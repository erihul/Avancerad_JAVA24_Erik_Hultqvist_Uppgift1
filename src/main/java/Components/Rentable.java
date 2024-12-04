package Components;

import java.util.ArrayList;

public interface Rentable {
    int rentVehicle(ArrayList<Vehicle> vehicles, ArrayList<Vehicle> rentedVehicles);

    int calculatedRent();

    default void returnVehicle(ArrayList<Vehicle> rentedVehicles) {
        rentedVehicles.remove(0);
    }

}




