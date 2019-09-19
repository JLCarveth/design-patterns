package factory;

/**
 * Provides the correct Factory subclass based on input
 */
public class FactoryProvider {
    public AbstractFactory create(String factoryType) {
        switch(factoryType) {
            case "Animal":
                return new AnimalFactory();
            case "Vehicle":
                return new VehicleFactory();
            default:
                return new AnimalFactory();
        }
    }
}