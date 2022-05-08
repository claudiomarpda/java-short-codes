import java.util.*;

public class StructureTest {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> integers = rotateLeftModule(4, arrayList);
        integers.forEach(a -> System.out.printf("%d ", a));
    }


    //    List<String> strings = new ArrayList<>(List.of("aba", "baba", "aba", "xzxb"));
//    List<String> queries = new ArrayList<>(List.of("aba", "xzxb", "ab"));
//    List<Integer> counts = matchingStringsWithCache(strings, queries);
//    counts.forEach(a -> System.out.printf("%d ", a));
    public static List<Integer> matchingStringsWithCache(List<String> strings, List<String> queries) {
        // Write your code here
        Map<String, Integer> counter = new HashMap<>();
        List<Integer> counts = new ArrayList<>(Collections.nCopies(queries.size(), 0));
//        List<Integer> counts = Collections.nCopies(queries.size(), 0);
        for (String s : strings) {
            if (counter.containsKey(s)) {
                counter.put(s, counter.get(s) + 1);
            } else {

                counter.put(s, 1);
            }
        }

        for (int i = 0; i < queries.size(); i++) {
            String s = queries.get(i);
            counts.set(i, counter.getOrDefault(s, 0));
        }
        return counts;
    }

    //    List<String> strings = new ArrayList<>(List.of("aba", "baba", "aba", "xzxb"));
//    List<String> queries = new ArrayList<>(List.of("aba", "xzxb", "ab"));
//    List<Integer> counts = matchingStrings(strings, queries);
//    counts.forEach(a -> System.out.printf("%d ", a));
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        List<Integer> counts = new ArrayList<>(Collections.nCopies(queries.size(), 0));
        for (int i = 0; i < queries.size(); i++) {
            for (String s : strings) {
                if (queries.get(i).equals(s)) {
                    counts.set(i, counts.get(i) + 1);
                }
            }
        }
        return counts;
    }

    // List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    // rotateLeft(7, arrayList);
    // arrayList.forEach(a -> System.out.printf("%d ", a));
    static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        for (int r = 0; r < d; r++) {
            int first = arr.get(0);
            for (int i = 1; i < arr.size(); i++) {
                arr.set(i - 1, arr.get(i));
            }
            arr.set(arr.size() - 1, first);
        }
        return arr;
    }

    //  List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    //  List<Integer> integers = rotateLeftModule(4, arrayList);
    //  integers.forEach(a -> System.out.printf("%d ", a));
    static List<Integer> rotateLeftModule(int d, List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        for (int r = 0; r < d; r++) {
            for (int i = 1; i < n; i++) {
                int left = (i + (n - d) - 1) % n;
                int right = (i + (n - d)) % n;

                int tmp = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, tmp);
            }
        }
        return arr;
    }

    static List<Integer> rotateWithReversal(int d, List<Integer> arr) {
        List<Integer> left = arr.subList(0, d);
        List<Integer> right = arr.subList(d, arr.size());
        reverse(left);
        reverse(right);
        reverse(arr);
        return arr;
    }

    static void reverse(List<Integer> list) {
        for (int i = 0, j = list.size() - 1; i < list.size() / 2; i++, j--) {
            int tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
        }
    }

}
