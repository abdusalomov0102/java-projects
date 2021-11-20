package uz.java;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalendarHappyDay {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year : ");
        int year = scanner.nextInt();
        Calendar calendar = new GregorianCalendar();
        calendar.set(year, 0, 1);
        int work = 0, week = 0, happy = 0;

        while (calendar.get(Calendar.YEAR) == year) {

            if (calendar.get(Calendar.DAY_OF_YEAR) == 1 || calendar.get(Calendar.DAY_OF_YEAR) == 68 ||
                    calendar.get(Calendar.DAY_OF_YEAR) == 81 || calendar.get(Calendar.DAY_OF_YEAR) == 130 ||
                    calendar.get(Calendar.DAY_OF_YEAR) == 244 || calendar.get(Calendar.DAY_OF_YEAR) == 342 ||
                    calendar.get(Calendar.DAY_OF_YEAR) == 366) {
                happy++;
            } else if (calendar.get(Calendar.DAY_OF_WEEK) == 7 || calendar.get(Calendar.DAY_OF_WEEK) == 1) {
                week++;
            } else {
                work++;
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);

        }

        System.out.println("Work day : " + work);
        System.out.println("Week day : " + week);
        System.out.println("Celebration day : " + happy);

    }
}
