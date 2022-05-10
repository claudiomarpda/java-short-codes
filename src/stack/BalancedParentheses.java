package stack;

import java.util.Deque;
import java.util.LinkedList;

public class BalancedParentheses {

    public static void main(String[] args) {
        String[] inputs = {"((())())()", " )()(", "())", "()(", "(", ")"};
        for (String input : inputs) {
            System.out.println(input);
            checkBalancedParentheses(new LinkedList<>(), input);
        }
    }

    static void checkBalancedParentheses(Deque<Character> stack, String input) {
        for (int i = 0; i < input.length(); i++) {
            if ('(' == input.charAt(i)) {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    System.out.println("Empty stack. Unbalanced at index " + i);
                    return;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Balanced parentheses");
        } else {
            System.out.println("Unbalanced parentheses. Stack not empty after reading all parentheses.");
        }
    }

}
