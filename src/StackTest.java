import java.util.LinkedList;

public class StackTest {

    public static void main(String[] args) {
        Tree<Integer> root = new Tree<>(4);
        Tree<Integer> l1 = new Tree<>(1);
        root.left = l1;
        Tree<Integer> l2 = new Tree<>(-2);
        l1.left = l2;
        Tree<Integer> r1 = new Tree<>(3);
        l2.right = r1;
        Tree<Integer> r2 = new Tree<>(3);
        root.right = r2;
        Tree<Integer> l3 = new Tree<>(1);
        r2.left = l3;
        Tree<Integer> r3 = new Tree<>(2);
        r2.right = r3;
        Tree<Integer> l4 = new Tree<>(-2);
        r3.left = l4;
        Tree<Integer> r4 = new Tree<>(-3);
        l4.right = r4;

//        preOrder(root, 7, 0);

        System.out.println(hasPathWithGivenSum(root, 7));

    }

    static void preOrder(Tree<Integer> node, Integer expectedSum, Integer currentSum) {
        if ( node == null) {
            if (currentSum.equals(expectedSum)) {
                System.out.println("true");
            }
            return;
        }
        System.out.print(node.value + " ");
        currentSum += node.value;
        preOrder(node.left, expectedSum, currentSum);
        preOrder(node.right, expectedSum, currentSum);
    }

    static class Tree<T> {
       Tree(T x) {
        value = x;
       }

       T value;
       Tree<T> left;
       Tree<T> right;
    }

    static boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
        if (t == null) {
            return false;
        }

        LinkedList<Tree<Integer>> stack = new LinkedList<>();
        stack.push(t);
        long sum = 0;

        while (!stack.isEmpty()) {
            Tree<Integer> node = stack.pop();
            System.out.println(node.value);
            sum += node.value;
            if (t.right != null) {
                stack.push(t.right);
            } else {
                if (sum == s) {
                    return true;
                }
            }
            if (t.left != null) {
                stack.push(t.left);
            } else {
                if (sum == s) {
                    return true;
                }
            }
        }
        return false;
    }

}
