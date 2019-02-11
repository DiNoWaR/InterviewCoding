package com.denis.interview.algorithms.interviewcake.rectangularlove;

/**
 * Write a method to find the rectangular intersection of two given love rectangles.
 */
public class RectangularLove {

    private static RangeOverlap findRangeOverlap(int point1, int length1, int point2, int length2) {

        // find the highest start point and lowest end point.
        // the highest ("rightmost" or "upmost") start point is
        // the start point of the overlap.
        // the lowest end point is the end point of the overlap.
        int highestStartPoint = Math.max(point1, point2);
        int lowestEndPoint = Math.min(point1 + length1, point2 + length2);

        // return empty overlap if there is no overlap
        if (highestStartPoint >= lowestEndPoint) {
            return new RangeOverlap(0, 0);
        }

        // compute the overlap length
        int overlapLength = lowestEndPoint - highestStartPoint;

        return new RangeOverlap(highestStartPoint, overlapLength);
    }

    public static Rectangle findRectangularOverlap(Rectangle rect1, Rectangle rect2) {

        // get the x and y overlap points and lengths
        RangeOverlap xOverlap = findRangeOverlap(rect1.getLeftX(), rect1.getWidth(),
                rect2.getLeftX(), rect2.getWidth());
        RangeOverlap yOverlap = findRangeOverlap(rect1.getBottomY(), rect1.getHeight(),
                rect2.getBottomY(), rect2.getHeight());

        // return "zero" rectangle if there is no overlap
        if (xOverlap.getLength() == 0 || yOverlap.getLength() == 0) {
            return new Rectangle(0, 0, 0, 0);
        }

        return new Rectangle(
                xOverlap.getStartPoint(),
                yOverlap.getStartPoint(),
                xOverlap.getLength(),
                yOverlap.getLength()
        );
    }

    public static void main(String[] args) {

        Rectangle first = new Rectangle(1, 1, 6, 3);
        Rectangle second = new Rectangle(1, 4, 6, 3);

        System.out.println(findRectangularOverlap(first, second));

    }


}
