package com.denis.interview.algorithms.stacks.sortstack;

import java.util.Stack;

public class SortStack {
    private Stack<Integer> buffer;
    private Integer min;
    private int counter;

    public SortStack() {
        buffer = new Stack<>();
    }

    public int getCounter() {
        return counter;
    }

    public void sort(Stack<Integer> source) {
        while (!source.isEmpty()) {
            if (min == null) {
                min = source.pop();
            } else if (min >= source.peek()) {
                buffer.push(min);
                counter++;
                min = source.pop();
            } else {
                buffer.push(source.pop());
                counter++;
            }
        }
        if (counter == 0) {
            buffer.push(min);
            while (!buffer.isEmpty()) {
                source.push(buffer.pop());
            }
            return;
        }
        if (counter > 0) {
            move(buffer, source, counter);
            sort(source);
        }

    }

    private void move(Stack<Integer> src, Stack<Integer> dest, int counter) {
        while (counter > 0) {
            dest.push(src.pop());
            counter--;
        }
        this.counter = 0;
        src.push(this.min);
        this.min = null;
    }

    public Integer getMin() {
        return min;
    }

    public Stack<Integer> getBuffer() {

        return buffer;
    }

    public static void main(String[] args) {
        Stack<Integer> source = new Stack<>();
        source.push(3);
        source.push(3);
        source.push(3);
        source.push(2);
        source.push(17);
        source.push(41);
        source.push(500);

        SortStack sortStack = new SortStack();
        sortStack.sort(source);
        System.out.println(sortStack.getMin());
        System.out.println(source.isEmpty());
        System.out.println(sortStack.getCounter());
        while (!source.isEmpty()) {
            System.out.println(source.pop());
        }
    }
}
