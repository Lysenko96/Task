package com.lysenko.collections.maps.task6;

import java.util.*;

public class StatisticsMain {
    public static void main(String[] args) {
        Random random = new Random();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int r = random.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : m.entrySet()) {
            list.add(pair.getValue());
        }
        System.out.print(m);
        System.out.println();
        Collections.sort(list);
        for (Map.Entry<Integer, Integer> pair : m.entrySet()) {
            if (pair.getValue().equals(list.get(list.size()-1))) {
                System.out.println(pair.getKey() + "=" + pair.getValue());
            }
        }

    }
}
