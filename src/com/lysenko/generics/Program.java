package com.lysenko.generics;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            gerbils.add(new Gerbil(i));
        }
        for (Gerbil gerbil:gerbils) {
            System.out.println(gerbil.toString());
        }
    }
}

class Gerbil {
    private int gerbilNumber;
    Gerbil(int count){
        this.gerbilNumber = count;
    }

    @Override
    public String toString() {
        return "Gerbil{" +
                "gerbilNumber=" + gerbilNumber +
                '}';
    }
}
