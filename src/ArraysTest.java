import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysTest {

    public static void main(String[] args) {
//        int[] a = {-1, 150, 190, 170, -1, -1, 160, 180};
        int[] a = {-1, -1, -1, -1, -1};
        int[] r = solution(a);
        System.out.println(Arrays.toString(r));

    }

    static int[] solution(int[] a) {
        int[] tmp = Arrays.copyOf(a, a.length);
        Arrays.sort(tmp);

        int i = 0;
        while (i < a.length && tmp[i] == -1) {
            i++;
        }

        for (int j = 0; j < a.length; j++) {
            if (a[j] != -1) {
                a[j] = tmp[i++];
            }
        }
        return a;
    }

    /*
     int[] s = new int[]{1, 2, 3, 4, 3, 6};
        s = new int[]{10, 1, 2, 3, 4, 5};
        System.out.println(almostIncreasingSequenceOOfN(s));
        s = new int[]{1, 1, 2};
        System.out.println(almostIncreasingSequenceOOfN(s));
        s = new int[]{1, 2, 3};
        System.out.println(almostIncreasingSequenceOOfN(s));
        s = new int[]{3, 2, 3};
        System.out.println(almostIncreasingSequenceOOfN(s));
        s = new int[]{3, 2, 4};
        System.out.println(almostIncreasingSequenceOOfN(s));
        s = new int[]{1, 3, 2};
        System.out.println(almostIncreasingSequenceOOfN(s));

        System.out.println();
        s = new int[]{1, 3, 2, 1};
        System.out.println(almostIncreasingSequenceOOfN(s));
        s = new int[]{3, 2, 1};
        System.out.println(almostIncreasingSequenceOOfN(s));
        s = new int[]{3, 2, 2};
        System.out.println(almostIncreasingSequenceOOfN(s));
     */
    static boolean almostIncreasingSequenceOOfN(int[] sequence) {
        int notIncreasing = 0;
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] >= sequence[i + 1]) {
                notIncreasing++;

                if (i < sequence.length - 2 &&
                        !(sequence[i] < sequence[i + 2])) {
                    return false;
                }
            }
        }
        return notIncreasing > 1;
    }


    ///////////////
    boolean almostIncreasingSequence(int[] sequence) {
        boolean increasing = false;
        int i = 0;
        for (; i < sequence.length - 1; i++) {
            if (sequence[i] >= sequence[i + 1]) {
                break;
            }
        }

        while (!increasing && i < sequence.length - 1) {
            int[] tmp = getSequenceExceptOne(sequence, i);
            increasing = isIncreasing(tmp);
            i++;
        }

        if (isIncreasing(getSequenceExceptOne(sequence, sequence.length - 1))) {
            increasing = true;
        }

        return increasing;
    }

    int[] getSequenceExceptOne(int[] sequence, int indexException) {
        int[] tmp = new int[sequence.length - 1];

        for (int i = 0, j = 0; i < sequence.length; i++) {
            if (i != indexException) {
                tmp[j] = sequence[i];
                j++;
            }
        }
        return tmp;
    }

    boolean isIncreasing(int[] sequence) {
        for (int j = 0; j < sequence.length - 1; j++) {
            if (sequence[j] >= sequence[j + 1]) {
                return false;
            }
        }
        return true;
    }
    //////////////


    static boolean ascendingArray(int[] seq) {
        boolean deleted = false;

        for (int i : seq) {
            for (int j : seq) {
                if (j > i) {
                    if (deleted) {
                        return false;
                    }
                    deleted = true;
                }
            }
        }
        return true;
    }

    /**
     * System.out.println((int) 'a');
     * System.out.println((int) 'b');
     * System.out.println((int) 'z');
     * int size = 'z' - 'a';
     * System.out.println("size: " + size);
     * int[] a = new int[size];
     * <p>
     * System.out.println(getIndex('a'));
     * System.out.println(getIndex('b'));
     * System.out.println(getIndex('z'));
     * <p>
     * System.out.println("init");
     * int[] b = new int[10];
     * for (int bb : b) {
     * System.out.println(bb);
     * }
     *
     * @param c
     * @return
     */
    static int getIndex(char c) {
        return c - 'a';
    }

    //    String[] crypt = {"SEND", "MORE", "MONEY"};
//    char[][] solution = {{'O', '0'},
//            {'M', '1'},
//            {'Y', '2'},
//            {'E', '5'},
//            {'N', '6'},
//            {'D', '7'},
//            {'R', '8'},
//            {'S', '9'}};
//
//        System.out.println(isCryptSolution(crypt, solution));
    static boolean isCryptSolution(String[] crypt, char[][] solution) {
        Map<Character, Character> map = new HashMap<>();
        for (char[] chars : solution) {
            map.put(chars[0], chars[1]);
        }

        long[] cryptSum = new long[crypt.length];
        for (int i = 0; i < crypt.length; i++) {

            char firstChar = map.get(crypt[i].charAt(0));
            if (crypt[i].length() > 1 && firstChar == '0') {
                return false;
            }
            StringBuilder b = new StringBuilder(crypt[i].length());
            for (char c : crypt[i].toCharArray()) {
                b.append(map.get(c));
            }
            cryptSum[i] = Long.parseLong(b.toString());
        }

        return cryptSum[0] + cryptSum[1] == cryptSum[2];
    }

    /*
        char[][] m = {{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
                {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
                {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
                {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
                {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '7', '.'}};*/
    static boolean sudoku2(char[][] grid) {
        int n = grid[0].length;
        int[] map = new int[10];

        // check rows
        for (int r = 0; r < n; r++) {
            Arrays.fill(map, 0);
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '.') {
                    continue;
                }

                int intValue = Character.getNumericValue(grid[r][c]);
                if (map[intValue] > 0) {
                    System.out.println("row failed");
                    return false;
                } else {
                    map[intValue] = 1;
                }
            }
        }

        // check columns
        for (int c = 0; c < n; c++) {
            Arrays.fill(map, 0);
            for (int r = 0; r < n; r++) {
                if (grid[r][c] == '.') {
                    continue;
                }

                int intValue = Character.getNumericValue(grid[r][c]);
                if (map[intValue] > 0) {
                    System.out.println("column failed");
                    return false;
                } else {
                    map[intValue] = 1;
                }
            }
        }

        // check 3x3
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                Arrays.fill(map, 0);
                for (int c = i; c < i + 3; c++) {
                    for (int r = j; r < j + 3; r++) {
                        if (grid[r][c] == '.') {
                            continue;
                        }

                        int intValue = Character.getNumericValue(grid[r][c]);
                        if (map[intValue] > 0) {
                            System.out.println("block failed");
                            return false;
                        } else {
                            map[intValue] = 1;
                        }
                    }
                }
            }
        }

        return true;
    }


    static int[][] transposeAndRotateMatrix(int[][] a) {
        int n = a[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = tmp;
            }
        }
        printMatrix(a);
        for (int r = 0; r < n; r++) {
            for (int lc = 0, rc = n - 1; lc < n; lc++, rc--) {
                int tmp = a[lc][rc];
                a[lc][rc] = a[rc][lc];
                a[rc][lc] = tmp;
            }
        }
        return a;
    }

    static int[][] rotateImageNSpace3(int[][] a) {
        int n = a[0].length;
        int[][] m = new int[n][n];

        int oneD = n - 1;
        for (int r = 0; r <= oneD; r++) {
            int[] row = a[r];
            for (int c = oneD; c >= 0; c--) {
//                m[r][c] = row[c];
                m[c][r] = row[c];
            }
        }
        return m;
    }

    static int[][] rotateImageNSpace2(int[][] a) {
        int n = a[0].length;
        int[][] m = new int[n][n];

        int oneD = n - 1;
        for (int r = 0; r <= oneD; r++) {
            int[] row = a[r];
            for (int c = 0; c <= oneD; c++) {
//                m[r][c] = row[c];
                m[c][oneD - r] = row[c];
            }
        }
        return m;
    }

    //    int[][] a = {{1, 2, 3},
//            {4, 5, 6},
//            {7, 8, 9}};
//    printMatrix(a);
//    //        int[][] b = rotateImageNSpace3(a);
////        int[][] b = transposeAndRotateMatrix(a);
//    int[][] b = rotateImageNSpace(a);
//        System.out.println();
//    printMatrix(b);
    static int[][] rotateImageNSpace(int[][] a) {
        int n = a[0].length;
        int[][] m = new int[n][n];

        int oneDimSize = n - 1;
        for (int r = 0; r <= oneDimSize; r++) {
            for (int c = 0; c <= oneDimSize; c++) {
                m[c][oneDimSize - r] = a[r][c];
            }
        }
        return m;
    }

    static void printMatrix(int[][] a) {
        for (int r = 0; r <= 2; r++) {
            for (int c = 0; c <= 2; c++) {
                System.out.print(a[r][c]);
            }
            System.out.println();
        }
    }

    static int[][] rotateImageInPlace(int[][] a) {
        int oneD = a[0].length - 1;
        for (int c = 0; c <= oneD; c++) {
            for (int r = 0; r <= oneD; r++) {
                int tmp = a[r][c];
                if (isDiagonal(a, r, c)) {
                    System.out.println("diagonal");
                    if (r == c) {
                        System.out.printf("%d%d -> %d%d\n", r, c, oneD, c);
                        a[r][c] = a[oneD][c];
                        a[oneD][c] = tmp;
                    } else {
                        System.out.printf("%d%d -> %d%d\n", r, c, oneD, oneD);
                        a[r][c] = a[oneD][oneD];
                        a[oneD][oneD] = tmp;
                    }
                } else {
                    System.out.println("inner");
                    System.out.printf("%d%d -> %d%d\n", r, c, c, oneD - r);
//                    a[r][c] = a[c][oneD - r];
                    a[c][oneD - r] = a[r][c];
                }
            }
        }
        return a;
    }

    static boolean isDiagonal(int[][] a, int r, int c) {
        int oneD = a.length - 1;
        return r == 0 && c == 0 ||
                r == oneD && c == oneD ||
                r == 0 && c == oneD ||
                r == oneD && c == 0;
    }

    //    int[] a = {2, 1, 3, 5, 3, 2};
//    String s = "ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof";
//    char c = firstNotRepeatingCharacter(s);
//        System.out.println(c);
    static char firstNotRepeatingCharacter(String s) {
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (frequencyMap.containsKey(s.charAt(i))) {
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            } else {
                frequencyMap.put(c, 1);
            }
        }

        Map.Entry<Character, Integer> first = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .orElse(new AbstractMap.SimpleImmutableEntry<>('_', -1));
        return first.getKey();

//        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
//            if (entry.getValue() == 1) {
//                return entry.getKey();
//            }
//        }
//        return '_';
//    }
    }


}
