package com.denis.interview.algorithms.other.bracketsvalidation;

import java.util.Stack;

/**
 * You're working with an intern that keeps coming to you with JavaScript code
 * that won't run because the braces, brackets, and parentheses are off.
 * To save you both some time, you decide to write a braces/brackets/parentheses validator.
 * <p>
 * Let's say:
 * <p>
 * '(', '{', '[' are called "openers."
 * ')', '}', ']' are called "closers."
 * Write an efficient method that tells us whether or not an input string's openers and closers are properly nested.
 * <p>
 * Examples:
 * <p>
 * "{ [ ] ( ) }" should return true
 * "{ [ ( ] ) }" should return false
 * "{ [ }" should return false
 */
public class BracketsValidator {

    public static boolean validate(String brackets) {

        var result = true;

        var stack = new Stack<Character>();

        char current, previous;

        for (var i = 0; i < brackets.length(); i++) {
            current = brackets.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (current == ')' || current == ']' || current == '}') {

                if (stack.isEmpty()) {
                    result = false;
                } else {
                    previous = stack.peek();
                    if ((current == ')' && previous == '(') || (current == ']' && previous == '[') || (current == '}' && previous == '{')) {
                        stack.pop();
                    } else {
                        result = false;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            result = false;
        }
        return result;
    }

}
