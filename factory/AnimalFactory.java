package factory;

import factory.animal.Animal;
import factory.animal.Cat;
import factory.animal.Dog;

public class AnimalFactory implements AbstractFactory<Animal> {
    private int state = 1;
    public Animal create() {
        switch(state) {
            case 0:
                return new Dog();
            case 2:
                return new Cat();
            default:
                return new Dog();
        }
    }
}