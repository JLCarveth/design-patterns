package factory;

import factory.vehicle.*;

public class VehicleFactory implements AbstractFactory<Vehicle> {
    /**
     * A simple criteria to decide which vehicle to construct.
     */
    private int state = 0;
    public Vehicle create() {
        switch(state) {
            case 0:
                return new Sedan();
            case 1:
                return new SportsUtilityVehicle();
            default:
                return new Sedan();
        }
    }
}