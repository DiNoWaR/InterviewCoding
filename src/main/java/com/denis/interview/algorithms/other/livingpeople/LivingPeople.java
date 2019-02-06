package com.denis.interview.algorithms.other.livingpeople;

import java.util.Arrays;
import java.util.stream.Collector;

/**
 *
 */
public class LivingPeople {


    public static Interval getMaxAliveIntervalBruteForce(People[] people, int startYear, int endYear) {

        Interval interval = new Interval();

        interval.startYear = startYear;
        interval.endYear = endYear;
        interval.alive = 0;

        boolean endYearFound = false;


        for (int currentYear = startYear; currentYear <= endYear; currentYear++) {

            int alive = 0;

            for (People person : people) {

                if (person.getBirth() <= currentYear && person.getDeath() >= currentYear) {
                    alive++;
                }

                if (alive > interval.alive) {
                    interval.alive = alive;
                    interval.startYear = currentYear;
                    endYearFound = true;
                }

                if (alive < interval.alive && endYearFound) {
                    interval.endYear = currentYear;
                }
            }
        }

        return interval;
    }

    public static Interval getMaxAliveIntervalOptimal(People[] people, int startYear, int endYear) {

        Interval interval = new Interval();

        Integer[] births = Arrays.stream(people).map(People::getBirth).sorted().toArray(Integer[]::new);
        Integer[] deaths = Arrays.stream(people).map(People::getDeath).sorted().toArray(Integer[]::new);


        return interval;
    }


    static void bgg(Integer[] array) {
        return;
    }

    public static void main(String[] args) {

        People[] people = {new People(1814, 1842), new People(1799, 1852), new People(1815, 1840)};

        System.out.println(getMaxAliveIntervalBruteForce(people, 1800, 1840));

        bgg(new Integer[]{3, 4, 5});

    }
}
