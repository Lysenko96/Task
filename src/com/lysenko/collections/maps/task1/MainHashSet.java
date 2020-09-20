package com.lysenko.collections.maps.task1;

import java.util.*;

public class MainHashSet {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Java");
        hashSet.add("JavaScript");
        hashSet.add("C#");
        hashSet.add("Kotlin");
        hashSet.add("Prolog");
        hashSet.add("ADA");
        hashSet.add("COBOL");
        hashSet.add("PHP");
        System.out.println(hashSet);
        List<String> list = new ArrayList<>(hashSet);
        Collections.sort(list);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(list);
        System.out.println(linkedHashSet);
    }
}
