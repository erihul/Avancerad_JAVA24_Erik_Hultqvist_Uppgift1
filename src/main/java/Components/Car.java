package Components;

public class Car extends Vehicle implements Rentable{

    int seats;

    public Car(String vehicleModel, String regNumber, int rentPricePerDay, int seats) {
        super(vehicleModel, regNumber, rentPricePerDay);
        this.seats = 5;
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
