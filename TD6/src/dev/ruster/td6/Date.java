package dev.ruster.td6;

import com.codepoetics.protonpack.StreamUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Date {

    private static final String[] days = {
            "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"
    };

    private static final String[] months = {
            "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"
    };

    private final int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private Integer day;
    private Integer month;
    private Integer year;

    public Date(int day, int month, int year) {
        this.year = year;
        daysPerMonth[1] = isBissextile() ? 29 : 28;

        if(month <= 0 || month > 12) {
            throw new IllegalArgumentException("Le mois de la date est invalide");
        }
        if(day <= 0 || day > daysPerMonth[month - 1]) {
            throw new IllegalArgumentException("Le jour de la date est invalide");
        }
        this.day = day;
        this.month = month;
    }

    @Contract(pure = true)
    public Date(@NotNull String date) {
        if(!date.contains("/") || !Util.hasRightDateFormat(date)) {
            throw new IllegalArgumentException("Mauvais format de date");
        }
        String[] content = date.split("/");

        StreamUtils.zipWithIndex(Arrays.stream(content))
                .filter(c -> c.getValue().length() != (c.getIndex() == content.length - 1 ? 4 : 2))
                .forEach(c -> {
                    throw new IllegalArgumentException("Mauvais format de date");
                });
        day = Integer.parseInt(content[0].trim());
        month = Integer.parseInt(content[1].trim());
        year = Integer.parseInt(content[2].trim());

        daysPerMonth[1] = isBissextile() ? 29 : 28;

        if(month <= 0 || month > 12) {
            throw new IllegalArgumentException("Le mois de la date est invalide");
        }
        if(day <= 0 || day > daysPerMonth[month - 1]) {
            throw new IllegalArgumentException("Le jour de la date est invalide");
        }
    }

    public Date tomorrow() {
        int day = getDay();
        int month = getMonth();
        int year = getYear();

        if(day + 1 > (daysPerMonth[month - 1])) {
            if(month + 1 > 12) {
                month = 1;
                year++;
            } else {
                month++;
            }
            day = 1;
        } else {
            day++;
        }
        return new Date(day, month, year);
    }





    public boolean isAfter(@NotNull Date date) {
        boolean isAfter = true;

        if(year <= date.getYear()) {
            if(month <= date.getYear()) {
                if(day <= date.getDay()) {
                    isAfter = false;
                }
            }
        }
        return isAfter;
    }

    public boolean isBefore(@NotNull Date date) {
        return date.isAfter(this);
    }

    public boolean isEquals(@NotNull Date date) {
        return day.equals(date.day) && month.equals(date.month) && year.equals(date.year);
    }

    public int daysBetween(@NotNull Date date) {
        int dYear = isBefore(date) ? date.year - year : year - date.year;
        int dMonth = date.month > month ? date.month - month : month - date.month;
        int dDay = date.day > day ? date.day - day : day - date.day;

        return dYear * (isBissextile() ? 366 : 365) + dMonth * daysPerMonth[month - 1] + dDay;
    }

    public boolean isBissextile() {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public void display(boolean full) {
        if(full) {
            System.out.println(day + " " + Util.firstLetterCapital(months[month - 1]) + " " + year);
        } else {
            System.out.println(
                    "0".repeat(2 - day.toString().length()) + day + "/" +
                            "0".repeat(2 - month.toString().length()) + month + "/" +
                            "0".repeat(4 - year.toString().length()) + year
            );
        }
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}