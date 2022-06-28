package Localization;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class LocalExample {
    public static void main(String[] args) {
        long num = 5000000;
        NumberFormat numberFormat = NumberFormat.getInstance();
        System.out.println(numberFormat.format(num));

        NumberFormat numberFormatLocal = NumberFormat.getInstance(Locale.ITALY);
        System.out.println(numberFormatLocal.format(num));

        NumberFormat currencyFormatLocal = NumberFormat.getCurrencyInstance(Locale.UK);
        System.out.println(currencyFormatLocal.format(num));

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.GERMANY);
        System.out.println(dateFormat.format(new Date()));

        NumberFormat currencyCode = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(currencyCode.getCurrency() + " " + currencyCode.getCurrency().getDisplayName());

//        System.out.println(num + " is of type " + ((Object)num).getClass().getSimpleName());
    }
}
