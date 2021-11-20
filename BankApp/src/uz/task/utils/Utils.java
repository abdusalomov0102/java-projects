package uz.task.utils;

import java.util.Date;

public class Utils {

    public static String generateId() {
        String Id = "";
        Date date = new Date();
        Id = Id.concat(String.valueOf(date.getTime()));
        Id += Id.substring(6);
        return Id;
    }

    public static String generateINN() {
        String Inn = "";
        Date date = new Date();
        Inn = Inn.concat(String.valueOf(date.getTime()));
        Inn += Inn.substring(4);
        return Inn;
    }

}
