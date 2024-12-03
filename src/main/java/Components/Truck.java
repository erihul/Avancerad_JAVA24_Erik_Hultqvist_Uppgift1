package Components;

public class Truck extends Vehicle implements Rentable{
    int cargoSpace;

    public Truck(String vehicleModel, String regNumber, int rentPricePerDay, int cargoSpace) {
        super(vehicleModel, regNumber, rentPricePerDay);
        this.cargoSpace = 15;
    }

    @Override
    public void rentVehicle() {

    }

    @Override
    public void returnVehicle() {

    }

    @Override
    public void calculatedRent() {

    }
}
