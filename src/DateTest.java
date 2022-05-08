import java.util.Calendar;
import java.util.Locale;

public class DateTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, 8-1, 5);
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(i);
        String displayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()).toUpperCase();
        System.out.println(displayName);
    }
}
