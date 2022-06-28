package Localization;


import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormat {
    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.
                getCurrencyInstance(new Locale("de","DE"));

        String currency = numberFormat.format(100000000);
        System.out.println(currency);
    }
}
