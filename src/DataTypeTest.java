import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class DataTypeTest {


    public static void main(String[] args) {
        isAnagram("anagram", "margana");
    }

//    String s1 = "anagram";
//    String s2 = "margana";
//    System.out.println(isAnagram(s1, s2));
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Integer> map1 = getFrequency(a);
        Map<Character, Integer> map2 = getFrequency(b);

//        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
//            Integer value2 = map2.get(entry.getKey());
//            if (!Objects.equals(entry.getValue(), value2)) {
//                return false;
//            }
//        }

        Character[] keys = new Character[map1.keySet().size()];
        map1.keySet().toArray(keys);
        for (Character k : keys) {
            Integer v1 = map1.get(k);
            Integer v2 = map2.get(k);

            if (!Objects.equals(v1, v2)) {
                return false;
            }
        }
        return true;
    }

    static Map<Character, Integer> getFrequency(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

}
