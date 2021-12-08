package dev.ruster.td7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Race {

    private List<Car> cars = new ArrayList<>();
    private int length;
    private int roundCount;

    public Race(int length, int roundCount, Car... cars) {
        if(length <= 0) {
            throw new IllegalArgumentException("La longueur de la piste doit être positive");
        }
        Collections.addAll(this.cars, cars);
        this.length = length;
        this.roundCount = roundCount;
    }

    @Override
    public String toString() {
        List<String> lines = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        cars.forEach(c -> lines.add(c.position() + " ".repeat(Math.max(0, length - c.getPosition())) + "|" + "\n"));
        lines.forEach(sb::append);
        return sb.toString();
    }

    public void play() {
        Random r = new Random();
        boolean isPlaying = true;

        while(isPlaying) {
            Util.sleep(250);

            for(int i = 0; i < cars.size(); i++) {
                Car c = cars.get(i);

                c.stepForward();
                System.out.println(this);

                if(c.getRound() == roundCount + 1) {
                    isPlaying = false;
                }
                if(c.isReversed() && c.getPosition() <= 0) {
                    c.round();
                }
                if(!c.isReversed() && c.getPosition() >= length || c.isReversed() && c.getPosition() <= 0) {
                    c.turnDown();
                }
                /*if(r.nextInt(cars.size()) == i) {
                    c.stepForward();
                }*/
            }
        }

        cars.forEach(c -> c.setRound(0));
        System.out.println("Fini !");
    }
}