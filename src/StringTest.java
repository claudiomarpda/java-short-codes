import java.util.*;

public class StringTest {

    public static void main(String[] args) {
            String s1 = "anagram";
            String s2 = "margana";
            if (isAnagramWithHash(s1, s2)) {
                System.out.println("Anagrams");
            } else {
                System.out.println("Not Anagrams");
            }
    }

    static boolean isPalindromeLibrary(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            System.out.printf("Comparing %c and %c\n", s.charAt(i), s.charAt(j));
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    //    String s1 = "anagram";
    //    String s2 = "margana";
    //    boolean anagram = isAnagramBySorting(s1, s2);
    //    System.out.println(anagram);
    static boolean isAnagramBySorting(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        char[] chars1 = a.toLowerCase().toCharArray();
        char[] chars2 = b.toLowerCase().toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    //    String s1 = "anagram";
    //    String s2 = "margana";
    //    System.out.println(isAnagram(s1, s2));
    static boolean isAnagramWithHash(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Integer> map1 = getFrequency(a.toLowerCase());
        Map<Character, Integer> map2 = getFrequency(b.toLowerCase());

        for (Map.Entry<Character, Integer> e1 : map1.entrySet()) {
            Integer v2 = map2.get(e1.getKey());
            if (!Objects.equals(e1.getValue(), v2)) {
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

    // System.out.println(getSmallestAndLargest("abcabd", 3));
    // System.out.println(getSmallestAndLargest("welcometojava", 3));
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        if (k > s.length()) {
            throw new IllegalArgumentException("k larger than s length");
        }

        String sub;
        smallest = s.substring(0, k);
        largest = s.substring(0, k);
        for (int i = 1; i < s.length() - k + 1; i++) {
            sub = s.substring(i, i + k);

            int j = 0;
            while (sub.charAt(j) == smallest.charAt(j) && j < k - 1) {
                j++;
            }
            boolean smaller = sub.charAt(j) < smallest.charAt(j);
            if (smaller) {
                smallest = sub;
            }

            while (sub.charAt(j) == largest.charAt(j) && j < k - 1) {
                j++;
            }
            boolean larger = sub.charAt(j) > largest.charAt(j);
            if (larger) {
                largest = sub;
            }
        }

        return smallest + "\n" + largest;
    }

    // testSubstring("HelloWorld");
    private static void testSubstring(String s) {

        int start = 3;
        int end = 7;
        System.out.println(s.substring(start, end));
    }

    // reverseNumberWithString(-123);
    static void reverseNumberWithString(int number) {
        boolean negative = number < 0;
        if (negative) {
            number *= -1;
        }

        String reversedString = new StringBuffer(String.valueOf(number)).reverse().toString();
        int reversedInteger = negative ? Integer.parseInt(reversedString) * -1 : Integer.parseInt(reversedString);
        System.out.println(reversedInteger);
    }

    // reverseNumber(-123, 3);
    static void reverseNumber(int number, int digits) {
        int quotient = (int) (number / (Math.pow(10, digits - 1)));
        if (quotient == 0) {
            throw new IllegalArgumentException(digits + " digits not supported for the given number");
        }

        int result = 0;
        for (int i = digits - 1, leftWeight = 100, rightWeight = 1;
             i >= 0;
             i--, leftWeight /= 10, rightWeight *= 10) {

            int currentResult = (number / leftWeight) * rightWeight;
            result += currentResult;
            number -= currentResult;
        }
        System.out.println(result);
    }

    static void testAlphabeticOrder() {
        String A = "java";
        String B = "java";

        System.out.println(A.length() + B.length());

        int result = A.compareTo(B);
        if (result > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        A = makeFirstLetterUppercase(A);
        B = makeFirstLetterUppercase(B);

        System.out.printf("%s %s\n", A, B);
    }

    static String makeFirstLetterUppercase(String s) {
        if (s == null) {
            return s;
        } else {
            String upperCase = String.valueOf(s.charAt(0)).toUpperCase();
            if (s.length() == 1) {
                s = upperCase;
            } else if (s.length() > 1) {
                s = upperCase + s.substring(1);
            }
        }
        return s;
    }
}
