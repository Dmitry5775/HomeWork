package com.example.compass2.logic;

public class DegreesRange {
    private int start;
    private int end;

    public DegreesRange() {
        super();
    }

    public DegreesRange(int start, int end) {
        this.start = start;
        this.end = end;

    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    public boolean contains(int degrees) {

        return start <= degrees && end >= degrees;
    }
}
