package com.denis.interview.algorithms.arrays.pancakesortingwithburntside;

public class PanCake {

    private int size;
    private boolean burntSideDown;

    public PanCake(int size, boolean burntSideUp) {
        this.size = size;
        this.burntSideDown = burntSideUp;
    }

    public int getSize() {
        return size;
    }

    public boolean isBurntSideDown() {
        return burntSideDown;
    }

    public void setBurntSideDown(boolean burntSideDown) {
        this.burntSideDown = burntSideDown;
    }

    @Override
    public String toString() {
        return "PanCake{" +
                "size=" + size +
                ", burntSideDown=" + burntSideDown +
                '}';
    }
}
