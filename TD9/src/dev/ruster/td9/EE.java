package dev.ruster.td9;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class EE {

    private final int[] set;
    private int cardinal;

    public EE(int max) {
        if(max < 0) {
            throw new IllegalArgumentException("Le max ne peut pas être nul");
        }
        set = new int[max];
        cardinal = 0;
    }

    public EE(int max, int @NotNull [] set) {
        this(max);
        System.arraycopy(set, 0, this.set, 0, set.length);
        cardinal = set.length;
    }

    public EE(int max, @NotNull String set) {
        this(max);
        String[] content = set.split(" ");
        cardinal = content.length;

        IntStream.range(0, cardinal).forEach(i -> this.set[i] = Integer.parseInt(content[i]));
    }

    public EE(@NotNull EE ee) {
        this.set = ee.set;
        cardinal = ee.cardinal;
    }

    @Override
    public String toString() {
        List<String> lines = new ArrayList<>();
        StringBuilder sb = new StringBuilder("{");

        IntStream.range(0, set.length)
                .takeWhile(i -> i < cardinal)
                .forEach(i -> lines.add(set[i] + i == set.length - 1 ? "" : ", "));
        lines.forEach(sb::append);
        sb.append("}.").append(cardinal);

        return sb.toString();
    }

    public int indexOf(int n) {
        return IntStream.range(0, set.length).filter(i -> set[i] == n).findFirst().orElse(-1);
    }

    public boolean contains(int n) {
        return Arrays.stream(set).anyMatch(e -> e == n);
    }

    private void addUtil(int n) {
        if(!contains(n)) {
            if(overflow()) {
                throw new ArrayIndexOutOfBoundsException("Plus d'espace mémoire disponible dans le tableau");
            }
            set[cardinal] = n;
            cardinal++;
        }
    }

    private int removeUtil(int n) {
        if(contains(n)) {
            IntStream.range(indexOf(n), cardinal).filter(i -> i + 1 != cardinal).forEach(i -> set[i] = set[i + 1]);
            cardinal--;
        }
        return n;
    }

    public boolean isEmpty() {
        return cardinal == 0;
    }

    public boolean overflow() {
        return cardinal > set.length;
    }

    public int add(int n) {
        if(overflow()) {
            return -1;
        }
        if(!contains(n)) {
            set[cardinal] = n;
            cardinal++;
            return 1;
        }
        return 0;
    }

    public boolean remove(int n) {
        if(contains(n)) {
            removeUtil(n);
            return true;
        }
        return false;
    }

    public int removeRandomly() {
        if(cardinal == 0) {
            throw new IllegalArgumentException("Ensemble vide");
        }
        int i = new Random().nextInt(cardinal);
        return removeUtil(i);
    }

    public int select() {
        if(cardinal == 0) {
            throw new IllegalArgumentException("Ensemble vide");
        }
        return set[cardinal - 1];
    }

    public int selectRandomly() {
        if(cardinal == 0) {
            throw new IllegalArgumentException("Ensemble vide");
        }
        return set[new Random().nextInt(cardinal)];
    }

    public boolean isInclude(@NotNull EE ee) {
        return Arrays.stream(set).allMatch(ee::contains);
    }

    public boolean isEquals(@NotNull EE ee) {
        return isInclude(ee) && ee.isInclude(this);
    }

    public boolean isDisjointed(@NotNull EE ee) {
        return !Arrays.stream(set).allMatch(ee::contains);
    }

    public EE intersect(@NotNull EE ee) {
        EE out = new EE(Math.max(set.length, ee.set.length));

        IntStream.range(0, Math.max(cardinal, ee.cardinal))
                .filter(i -> contains(ee.set[i]) && ee.contains(set[i]))
                .forEach(i -> out.add(set[i]));
        return out;
    }

    public EE union(@NotNull EE ee) {
        EE out = new EE(Math.max(set.length, ee.set.length));

        IntStream.range(0, Math.max(cardinal, ee.cardinal))
                .forEach(i -> {
                    out.add(set[i]);
                    out.add(ee.set[i]);
                });
        return out;
    }

    public EE minus(@NotNull EE ee) {
        EE out = new EE(Math.max(set.length, ee.set.length));

        IntStream.range(0, Math.max(cardinal, ee.cardinal))
                .filter(i -> !ee.contains(set[i]))
                .forEach(i -> out.add(set[i]));
        return out;
    }

    public void display() {
        System.out.println(this);
    }

    public int[] getSet() {
        return set;
    }

    public int getCardinal() {
        return cardinal;
    }
}