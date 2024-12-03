package Components;

public class Convertible extends Vehicle implements Rentable{
    boolean softTop;

    public Convertible(String vehicleModel, String regNumber, int rentPricePerDay, boolean softTop) {
        super(vehicleModel, regNumber, rentPricePerDay);
        this.softTop = true;
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
