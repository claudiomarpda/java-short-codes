import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyTest {

    public static void main(String[] args) {
        double payment = 150.123;

        Locale indiaLocale = new Locale("en", "IN");
        Locale franceLocale = new Locale("fr", "FR");

        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String india = NumberFormat.getCurrencyInstance(indiaLocale).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(franceLocale).format(payment);

        Currency currency = NumberFormat.getCurrencyInstance().getCurrency();
        System.out.println(currency);

//        String us2 = NumberFormat.getInstance(Locale.US);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);

    }

}
