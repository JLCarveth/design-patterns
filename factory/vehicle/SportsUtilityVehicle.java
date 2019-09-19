package factory.vehicle;

public class SportsUtilityVehicle implements Vehicle {
    private double speed;

    public SportsUtilityVehicle () {
        speed = 100.5;
    }

    public void drive() {
        System.out.println();
    }

    public double getSpeed() { return speed; }
}