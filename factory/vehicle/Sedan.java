package factory.vehicle;

public class Sedan implements Vehicle {
    private double speed;


    public Sedan () {
        speed = 125.0;
    }

    public void drive() {
        System.out.println("Sedan is driving at " + this.getSpeed() + "km/h");
    }

    public double getSpeed() { return speed; }

}