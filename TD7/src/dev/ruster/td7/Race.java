package dev.ruster.td7;

import org.jetbrains.annotations.NotNull;

public class Race {

    private Car car1;
    private Car car2;
    private int length;

    public Race(@NotNull Car car1, @NotNull Car car2, int length) {
        this.car1 = car1;
        this.car2 = car2;
        this.length = length;
        car1.start();
        car2.start();
    }

    @Override
    public String toString() {
        return car1.position() + " ".repeat(Math.max(0, length - Math.max(0, car1.getPosition()))) + (car1.getPosition() != length - 1 ? "|" : "") + "\n" +
                car2.position() + " ".repeat(Math.max(0, length - Math.max(0, car2.getPosition()))) + (car2.getPosition() != length - 1 ? "|" : "");
    }

    public void play() {
        while(!car1.isReversed() && car1.getPosition() >= 0 || !car2.isReversed() && car2.getPosition() >= 0) {
            car1.stepForward();
            car2.stepForward();
            System.out.println(this);

            if(car1.getPosition() >= length) {
                car1.turnDown();
            }
            if(car2.getPosition() >= length) {
                car2.turnDown();
            }
            Util.sleep(1000);
        }

        if(car1.getPosition() == car2.getPosition()) {
            System.out.println("Egalité !");
        } else if(car1.getPosition() > car2.getPosition()) {
            System.out.println(car1.getName() + " a gagné la course !");
        } else {
            System.out.println(car2.getName() + " a gagné la course !");
        }
    }
}