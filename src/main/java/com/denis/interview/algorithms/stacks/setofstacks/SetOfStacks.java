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

    private Stack<Integer> buffer;

    public SetOfStacks(int maxSize) {
        list = new ArrayList<>();
        buffer = new Stack<>();
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
            currentStackSize = maxSize;
            return list.get(currentStackIndex).pop();
        }

        currentStackSize--;
        return list.get(currentStackIndex).pop();
    }

    public Integer popAt(int index) {

        if (index < 0 || index > currentStackIndex) {
            throw new RuntimeException();
        }

        if (index == currentStackIndex) {
            return pop();
        }

        var result = list.get(index).pop();

        shiftElements(index);
        return result;
    }

    public Integer peek() {
        return list.get(currentStackIndex).peek();
    }


    private void addStackToList() {
        list.add(new Stack<>());
    }

    private void shiftElements(int startIndex) {

        for (var i = startIndex; i <= currentStackIndex - 1; i++) {
            move(list.get(i + 1), buffer);
            list.get(i).push(buffer.pop());
            move(buffer, list.get(i + 1));
        }

    }

    private void move(Stack<Integer> source, Stack<Integer> dest) {
        while (!source.isEmpty()) {
            dest.push(source.pop());
        }
    }

    public static void main(String[] args) {

        SetOfStacks set = new SetOfStacks(4);

        for (int i = 1; i < 20; i++) {
            set.push(i);
        }

        set.popAt(1);
        set.pop();

    }
}
