package com.denis.interview.algorithms.interviewcake.rectangularlove;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Rectangle {

    // coordinates of bottom left corner
    private int leftX;
    private int bottomY;

    // dimensions
    private int width;
    private int height;

    public Rectangle(int leftX, int bottomY, int width, int height) {
        this.leftX = leftX;
        this.bottomY = bottomY;
        this.width = width;
        this.height = height;
    }

}
