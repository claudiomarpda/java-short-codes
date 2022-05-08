import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingTest {

    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>(List.of(5, 1, 2, 3, 7, 8, 6, 4));
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 5, 3, 7, 8, 6, 4));
        minimumBribes(list);
    }

    static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribes = 0;
            for (int i = q.size() - 1; i >= 0; i--) {
                int k = i;
                int swaps = 0;
                while ((k < q.size() - 1) && q.get(k) > q.get(k + 1)) {
                    int tmp = q.get(k + 1);
                    q.set(k + 1, q.get(k));
                    q.set(k, tmp);
                    k++;
                    swaps++;
                }
                if (swaps > 2) {
                    System.out.println("Too chaotic");
                    return;
                } else {
                    bribes += swaps;
                }
                System.out.println("i " + i);
                q.forEach(System.out::print);
                System.out.println();
            }
            System.out.println(bribes);
    }






    public static void minimumBribes_Old(List<Integer> q) {
        // Write your code here
        int bribes = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(i) > (i + 1)) {
                int j = i;
                do {
                    int tmp = q.get(j + 1);
                    q.set(j + 1, q.get(j));
                    q.set(j, tmp);
                    j++;
                } while (q.get(j) > (j + 1));

                int difference = j - i;
                if (difference > 2) {
                    System.out.println("Too chaotic");
                    return;
                } else {
                    bribes += difference;
                }
            }
            q.forEach(System.out::print);
            System.out.println();
        }
        System.out.println(bribes);
    }

    //   int[] data = { 34, 56, 4, 10, 77, 51, 93, 30, 5, 52};
    //    int[] data = {4, 3, 1, 2};
    //    //        selectionSort(data);
    //    int swaps = minimumSwaps(data);
    //        System.out.println(swaps);
    //        System.out.println(Arrays.toString(data));
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int smallest;
        for (int i = 0; i < arr.length - 1; i++) {
            smallest = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < smallest) {
                    swap(arr, i, j);
                    swaps++;
                }
            }
        }
        return swaps;
    }

    //    int[] data = { 34, 56, 4, 10, 77, 51, 93, 30, 5, 52};
//        System.out.println(Arrays.toString(data));
//    //        selectionSort(data);
//    insertionSort(data);
//        System.out.println(Arrays.toString(data));
    static void selectionSort(int[] data) {
        int smallest;

        for (int i = 0; i < data.length - 1; i++) {
            smallest = data[i];
            for (int j = i; j < data.length; j++) {
                if (data[j] < smallest) {
                    smallest = data[j];
                    data[j] = data[i];
                    data[i] = smallest;
                }
            }
        }
    }

    static void insertionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    swap(data, j, j - 1);
                }
            }
        }
    }

    static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

}
