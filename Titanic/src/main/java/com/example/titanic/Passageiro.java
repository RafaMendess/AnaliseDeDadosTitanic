package com.example.titanic;

public class Passageiro {
    private boolean survived;
    private String pClass;
    private String name;
    private String sex;
    private int age;
    private int siblingsOnBoard;
    private int childrenOnBoard;
    private double fare;

    public Passageiro(int survived, String pClass, String name, String sex, int age, int siblingsOnBoard, int childrenOnBoard, double fare) {
        this.survived = survived==0;
        this.pClass = pClass;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.siblingsOnBoard = siblingsOnBoard;
        this.childrenOnBoard = childrenOnBoard;
        this.fare = fare;
    }

    public boolean isSurvived() {
        return survived;
    }

    public void setSurvived(boolean survived) {
        this.survived = survived;
    }

    public String getpClass() {
        return pClass;
    }

    public void setpClass(String pClass) {
        this.pClass = pClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSiblingsOnBoard() {
        return siblingsOnBoard;
    }

    public void setSiblingsOnBoard(int siblingsOnBoard) {
        this.siblingsOnBoard = siblingsOnBoard;
    }

    public int getChildrenOnBoard() {
        return childrenOnBoard;
    }

    public void setChildrenOnBoard(int childrenOnBoard) {
        this.childrenOnBoard = childrenOnBoard;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
