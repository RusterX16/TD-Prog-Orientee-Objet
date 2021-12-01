package dev.ruster.td7;

public class Car {

    private String name;
    private int posistion = 0;
    private int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "name = " + name + "\n" +
                "position = " + posistion + "\n" +
                "speed = " + speed + "\n";
    }

    public String position() {
        return name.charAt(0) + " :\n" + " ".repeat(posistion) + "»";
    }

    public void setPosition(int position) {
        this.posistion = position;
    }

    public String getName() {
        return name;
    }
}