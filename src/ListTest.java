import java.util.LinkedList;

public class ListTest {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        ListNode<Integer> list = new ListNode<>(a[0]);
        ListNode<Integer> tmp = list;
        for (int i = 1; i < a.length; i++) {
            tmp.next = new ListNode<>(a[i]);
            tmp = tmp.next;

        }
//        print(list);
        ListNode<Integer> reversed = revert(list);
        print(reversed);
    }

    static ListNode<Integer> reverse2(ListNode<Integer> node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode<Integer> previous = node;
        node = node.next;
        ListNode<Integer> next = node.next;
        previous.next = null;

        while (next != null) {
            previous = node;
            next = node.next;

            node.next = previous;
            node = next;
        }
        node = previous;
        return node;
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

    /*
    //        int[] a = {1, 1000000000, -1000000000, -1000000000, 1000000000, 1};
//        int[] a = {1, 2, 3, 3, 2, 1};
//        int[] a = {1, 2, 2, 3};
//        int[] a = {1, 2, 1, 2, 1};
//        int[] a = {1, 2, 3, 3, 2, 3};
//        int[] a = {0, 1, 0};
    int[] a = {1, 2, 3, 4};
    ListNode<Integer> list = new ListNode<>(a[0]);
    ListNode<Integer> tmp = list;
        for (int i = 1; i < a.length; i++) {
        tmp.next = new ListNode<>(a[i]);
        tmp = tmp.next;

    }
    print(list);
//        print(list);
        System.out.println();
    ListNode<Integer> reverse = reverse(list, getSize(list));
    print(reverse);
//        System.out.println(isListPalindrome(list));
    */
    /**
     * Size must be > 1
     */
    static ListNode<Integer> reverse (ListNode<Integer> list, int size) {
        ListNode<Integer> current = list;
        ListNode<Integer> next = current.next;
        current.next = null;
        ListNode<Integer> tmp;

        while (next != null) {
//        for (int i = 1; i < size / 2; i++) {
            tmp = current;
            current = next;
            next = next.next;
            current.next = tmp;
        }

        return current;
    }


    // Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
   static boolean isListPalindrome(ListNode<Integer> l) {
        int size = getSize(l);

        if (size == 0 || size == 1 || (size == 2 && l.value.equals(l.next.value))) {
            return true;
        }

        boolean sizeIsEven = size % 2 == 0;
        int middleIndex = sizeIsEven ? (size / 2) : (size / 2) + 1;

        ListNode<Integer> rightNode = l;
        for(int i = 1; i <= middleIndex; i++) {
            rightNode = rightNode.next;
        }

        ListNode<Integer> n = rightNode;
       System.out.println("right");
       while (n != null) {
           System.out.println(n.value);
           n = n.next;
       }
       System.out.println("end right");

        ListNode<Integer> leftNode = reverse(l, size);
        for (int i = 1; i <= size / 2; i++) {
            System.out.printf("comparing %d %d\n", leftNode.value, rightNode.value);
            if (!leftNode.value.equals(rightNode.value)) {
                return false;
            }
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        return true;
    }

    static int getSize(ListNode<Integer> list) {
        int size = 0;
        ListNode<Integer> tmp = list;
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }
        return size;
    }

    static void print(ListNode<Integer> list) {
        ListNode<Integer> node = list;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    //    Singly-linked lists are already defined with this interface:
    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }


    /*ListNode<Integer> listNode = new ListNode<>(3);
    ListNode<Integer> tmp = listNode;
        for (int i = 0; i < 5; i++) {
        tmp.next = new ListNode<>(i);
        tmp = tmp.next;
    }
    tmp.next = new ListNode<>(3);

    print(listNode);
    ListNode<Integer> afterRemoving = removeKFromList(listNode, 3);
        System.out.println("after");
    print(afterRemoving);*/
    static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        // In case first element value is k
        while (l != null && l.value == k) {
            l = l.next;
        }

        if (l == null) {
            return null;
        }

        ListNode<Integer> tmp = l;

        while (tmp.next != null) {
            if (tmp.next.value == k) {
                // remove and link
                tmp.next = tmp.next.next;
            } else {
                // go to the next
                tmp = tmp.next;
            }
        }

        return l;
    }

    static ListNode<Integer> revert(ListNode<Integer> head) {
        ListNode<Integer> current = head;
        ListNode<Integer> previous = null;
        ListNode<Integer> next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

}
