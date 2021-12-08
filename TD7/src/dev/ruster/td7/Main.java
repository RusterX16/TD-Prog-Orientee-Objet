package dev.ruster.td7;

public final class Main {

    public static void main(String[] args) {
        Car car1 = new Car("Vroum vroum", 2);
        Car car2 = new Car("Zebiiii", 3);
        Car car3 = new Car("La baguette", 2);
        Car car4 = new Car("GitHub", 5);

        Race race = new Race(35, 3, car1, car2, car3, car4);
        race.play();
    }
}