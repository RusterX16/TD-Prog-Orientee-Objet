package dev.ruster.td7;

public class Car {

    private String name;
    private int position = 0;
    private int speed;
    private boolean sens = true;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "name = " + name + "\n" +
                "position = " + position + "\n" +
                "speed = " + speed + "\n";
    }

    public String position() {
        return name.charAt(0) + " :\n" + " ".repeat(Math.max(0, position)) + (sens ? "»" : "«");
    }

    public boolean exceeds(int limit) {
        return position >= limit;
    }

    public void stepForward() {
        position += speed;
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
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isReversed() {
        return !sens;
    }
}