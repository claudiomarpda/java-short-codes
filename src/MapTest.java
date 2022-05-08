import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<Integer, Integer> mapA = new HashMap<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : mapA.entrySet()) {

        }


    }

    static boolean solution(int[] a, int[] b) {
        if (Arrays.equals(a, b))
            return true;

        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            mapA.put(a[i], mapA.getOrDefault(a[i], 0));
            mapB.put(b[i], mapB.getOrDefault(b[i], 0));
        }

        for (Map.Entry<Integer, Integer> eA : mapA.entrySet()) {
            Integer bCount = mapB.getOrDefault(eA.getKey(), 0);
            if (!eA.getValue().equals(bCount)) {
                return false;
            }
        }

        int firstNonMatchIndex = -1;
        int nonMatchElements = 0;
        for (int i = 0; i < a.length; i++) {
            if (firstNonMatchIndex == -1 && a[i] != b[i]) {
                nonMatchElements++;
                firstNonMatchIndex = i;
            } else if (firstNonMatchIndex != -1 && a[i] != b[i]) {
                nonMatchElements++;
                int tmp = a[firstNonMatchIndex];
                a[firstNonMatchIndex] = b[i];
                b[i] = tmp;
                if (!Arrays.equals(a, b)) {
                    return false;
                }
            } else if (a[i] != b[i] && nonMatchElements > 2) {
                return false;
            }
        }

        return true;
    }

    static boolean solution2(int[] a, int[] b) {
        if (Arrays.equals(a, b))
            return true;

        int firstNonMatchIndex = -1;
        int nonMatchElements = 0;
        for (int i = 0; i < a.length; i++) {
            if (firstNonMatchIndex == -1 && a[i] != b[i]) {
                firstNonMatchIndex = i;
                nonMatchElements++;
            } else if (a[i] != b[i]) {
                int tmp = b[i];
                b[i] = b[firstNonMatchIndex];
                b[firstNonMatchIndex] = tmp;

                if (!Arrays.equals(a, b)) {
                    return false;
                }
                nonMatchElements++;
            }
        }

        return nonMatchElements <= 2;
    }

}
