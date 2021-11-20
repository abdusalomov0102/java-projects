package uz.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarDayOfWeeks {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.print("Enter date : ");
        String sana = scanner.nextLine();
        Date date = null;
        try {
            date = dateFormat.parse(sana);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("US")));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dateFormat.format(date));

    }
}
