package com.lysenko.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Collection<Integer> c = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            c.add(i);
        }
        for (Integer i: c) {
            if(i < 9)
            System.out.print(i + ", ");
            else
                System.out.print(i);
        }
    }
}
