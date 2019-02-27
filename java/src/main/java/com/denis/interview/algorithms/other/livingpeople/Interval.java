package com.denis.interview.algorithms.other.livingpeople;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Interval {

    public int startYear;
    public int endYear;
    public int alive;

    @Override
    public String toString() {
        return "Interval{" +
                "Start Year=" + startYear +
                ", End Year=" + endYear +
                ", Alive=" + alive +
                '}';
    }
}
