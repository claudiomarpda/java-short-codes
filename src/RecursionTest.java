import java.util.LinkedList;
import java.util.List;

public class RecursionTest {

    public static void main(String[] args) {

    }

    // List<Integer> integers = Arrays.asList(34, 56, 4, 10, 77, 51, 93, 30, 5, 52);
    // List<Integer> result = quicksort(integers);
    // System.out.println(result);
    static List<Integer> quicksort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        } else {
            int pivot = list.get(0);
            var less = new LinkedList<Integer>();
            var greater = new LinkedList<Integer>();
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < pivot) {
                    less.add(list.get(i));
                } else {
                    greater.add(list.get(i));
                }
            }
            var result = quicksort(less);
            result.add(pivot);
            result.addAll(quicksort(greater));
            return result;
        }
    }

    static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    //  List<Integer> list = new LinkedList<>();
//  Stream.of(1, 2, 3, 4, 5).forEach(list::add);
//  int max = findMaxRec(list, 0);
//  System.out.println("max " + max);
    static int findMaxRec(List<Integer> list, int max) {
        if (list.isEmpty()) {
            return max;
        } else {
            if (list.get(0) > max) {
                max = list.get(0);
            }
            list.remove(0);
            return findMaxRec(list, max);
        }
    }

    //        List<Integer> list = new LinkedList<>();
//        Stream.of(1, 2, 3, 4 ,5).forEach(list::add);
//        int size = countListItemsRec(list);
//        System.out.println(size);
    static int countListItemsRec(List<?> list) {
        if (list.isEmpty()) {
            return 0;
        } else {
            list.remove(0);
            return 1 + countListItemsRec(list);
        }
    }

    static int rec_sum(int[] data, int index) {
        if (index == 0) {
            return data[0];
        } else {
            return data[index] + rec_sum(data, index - 1);
        }
    }

    static void goForever() {
        goForever();
    }

    static int re_fact(int n) {
        if (n == 1) {
            return 1;
        } else {
            int tmp = re_fact(n - 1);
            System.out.printf("n * fact(%d)\n", n, n - 1);
            System.out.printf("%d * fact(%d)\\nn", n, n - 1);
            return n * tmp;
        }
    }

    // printCountdownRecursively(5);
    static void printCountdownRecursively(int start) {
        if (start < 0) {
            return;
        }
        System.out.println(start);
        printCountdownRecursively(start - 1);
    }

    static long re_factorial(long n) {
        if (n <= 1)
            return 1;
        else
            return n * re_factorial(n - 1);
    }

    static long it_factorial(long n) {
        if (n <= 1)
            return 1;

        long result = 1;
        while (n > 1) {
            result *= n;
            n--;
        }
        return result;
    }

    static long re_fib(int n) {
        if (n <= 0)
            return 0;

        switch (n) {
            case 1:
                return 0;
            case 2:
            case 3:
                return 1;
        }
        return re_fib(n - 2) + re_fib(n - 1);
    }

    static long it_fib(int n) {
        if (n <= 0)
            return 0;

        switch (n) {
            case 1:
                return 0;
            case 2:
            case 3:
                return 1;
        }

        long n2 = 1;
        long n3 = 1;
        long result = 0;
        for (int i = 4; i <= n; i++) {
            result = n2 + n3;
            n2 = n3;
            n3 = result;
        }
        return result;
    }

}
