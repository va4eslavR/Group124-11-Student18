package com.company;

public class Pair implements Comparable<Pair> {

    double dist;
    byte label;

    public Pair(double dist, byte label) {
        this.dist = dist;
        this.label = label;
    }

    public byte getLabel() {
        return label;
    }

    public double getDist() {
        return dist;
    }


    @Override
    public int compareTo(Pair o) {
        return (int) (this.getDist() - o.dist);
    }


}

