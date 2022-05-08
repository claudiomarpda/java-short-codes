public class ParamTest {

//     Singly-linked lists are already defined with this interface:
static class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }

    public static void main(String[] args) {
        var list = new ListNode<>(2);
        set(list);
        System.out.println(list.value);
        System.out.println(list.next.value);
    }

    static void set(ListNode<Integer> node) {
        node.next = new ListNode<>(4);
        node = node.next;
    }

}
