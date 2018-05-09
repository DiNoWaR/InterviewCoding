package com.denis.interview.algorithms.stacks.stackswitharray;

import com.denis.interview.algorithms.stacks.mystack.EmptyStackException;

public class StacksWithArray {

    private int topOne = 0;
    private int topTwo = 1;
    private int topThree = 2;

    Integer[] array;

    public StacksWithArray(int length) {
        array = new Integer[length];
    }

    public void push(int stack, int item) throws RuntimeException {

        if (stack > 2 || stack < 0) {
            throw new RuntimeException();
        }

        if (topOne + 3 >= array.length
                || topTwo + 3 >= array.length
                || topThree + 3 >= array.length) {
            extendArray();
        }

        if (stack == 0) {
            array[topOne] = item;
            topOne += 3;
        }

        if (stack == 1) {
            array[topTwo] = item;
            topTwo += 3;
        }

        if (stack == 2) {
            array[topThree] = item;
            topThree += 3;
        }

    }

    public int pop(int stack) {


        if (stack > 2 || stack < 0) {
            throw new RuntimeException();
        }

        Integer result;

        if (stack == 0) {

            if (!isEmpty(0)) {
                topOne -= 3;
                result = array[topOne];
                array[topOne] = null;
                return result;
            }
        }

        if (stack == 1) {

            if (!isEmpty(1)) {
                topTwo -= 3;
                result = array[topTwo];
                array[topTwo] = null;
                return result;
            }
        }

        if (stack == 2) {

            if (!isEmpty(2)) {
                topThree -= 3;
                result = array[topThree];
                array[topThree] = null;
                return result;
            }
        }

        throw new EmptyStackException();

    }

    public int peek(int stack) throws RuntimeException {

        if (stack > 2 || stack < 0) {
            throw new RuntimeException();
        }

        if (stack == 0) {

            if (!isEmpty(0)) {
                return array[topOne - 3];
            }
        }

        if (stack == 1) {

            if (!isEmpty(1)) {
                return array[topTwo - 3];
            }
        }

        if (stack == 2) {

            if (!isEmpty(2)) {
                return array[topThree - 3];
            }
        }

        throw new EmptyStackException();
    }

    public boolean isEmpty(int stack) throws RuntimeException {

        if (stack > 2 || stack < 0) {
            throw new RuntimeException();
        }

        if (stack == 0) {
            return topOne <= 0;
        }

        if (stack == 1) {
            return topTwo <= 1;
        }

        return topThree <= 2;
    }


    private void extendArray() {
        Integer[] newArray = new Integer[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }


    public static void main(String[] args) {

        StacksWithArray stacks = new StacksWithArray(5);

        stacks.push(0, 1);
        stacks.push(0, 3);

        stacks.push(1, 6);
        stacks.push(2, 5);

        stacks.push(1, 10);
        stacks.push(2, 5);

        stacks.push(0, 100);
        stacks.push(2, 200);


        stacks.pop(0);
        stacks.pop(1);
        stacks.pop(2);

        System.out.println(stacks.peek(0));
        System.out.println(stacks.peek(1));
        System.out.println(stacks.peek(2));

    }

}
