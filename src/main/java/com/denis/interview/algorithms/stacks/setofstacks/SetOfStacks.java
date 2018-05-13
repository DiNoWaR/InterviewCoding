package com.denis.interview.algorithms.stacks.setofstacks;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {

    private List<Stack<Integer>> list;
    private int currentStackSize = 0;

    private int currentStackIndex = 0;

    private final int maxSize;


    public SetOfStacks(int maxSize) {
        list = new ArrayList<>();
        addStackToList();
        this.maxSize = maxSize;
    }

    public void push(Integer item) {

        if (currentStackSize < maxSize) {
            list.get(currentStackIndex).push(item);
            currentStackSize++;
        } else {
            addStackToList();
            currentStackIndex++;
            list.get(currentStackIndex).push(item);
            currentStackSize = 1;
        }

    }

    public Integer pop() {

        if (currentStackIndex == 0) {

            if (list.get(currentStackIndex).isEmpty()) {
                throw new EmptyStackException();
            } else {
                currentStackSize--;
                return list.get(currentStackIndex).pop();
            }

        }

        if (list.get(currentStackIndex).isEmpty()) {
            list.remove(currentStackIndex);
            currentStackIndex--;
            currentStackSize--;
            return list.get(currentStackIndex).pop();
        }

        currentStackSize--;
        return list.get(currentStackIndex).pop();
    }

    private void addStackToList() {
        list.add(new Stack<>());
    }


    public static void main(String[] args) {

        SetOfStacks set = new SetOfStacks(3);

        set.push(1);
        set.push(2);
        set.push(3);
        set.push(4);
        set.push(5);
        set.push(6);
        set.push(7);
        set.push(8);
        set.push(9);
        set.push(10);
        set.push(11);

        set.pop();
        set.pop();
        set.pop();
        set.pop();
        set.pop();
        set.pop();

        System.out.println("bgg");

    }
}
