package dev.ruster.td7;

public class Race {

    private Car car1;
    private Car car2;
    private int length;

    public Race(Car car1, Car car2, int length) {
        if(length <= 0) {
            throw new IllegalArgumentException("La longueur de la piste doit être positive");
        }
        this.car1 = car1;
        this.car2 = car2;
        this.length = length;
    }

    @Override
    public String toString() {
        return car1.position() + " ".repeat(Math.max(0, length - car1.getPosition())) + "|" + "\n" +
                car2.position() + " ".repeat(Math.max(0, length - car2.getPosition())) + "|" + "\n";
    }

    public void play() {
        while(!car1.isReversed() && car1.getPosition() >= 0 || car2.isReversed() && car2.getPosition() >= 0) {
            Util.sleep(500);

            if(car1.getPosition() >= length) {
                car1.turnDown();
            }
            if(car2.getPosition() >= length) {
                car2.turnDown();
            }

            car1.stepForward();
            car2.stepForward();
            System.out.println(this);
            Util.ln(4);
        }

        if(car1.getPosition() > car2.getPosition()) {
            System.out.println(car1.getName() + " a gagné la course !");
        } else if(car1.getPosition() < car2.getPosition()) {
            System.out.println(car2.getName() + " a gagné la course !");
        } else {
            System.out.println("Egalité !");
        }
    }
}