package com.lysenko.collections.sets;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {
    public static void main(String[] args) {
        Set<String> vowels = new TreeSet<>();
        Collections.addAll(vowels, "A O I Y U E".split(" "));
        System.out.println(vowels);
    }
}
