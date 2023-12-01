package lb10_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CalendarDate implements Comparable<CalendarDate> {
    private int year;
    private int month;
    private int day;

    public CalendarDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return String.format("%d/%02d/%02d", year, month, day);
    }

    @Override
    public int compareTo(CalendarDate otherDate) {
        if (this.year != otherDate.year) {
            return Integer.compare(this.year, otherDate.year);
        } else if (this.month != otherDate.month) {
            return Integer.compare(this.month, otherDate.month);
        } else {
            return Integer.compare(this.day, otherDate.day);
        }
    }

    public static void main(String[] args) {
        List<CalendarDate> dateList = new ArrayList<>();

        // Додаємо об'єкти CalendarDate
        dateList.add(new CalendarDate(2023, 12, 1));
        dateList.add(new CalendarDate(2023, 11, 30));
        dateList.add(new CalendarDate(2023, 12, 15));

        // Сортуємо за зростанням
        Collections.sort(dateList);

        // Виводимо вміст списку за допомогою ітератора
        System.out.println("Сортування за зростанням:");
        Iterator<CalendarDate> ascendingIterator = dateList.iterator();
        while (ascendingIterator.hasNext()) {
            System.out.println(ascendingIterator.next());
        }

        // Сортуємо за спаданням
        Collections.reverse(dateList);

        // Виводимо вміст списку за допомогою ітератора
        System.out.println("\nСортування за спаданням:");
        Iterator<CalendarDate> descendingIterator = dateList.iterator();
        while (descendingIterator.hasNext()) {
            System.out.println(descendingIterator.next());
        }
    }
}
