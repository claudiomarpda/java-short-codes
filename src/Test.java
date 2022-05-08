import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        int[] a = new int[] {5, 3, 6, 7, 9};
        a = new int[] {2, 3};
        a = new int[] {1, 4, 10, 6, 2};
        a = new int[] {1000, 999};

        System.out.println(solution(a));

    }


    static int solution(int[] a) {

        int max = 10;
//        int max = Integer.MAX_VALUE;
        boolean avoided = true;
        for (int j = 1; j < max; j++) {
            for (int value : a) {
                if (value % j == 0) {
                    avoided = false;
                    break;
                }
            }
            if (avoided) {
                return j;
            }
        }
        return 0;
    }

    int solution2(int[] inputArray) {

        int jump = 1;
        boolean fail = true;

        while(fail) {
            jump++;
            fail = false;
            for(int i=0; i<inputArray.length; i++)
                if(inputArray[i]%jump==0) {
                    fail = true;
                    break;
                }
        }

        return jump;
    }




}
