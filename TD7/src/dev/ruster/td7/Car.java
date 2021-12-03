package dev.ruster.td7;

public class Car {

    private String name;
    private int posistion = 0;
    private int speed;
    private boolean sens = true;

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
        return name.charAt(0) + " :\n" + " ".repeat(posistion) + (sens ? "»" : "«");
    }

    public boolean exceeds(int limit) {
        return posistion >= limit;
    }

    public void stepForward() {
        posistion += speed;
    }

    public void start() {
        setPosition(0);
    }

    public void turnDown() {
        setSpeed(-speed);
        setSens(!sens);
    }

    private void setSens(boolean sens) {
        this.sens = sens;
    }

    private void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return posistion;
    }

    public void setPosition(int position) {
        this.posistion = position;
    }

    public boolean isReversed() {
        return !sens;
    }
}