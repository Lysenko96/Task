package com.lysenko.collections.maps.task0;

public class Gerbil {
    static int newGerbilNumber;
    int gerbilInt = newGerbilNumber;
    int gerbilNumber;
    String name;

    Gerbil(String name, int gerbilNumber) {
        this.name = name;
        this.gerbilNumber = gerbilNumber;
        newGerbilNumber++;
    }

    public void hop() {
        System.out.println("index["+gerbilInt+"]: " + this.gerbilNumber);
    }

}
