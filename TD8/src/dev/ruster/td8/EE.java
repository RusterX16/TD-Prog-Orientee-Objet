package dev.ruster.td8;

import com.codepoetics.protonpack.StreamUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class EE {

    private int[] set;
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

        StreamUtils.zipWithIndex(Arrays.stream(content)).forEach(e -> this.set[(int) e.getIndex()] = Integer.parseInt(e.getValue()));
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
                .forEach(i -> lines.add(set[i] + ", "));
        lines.forEach(sb::append);
        sb.delete(sb.length() - 2, sb.length()).append("}.").append(cardinal);

        return sb.toString();
    }

    public int indexOf(int n) {
        return IntStream.range(0, set.length).filter(i -> set[i] == n).findFirst().orElse(-1);
    }

    public boolean contains(int n) {
        return Arrays.stream(set).anyMatch(e -> e == n);
    }

    private void add(int n) {
        if(!contains(n)) {
            set[cardinal] = n;
            cardinal++;
        }
    }

    private int remove(int n) {
        if(contains(n)) {
            set[indexOf(n)] = 0;
        }
        return n;
    }

    public boolean isEmpty() {
        return cardinal == 0;
    }

    public boolean overflow() {
        return cardinal > set.length;
    }

    public int addElement(int n) {
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

    public boolean removeElement(int n) {
        if(contains(n)) {
            set[indexOf(n)] = 0;
            return true;
        }
        return false;
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