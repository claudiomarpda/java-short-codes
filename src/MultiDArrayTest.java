public class MultiDArrayTest {

    public static void main(String[] args) {
        int matrix[][] = {
                {0, 1, 1, 2},
                {0, 5, 0, 0},
                {2, 0, 3, 3}
        };

        System.out.println(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
