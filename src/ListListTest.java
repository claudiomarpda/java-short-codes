import java.util.*;
import java.util.stream.Stream;

public class ListListTest {

    public static void main(String[] args) {
        String[] inputArray = {"aba", "aa", "ad", "vcd", "aba"};
        String[] solution = solution(inputArray);
        System.out.println(Arrays.toString(solution));
    }

    // O(N) time
    // 0(2N) space
    static String[] solution(String[] inputArray) {
        Map<Integer, List<String>> mapByLength = new HashMap<>();
        int longestLength = 0;
        for (String s : inputArray) {
            if (s.length() > longestLength) {
                longestLength = s.length();
            }
            if (!mapByLength.containsKey(s.length())) {
                mapByLength.put(s.length(), new LinkedList<>());
            }
            mapByLength.get(s.length()).add(s);
        }
        return mapByLength.get(longestLength).toArray(String[]::new);
    }

    // O(2N) time
    // 0(N) space
    static String[] solutionStream(String[] inputArray) {
        int longest = 0;
        for (String value : inputArray) {
            if (value.length() > longest) {
                longest = value.length();
            }
        }

        final int longestLength = longest;
        return Stream.of(inputArray)
                .filter(s -> s.length() == longestLength)
                .toArray(String[]::new);
    }

    // O(2N) time
    // 0(N) space
    static String[] solutionBasic(String[] inputArray) {
        int longestSize = 0;
        int numberOfLongestStrings = 0;
        for (String s : inputArray) {
            if (s.length() > longestSize) {
                longestSize = s.length();
                numberOfLongestStrings = 1;
            } else if (s.length() == longestSize) {
                numberOfLongestStrings++;
            }
        }

        String[] longestStrings = new String[numberOfLongestStrings];
        for (int i = 0, j = 0; i < inputArray.length; i++) {
            if (inputArray[i].length() == longestSize) {
                longestStrings[j] = inputArray[i];
                j++;
            }
        }
        return longestStrings;
    }

}
