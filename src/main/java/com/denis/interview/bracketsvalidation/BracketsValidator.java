package com.denis.interview.bracketsvalidation;

import java.util.Stack;

public class BracketsValidator {

    private String brackets;


    public BracketsValidator(String s) {
        brackets = s;
    }

    public boolean validate() {

        boolean result = true;

        Stack<Character> stack = new Stack<>();

        char current, previous;

        for (int i = 0; i < this.brackets.length(); i++) {
            current = this.brackets.charAt(i);

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
