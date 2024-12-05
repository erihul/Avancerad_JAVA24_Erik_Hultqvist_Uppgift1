package Components;
// The abstract class, for all the sub-vehicle-classes
public abstract class Vehicle {
    // Contains three attributes
    String vehicleModel;
    String regNumber;
    int rentPricePerDay;

    public Vehicle(String vehicleModel, String regNumber, int rentPricePerDay) {
        this.vehicleModel = vehicleModel;
        this.regNumber = regNumber;
        this.rentPricePerDay = rentPricePerDay;
    }
}
