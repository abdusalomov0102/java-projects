package uz.java;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarDay {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();
        System.out.print("Enter year : ");
        int year = scanner.nextInt();
        calendar.set(year, 0, 1);
        ArrayList<String> happyDay = new ArrayList<>();
        ArrayList<String> weekDay = new ArrayList<>();
        ArrayList<String> workDay = new ArrayList<>();
        int bayram = 0, damolish = 0, ishkun = 0;

        while (calendar.get(Calendar.YEAR) == year) {
            if (year % 4 == 0 || year % 400 == 0 && year % 100 != 0) {
                if (calendar.get(Calendar.DAY_OF_YEAR) == 1 || calendar.get(Calendar.DAY_OF_YEAR) == 366 ||
                        calendar.get(Calendar.DAY_OF_YEAR) == 68 || calendar.get(Calendar.DAY_OF_YEAR) == 81 ||
                        calendar.get(Calendar.DAY_OF_YEAR) == 130 || calendar.get(Calendar.DAY_OF_YEAR) == 244
                        || calendar.get(Calendar.DAY_OF_YEAR) == 343) {
                    weekDay.add(String.valueOf(calendar.getTime()));
                    bayram++;
                } else if (calendar.get(Calendar.DAY_OF_WEEK) == 7 || calendar.get(Calendar.DAY_OF_WEEK) == 1) {
                    happyDay.add(String.valueOf(calendar.getTime()));
                    damolish++;
                } else {
                    workDay.add(String.valueOf(calendar.getTime()));
                    ishkun++;
                }
            } else {
                if (calendar.get(Calendar.DAY_OF_YEAR) == 1 || calendar.get(Calendar.DAY_OF_YEAR) == 365 ||
                        calendar.get(Calendar.DAY_OF_YEAR) == 67 || calendar.get(Calendar.DAY_OF_YEAR) == 80 ||
                        calendar.get(Calendar.DAY_OF_YEAR) == 129 || calendar.get(Calendar.DAY_OF_YEAR) == 243
                        || calendar.get(Calendar.DAY_OF_YEAR) == 342) {
                    weekDay.add(String.valueOf(calendar.getTime()));
                    bayram++;
                } else if (calendar.get(Calendar.DAY_OF_WEEK) == 7 || calendar.get(Calendar.DAY_OF_WEEK) == 1) {
                    happyDay.add(String.valueOf(calendar.getTime()));
                    damolish++;
                } else {
                    workDay.add(String.valueOf(calendar.getTime()));
                    ishkun++;
                }
            }
            calendar.add(Calendar.DATE, 1);
        }

        System.out.println("<=: Shu yilgi dam olish kunlari :=>");
        System.out.println("<=:====================================:=>");
        weekDay.forEach(System.out::println);
        System.out.println("<=:====================================:=>\n");
        System.out.println("\n<=: Shu yilgi ish kunlari :=>");
        workDay.forEach(System.out::println);
        System.out.println("<=:====================================:=>\n");
        System.out.println("\n<=: Shu yilgi bayram kunlari :=>");
        happyDay.forEach(System.out::println);
        System.out.println("<=:====================================:=>\n");
        System.out.println("\nBayram kunlari : " + bayram);
        System.out.println("Ish kunlari : " + ishkun);
        System.out.println("Dam olish kunlari : " + damolish);

    }
}
