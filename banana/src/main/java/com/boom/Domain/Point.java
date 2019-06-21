package com.boom.Domain;

public class Point implements Comparable<Point>{
    int value; //数值
    int type; //点的类型，0为起点，1为终点
    public Point(int v, int t){
        value=v;
        type=t;
    }
    //实现compareTo函数
    public int compareTo(Point p){
        if(this.value==p.value){
            return 0;
        }else if(this.value >p.value){
            return 1;
        }else {
            return -1;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
