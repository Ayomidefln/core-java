package Localization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateExample {
    public static void main(String[] args) {
        DateFormat dateFormat = DateFormat.getDateInstance
                (DateFormat.LONG, new Locale("de","DE"));
//      Get Time format
        String time = dateFormat.format(new Date());
        System.out.println(time);

//      Get Date format
        String date = dateFormat.format(new Date());
        System.out.println(date);

    }
}
