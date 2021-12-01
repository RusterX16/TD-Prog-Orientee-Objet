package dev.ruster.td7;

public final class Main {

    public static void main(String[] args) {
        Car car = new Car("Vroum vroum", 2);
        Car car2 = new Car("Zebiiii", 2);
        Car car3 = new Car("GitHub", 2);
        Car car4 = new Car("PornHub", 2);

        car.setPosition(12);
        car2.setPosition(8);
        car3.setPosition(95);
        car4.setPosition(33);

        System.out.println(car.position());
        System.out.println(car2.position());
        System.out.println(car3.position());
        System.out.println(car4.position());
    }
}