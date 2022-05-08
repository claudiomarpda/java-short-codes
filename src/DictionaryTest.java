import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class DictionaryTest {

    public static void main(String[] args) {

    }

        /*List<String> magazine = Arrays.asList("give", "me", "one", "grand", "today", "night");
        List<String> note = Arrays.asList("give", "one", "grand", "today");
        //        List<String> magazine = Arrays.asList("two", "times", "three", "is", "not", "four");
    //        List<String> note = Arrays.asList("two", "times", "two", "is" ,"four");
        checkMagazine(magazine, note);*/
    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        Map<String, Integer> magazineMap = mapFrequency(magazine);
        Map<String, Integer> noteMap = mapFrequency(note);

        for (Map.Entry<String, Integer> n : noteMap.entrySet()) {
            if (n.getValue() > magazineMap.getOrDefault(n.getKey(), 0)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes" );
    }

    static Map<String, Integer> mapFrequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        list.forEach(key -> {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        });
        return map;
    }

}
