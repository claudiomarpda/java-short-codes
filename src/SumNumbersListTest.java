public class SumNumbersListTest {

//    Input:
//    a: [1]
//    b: [9998, 9999, 9999, 9999, 9999, 9999]
//    Output:
//            [9999, 0, 0]
//    Expected Output:
//            [9999, 0, 0, 0, 0, 0]

    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {9998, 9999, 9999, 9999, 9999, 9999};
        ListNode<Integer> listA = init(a);
        ListNode<Integer> listB = init(b);

//        print(list);
//        ListNode<Integer> reversed = reverse(listA);
//        print(reversed);

        ListNode<Integer> solution = solution(listA, listB);
        print(solution);
    }

    static ListNode<Integer> init(int[] a) {
        ListNode<Integer> list = new ListNode<>(a[0]);
        ListNode<Integer> tmp = list;
        for (int i = 1; i < a.length; i++) {
            tmp.next = new ListNode<>(a[i]);
            tmp = tmp.next;
        }
        return list;
    }

    static ListNode<Integer> reverse(ListNode<Integer> node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode<Integer> previous = node;
        node = node.next;
        previous.next = null;
        ListNode<Integer> next;

        while (node.next != null) {
            next = node.next;
            node.next = previous;

            previous = node;
            node = next;
        }
        node.next = previous;
        return node;
    }

    //
    static ListNode<Integer> solution(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> ar = reverse(a);
        ListNode<Integer> br = reverse(b);
        int aSize = getSize(ar);
        int bSize = getSize(br);
        int longer = Math.max(aSize, bSize);
        final int MAX = 9999;

        int carry = 0;
        ListNode<Integer> sumList = null;
        ListNode<Integer> tmpSum = null;

        for (int i = 0; i < longer; i++) {
            int sum = 0;
            if (ar != null) {
                sum = ar.value;
                ar = ar.next;
            }
            if (br != null) {
                sum += br.value;
                br = br.next;
            }
            sum += carry;
            // carry
            ListNode<Integer> newNode;
            if (sum > MAX) {
                carry = sum - MAX;
                newNode = new ListNode<>(0);
            } else {
                carry = 0;
                newNode = new ListNode<>(sum);
            }

            if (sumList == null) {
                sumList = newNode;
                tmpSum = newNode;
            } else {
                tmpSum.next = newNode;
                tmpSum = sumList.next;
            }

        }
        return reverse(sumList);
    }

    static int getSize(ListNode<Integer> n) {
        int count = 0;
        ListNode<Integer> tmp = n;
        while (tmp != null) {
            tmp = tmp.next;
            count++;
        }
        return count;
    }



    static void print(ListNode<Integer> list) {
        ListNode<Integer> node = list;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

}
// Singly-linked lists are already defined with this interface:
class ListNode<T> {
    T value;
    ListNode<T> next;
    ListNode(T x) {
        value = x;
    }
}