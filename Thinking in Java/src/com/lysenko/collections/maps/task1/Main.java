package com.lysenko.collections.maps.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 1);
        map.put("JavaScript", 2);
        map.put("C#", 4);
        map.put("Kotlin", 3);
        map.put("Prolog", 8);
        map.put("ADA", 7);
        map.put("COBOL", 6);
        map.put("PHP", 5);
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        System.out.println(map);
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<String, Integer> s = list.get(i);
            linkedHashMap.put(s.getKey(), s.getValue());
        }
        System.out.println(linkedHashMap);
    }
}
