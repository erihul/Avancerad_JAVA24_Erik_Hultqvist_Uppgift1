package Components;

public class SUV extends Vehicle implements Rentable{
    boolean offRoadVehicle;

    public SUV(String vehicleModel, String regNumber, int rentPricePerDay, boolean offRoadVehicle) {
        super(vehicleModel, regNumber, rentPricePerDay);
        this.offRoadVehicle = offRoadVehicle;
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
