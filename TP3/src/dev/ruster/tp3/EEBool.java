package dev.ruster.tp3;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class EEBool {

    private final boolean[] set;
    private int cardinal;

    public EEBool(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("La taille du tableau ne peut pas être nulle");
        }
        set = new boolean[n];
        cardinal = 0;
    }

    public EEBool(int max, boolean @NotNull [] set) {
        this(max);
        System.arraycopy(set, 0, this.set, 0, set.length);
        cardinal = set.length;
    }

    public EEBool(int max, @NotNull String set) {
        this(max);
        String[] content = set.split(" ");
        cardinal = content.length;

        IntStream.range(0, set.length()).forEach(i -> this.set[i] = Boolean.parseBoolean(content[i]));
    }

    public EEBool(@NotNull EEBool ee) {
        this.set = ee.set;
        cardinal = ee.cardinal;
    }


    @Override
    public String toString() {
        List<String> lines = new ArrayList<>();
        StringBuilder sb = new StringBuilder("{");

        IntStream.range(0, set.length)
                .takeWhile(i -> i < cardinal)
                .forEach(i -> lines.add(set[i] + ", "));
        lines.forEach(sb::append);
        sb.delete(sb.length() - 2, sb.length()).append("}.").append(cardinal);

        return sb.toString();
    }

    public int indexOf(boolean b) {
        return IntStream.range(0, set.length).filter(i -> set[i] == b).findFirst().orElse(-1);
    }

    public boolean contains(boolean b) {
        return IntStream.range(0, set.length).anyMatch(i -> set[i] == b);
    }

    private void add(boolean b) {
        if(!contains(b)) {
            set[cardinal] = b;
            cardinal++;
        }
    }

    private boolean remove(boolean b) {
        if(contains(b)) {
            set[indexOf(b)] = false;
            IntStream.range(indexOf(b), cardinal - 1).forEach(i -> set[i] = set[i - 1]);
        }
        return b;
    }

    public boolean isEmpty() {
        return cardinal == 0;
    }

    public boolean overflow() {
        return cardinal > set.length;
    }

    public int addElement(boolean b) {
        if(overflow()) {
            return -1;
        }
        if(!contains(b)) {
            set[cardinal] = b;
            cardinal++;
            return 1;
        }
        return 0;
    }

    public boolean removeElement(boolean b) {
        if(contains(b)) {
            set[indexOf(b)] = false;
            return true;
        }
        return false;
    }

    public boolean isInclude(@NotNull EEBool ee) {
        return IntStream.range(0, cardinal - 1).allMatch(i -> ee.contains(set[i]));
    }

    public boolean isEquals(@NotNull EEBool ee) {
        return isInclude(ee) && ee.isInclude(this);
    }

    public boolean isDisjointed(@NotNull EEBool ee) {
        return !IntStream.range(0, cardinal - 1).allMatch(i -> ee.contains(set[i]));
    }

    public EEBool intersect(@NotNull EEBool ee) {
        EEBool out = new EEBool(Math.max(set.length, ee.set.length));

        IntStream.range(0, Math.max(cardinal, ee.cardinal))
                .filter(i -> contains(ee.set[i]) && ee.contains(set[i]))
                .forEach(i -> out.add(set[i]));
        return out;
    }

    public EEBool union(@NotNull EEBool ee) {
        EEBool out = new EEBool(Math.max(set.length, ee.set.length));

        IntStream.range(0, Math.max(cardinal, ee.cardinal))
                .forEach(i -> {
                    out.add(set[i]);
                    out.add(ee.set[i]);
                });
        return out;
    }

    public EEBool minus(@NotNull EEBool ee) {
        EEBool out = new EEBool(Math.max(set.length, ee.set.length));

        IntStream.range(0, Math.max(cardinal, ee.cardinal))
                .filter(i -> !ee.contains(set[i]))
                .forEach(i -> out.add(set[i]));
        return out;
    }

    public void display() {
        System.out.println(this);
    }

    public boolean[] getSet() {
        return set;
    }

    public int getCardinal() {
        return cardinal;
    }
}