package com.denis.interview.algorithms.interviewcake.temptracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You decide to test if your oddly-mathematical heating company is fulfilling its All-Time Max, Min, Mean and Mode Temperature Guarantee™.
 * Write a class TempTracker with these methods:
 * <p>
 * insert()—records a new temperature
 * getMax()—returns the highest temp we've seen so far
 * getMin()—returns the lowest temp we've seen so far
 * getMean()—returns the mean ↴ of all temps we've seen so far
 * getMode()—returns a mode ↴ of all temps we've seen so far
 * <p>
 * Optimize for space and time.
 * Favor speeding up the getter methods getMax(), getMin(), getMean(), and getMode() over speeding up the insert() method.
 * getMean() should return a double, but the rest of the getter methods can return integers. Temperatures will all be inserted as integers.
 * We'll record our temperatures in Fahrenheit, so we can assume they'll all be in the range 0..1100..110.
 * If there is more than one mode, return any of the modes.
 */
public class TempTracker {

    private int mode;
    private int count;

    private int min;
    private int max;

    private double mean;

    private int sum;

    private Map<Integer, Integer> map;

    private List<Integer> tracker;


    public TempTracker() {
        map = new HashMap<>();
        tracker = new ArrayList<>();
    }


    public void insert(int value) {
        map.merge(value, 1, (a, b) -> a + b);

        if (map.get(value) > count) {
            mode = value;
            count=map.get(value);
        }

        max = Math.max(max, value);
        min = Math.min(min, value);

        tracker.add(value);

        sum += value;
        mean = sum / tracker.size();
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public double getMean() {
        return mean;
    }

    public int getMode() {
        return mode;
    }

    public static void main(String[] args) {
        TempTracker tempTracker = new TempTracker();

        tempTracker.insert(2);
        tempTracker.insert(1);
        tempTracker.insert(2);
        tempTracker.insert(1);
        tempTracker.insert(4);
        tempTracker.insert(1);
        tempTracker.insert(2);
        tempTracker.insert(6);
        tempTracker.insert(8);
        tempTracker.insert(3);
        tempTracker.insert(2);
        tempTracker.insert(1);

        System.out.println(tempTracker.getMode());
    }
}
