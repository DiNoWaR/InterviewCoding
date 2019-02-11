package com.denis.interview.algorithms.stacks.stackswitharray;

/**
 * Implement 3 stacks using 1 array.
 */
public class ThreeStacksWithArray {

    private int topOne = 0;
    private int topTwo = 1;
    private int topThree = 2;

    private Integer[] array;


    public ThreeStacksWithArray(int length) {
        array = new Integer[length];
    }


    public void push(StacksID staksID, int item) {

        if (topOne + 3 >= array.length
                || topTwo + 3 >= array.length
                || topThree + 3 >= array.length) {
            extendArray();
        }

        switch (staksID) {

            case FIRST:
                array[topOne] = item;
                topOne += 3;
                break;
            case SECOND:
                array[topTwo] = item;
                topTwo += 3;
                break;
            case THIRD:
                array[topThree] = item;
                topThree += 3;
                break;
        }

    }

    public Integer pop(StacksID stack) {

        Integer result = null;

        switch (stack) {
            case FIRST:
                if (!isEmpty(StacksID.FIRST)) {
                    topOne -= 3;
                    result = array[topOne];
                    array[topOne] = null;
                }
                break;
            case SECOND:
                if (!isEmpty(StacksID.SECOND)) {
                    topTwo -= 3;
                    result = array[topTwo];
                    array[topTwo] = null;
                }
                break;
            case THIRD:
                if (!isEmpty(StacksID.THIRD)) {
                    topThree -= 3;
                    result = array[topThree];
                    array[topThree] = null;
                }
                break;
        }
        return result;
    }

    public Integer peek(StacksID stack) {

        Integer result = null;

        switch (stack) {
            case FIRST:
                if (!isEmpty(StacksID.FIRST)) {
                    result = array[topOne - 3];
                }
                break;
            case SECOND:
                if (!isEmpty(StacksID.SECOND)) {
                    result = array[topTwo - 3];
                }
                break;
            case THIRD:
                if (!isEmpty(StacksID.THIRD)) {
                    result = array[topThree - 3];
                }
                break;
        }
        return result;
    }

    public boolean isEmpty(StacksID stack) {

        boolean result = false;

        switch (stack) {
            case FIRST:
                result = topOne <= 0;
                break;
            case SECOND:
                result = topTwo <= 1;
                break;
            case THIRD:
                result = topThree <= 2;
                break;
        }
        return result;
    }


    private void extendArray() {
        var newArray = new Integer[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public static void main(String[] args) {

        var stacks = new ThreeStacksWithArray(5);

        stacks.push(StacksID.FIRST, 1);
        stacks.push(StacksID.FIRST, 3);

        stacks.push(StacksID.SECOND, 6);
        stacks.push(StacksID.SECOND, 5);

        stacks.push(StacksID.SECOND, 10);
        stacks.push(StacksID.THIRD, 5);

        stacks.push(StacksID.FIRST, 100);
        stacks.push(StacksID.THIRD, 200);

        stacks.pop(StacksID.FIRST);
        stacks.pop(StacksID.SECOND);
        stacks.pop(StacksID.THIRD);

        System.out.println(stacks.peek(StacksID.FIRST));
        System.out.println(stacks.peek(StacksID.SECOND));
        System.out.println(stacks.peek(StacksID.THIRD));

    }

}
