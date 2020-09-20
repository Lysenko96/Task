package com.lysenko.collections.maps.task7;

import java.util.*;

public class LinkedHashMapMain {
    public static void main(String[] args) {
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        HashMap<String,String> hashMap = new HashMap<>();
        linkedHashMap.put("IronMan", "2002");
        linkedHashMap.put("Hulk", "2004");
        linkedHashMap.put("Wolverine", "2006");
        linkedHashMap.put("SpiderMan", "2009");
        List<Map.Entry<String,String>> entryList = new ArrayList<>(linkedHashMap.entrySet());
        System.out.println(linkedHashMap);
        entryList.sort(new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        System.out.println(entryList);
        linkedHashMap.clear();
        for (int i = 0; i < entryList.size(); i++) {
            Map.Entry<String,String> map = entryList.get(i);
            linkedHashMap.put(map.getKey(), map.getValue());
        }
        System.out.println(linkedHashMap);

    }
}
