package Components;

public abstract class Vehicle {

    String vehicleModel;
    String regNumber;
    int rentPricePerDay;

    public Vehicle(String vehicleModel, String regNumber, int rentPricePerDay) {
        this.vehicleModel = vehicleModel;
        this.regNumber = regNumber;
        this.rentPricePerDay = rentPricePerDay;
    }
}
