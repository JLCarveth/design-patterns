package factory.animal;

public class Dog implements Animal {
    public void move() {
        System.out.println("The dog moves.");
    }

    public void feed() {
        System.out.println("The dog enjoys the food.");
    }
}