package com.denis.interview.algorithms.other.convexhull;

import java.util.*;

/**
 *
 */
public class ConvexHull {

    private enum Turn {CLOCKWISE, COUNTER_CLOCKWISE, COLLINEAR}


    public static List<Point2D> getConvexHull(List<Point2D> points) throws IllegalArgumentException {

        List<Point2D> sorted = new ArrayList<>(getSortedPointSet(points));

        if (sorted.size() < 3) {
            throw new IllegalArgumentException("can only create a convex hull of 3 or more unique points");
        }

        if (areAllCollinear(sorted)) {
            throw new IllegalArgumentException("cannot create a convex hull from collinear points");
        }

        Stack<Point2D> stack = new Stack<>();

        stack.push(sorted.get(0));
        stack.push(sorted.get(1));

        for (int i = 2; i < sorted.size(); i++) {

            Point2D head = sorted.get(i);
            Point2D middle = stack.pop();
            Point2D tail = stack.peek();

            Turn turn = getTurn(tail, middle, head);

            switch (turn) {
                case COUNTER_CLOCKWISE:
                    stack.push(middle);
                    stack.push(head);
                    break;
                case CLOCKWISE:
                    i--;
                    break;
                case COLLINEAR:
                    stack.push(head);
                    break;
            }
        }

        // close the hull
        stack.push(sorted.get(0));

        return new ArrayList<>(stack);
    }


    private static boolean areAllCollinear(List<Point2D> points) {

        if (points.size() < 2) {
            return true;
        }

        final Point2D a = points.get(0);
        final Point2D b = points.get(1);

        for (int i = 2; i < points.size(); i++) {

            Point2D c = points.get(i);

            if (getTurn(a, b, c) != Turn.COLLINEAR) {
                return false;
            }
        }
        return true;
    }

    private static Turn getTurn(Point2D a, Point2D b, Point2D c) {

        // use longs to guard against int-over/underflow
        double crossProduct = (((long) b.getX() - a.getX()) * ((long) c.getY() - a.getY())) - (((long) b.getY() - a.getY()) * ((long) c.getX() - a.getX()));

        if (crossProduct > 0) {
            return Turn.COUNTER_CLOCKWISE;
        } else if (crossProduct < 0) {
            return Turn.CLOCKWISE;
        } else {
            return Turn.COLLINEAR;
        }
    }

    private static Point2D getLowestPoint(List<Point2D> points) {

        Point2D lowest = points.get(0);

        for (int i = 1; i < points.size(); i++) {

            Point2D temp = points.get(i);

            if (temp.getY() < lowest.getY() || (temp.getY() == lowest.getY() && temp.getX() < lowest.getX())) {
                lowest = temp;
            }
        }

        return lowest;
    }

    private static Set<Point2D> getSortedPointSet(List<Point2D> points) {

        final Point2D lowest = getLowestPoint(points);
        Comparator<Point2D> point2DComparator = new PointComparator(lowest);
        TreeSet<Point2D> set = new TreeSet<>(point2DComparator);
        set.addAll(points);

        return set;
    }


}
