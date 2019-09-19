package factory.animal;

public class Cat implements Animal {
    public void move() {
        System.out.println("The cat is on the prowl.");
    }

    public void feed() {
        System.out.println("The cat wants more food.");
    }
}