package dev.ruster.td7;

public final class Main {

    public static void main(String[] args) {
        Car car = new Car("Vroum vroum", 2);
        Car car2 = new Car("Zebiiii", 2);
        Car car3 = new Car("GitHub", 2);
        Car car4 = new Car("PornHub", 3);

        Race race = new Race(car, car2, 35);
        race.play();
    }
}