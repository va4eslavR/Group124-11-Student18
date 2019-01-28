package com.company;

public class ImageSolver {

    int a[];
    byte Label;


    public ImageSolver() {
    }

    public ImageSolver(int[] a) {
        this.a = a;
    }

    public ImageSolver(int[] a, byte label) {
        this.a = a;
        Label = label;
    }

    public int[] getA() {
        return a;
    }

    public void setLabel(byte label) {
        Label = label;
    }

    public byte getLabel() {
        return Label;
    }

    public double EuqDimOneImage(ImageSolver b) {
        double dim = 0;
        for (int i = 0; i < 784; i++) {
            dim = Math.sqrt(Math.pow((this.a[i] - b.a[i]), 2)) + dim;
        }
        return dim;
    }
}

