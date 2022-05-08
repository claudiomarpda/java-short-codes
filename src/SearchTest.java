import java.util.Arrays;

public class SearchTest {

    public static void main(String[] args) {
        int[] ints = {2, 3, 7, 9, 4, 7, -3, 2, 1, 6, 0};
//                    [-3, 0, 1, 2, 2, 3, 4, 6, 7, 7, 9]
//        int[] ints = {13, 18, 29, 36, 42, 47, 56, 57, 63, 68, 80, 81, 82, 88, 88};
        Arrays.sort(ints);
//        System.out.println(Arrays.toString(ints));
//        System.out.println(binarySearch(6, ints));
        System.out.println(Arrays.toString(ints));
        System.out.println(binary(ints, 0));
        System.out.println(binary(new int[0], -3));
    }


    static int binary(int[] data, int value) {
        int low = 0;
        int high = data.length - 1;
        int middle = high / 2;

        while (low <= high) {
//            System.out.println(middle);
            if (data[middle] == value) {
                return middle;
            } else if (value < data[middle]) {
                high = middle - 1;
                middle = (low + middle) / 2;
            } else {
                low = middle + 1;
                middle = (middle + high) / 2;
            }
        }
        return -1;
    }


    static int binarySearch(int value, int[] data) {
        int low = 0;
        int high = data.length - 1;
        int middle = (low + high + 1) / 2;
        int location = -1;

        do {
            System.out.println(remainingElements(data, low, high));
            System.out.println("middle " + middle);
            if (data[middle] == value) {
                location = middle;
            } else if (value < data[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
            middle = (low + high + 1) / 2;
        } while ((low <= high) && (location == -1));
        return location;
    }

    // method to output certain values in array
    private static String remainingElements(int[] data, int low, int high) {
        StringBuilder temporary = new StringBuilder();

        // append spaces for alignment
        for (int i = 0; i < low; i++)
            temporary.append(" ");

        // append elements left in array
        for (int i = low; i <= high; i++)
//            temporary.append(data[i] + " ");
            temporary.append(data[i]).append(" ");

        return String.format("%s%n", temporary);

    }

}