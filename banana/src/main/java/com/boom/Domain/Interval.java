package com.boom.Domain;

public class Interval {
    int start; //起点
    int end; //终点
    public Interval(int a, int b){
        start=a;
        end=b;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
