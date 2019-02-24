package com.denis.interview.algorithms.other.convexhull;

import java.util.Comparator;


public class PointComparator implements Comparator<Point2D> {

    private Point2D lowest;

    public PointComparator(Point2D lowest) {
        this.lowest = lowest;
    }


    @Override
    public int compare(Point2D p1, Point2D p2) {

        if (p1 == p2 || p1.equals(p2)) {
            return 0;
        }

        // use longs to guard against int-underflow
        double thetaA = Math.atan2((long) p1.getY() - lowest.getY(), (long) p1.getX() - lowest.getX());
        double thetaB = Math.atan2((long) p2.getY() - lowest.getY(), (long) p2.getX() - lowest.getX());

        if (thetaA < thetaB) {
            return -1;
        } else if (thetaA > thetaB) {
            return 1;
        } else {
            // collinear with the 'lowest' point, let the point closest to it come first

            // use longs to guard against int-over/underflow
            double distanceA = Math.sqrt((((long) lowest.getX() - p1.getX()) * ((long) lowest.getX() - p1.getX())) +
                    (((long) lowest.getY() - p1.getY()) * ((long) lowest.getY() - p1.getY())));

            double distanceB = Math.sqrt((((long) lowest.getX() - p2.getX()) * ((long) lowest.getX() - p2.getX())) +
                    (((long) lowest.getY() - p2.getY()) * ((long) lowest.getY() - p2.getY())));

            if (distanceA < distanceB) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
