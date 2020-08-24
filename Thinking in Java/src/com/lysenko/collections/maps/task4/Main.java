package com.lysenko.collections.maps.task4;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static final String PATH = "C://Users//Gweep//IdeaProjects//LambdaTest//src//com//lysenko//collections//sets//UniqueWords.java";

    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader(PATH);
        int i = -1;
        File file = new File(PATH);
        StringBuilder s = new StringBuilder();
        while ((i = fileReader.read()) != -1) {
            char c = (char) i;
            s.append(c);
            System.out.print(c);
            if (!String.valueOf(c).equals(" ") || !String.valueOf(c).equals(";")) {
                list.add(String.valueOf(c));
            }
        }
        System.out.println(Arrays.toString(s.toString().split("\\W+")));
        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j));
        }
        String[] strings = s.toString().split("\\W+");
        for (int j = 0; j < strings.length; j++) {
            System.out.println(strings[j]);
        }
        Map<String, Integer> m = new HashMap<>();
        for (int j = 0; j < strings.length; j++) {
            String str = strings[j];
            Integer freq = m.get(str);
            m.put(str, freq == null ? 1 : freq + 1);
        }
        System.out.println("m = " + m);


        List<Map.Entry<String, Integer>> myList = new ArrayList<>(m.entrySet());
        myList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        Set<String> stringSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        for (int j = 0; j < strings.length; j++) {
            stringSet.add(strings[j]);
        }
        System.out.println("myList = " + myList);
        System.out.println("stringSet = " + stringSet);

        List<String> list1 = new ArrayList<>(m.keySet());
        list1.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("list1 = " + list1);

    }
}
