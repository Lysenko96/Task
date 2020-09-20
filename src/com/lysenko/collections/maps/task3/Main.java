package com.lysenko.collections.maps.task3;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {
    public static final String PATH = "C://Users//Gweep//IdeaProjects//LambdaTest//src//com//lysenko//collections//sets//UniqueWords.java";

    public static void main(String[] args) throws IOException {
        TreeSet<String> vowels = new TreeSet<>();
        Collections.addAll(vowels, "A O I Y U E".toLowerCase().split(" "));
        int count = 0;
        int countA = 0;
        int countO = 0;
        int countI = 0;
        int countY = 0;
        int countU = 0;
        int countE = 0;
        int countInWord = 0;
        FileReader fileReader = new FileReader(PATH);
        int i = -1;
        while ((i = fileReader.read()) != -1) {
            char c = (char) i;
            if (vowels.contains(String.valueOf(c).toLowerCase()) || String.valueOf(c).equals(" ") || String.valueOf(c).equals(";")) {
                if (vowels.contains(String.valueOf(c).toLowerCase())) {
                    System.out.print((char) i);
                }
                if (vowels.contains(String.valueOf(c).toLowerCase())) {
                    if(String.valueOf(c).toLowerCase().equals("a")){
                        countA++;
                    }
                    if(String.valueOf(c).toLowerCase().equals("o")){
                        countO++;
                    }
                    if(String.valueOf(c).toLowerCase().equals("i")){
                        countI++;
                    }
                    if(String.valueOf(c).toLowerCase().equals("y")){
                        countY++;
                    }
                    if(String.valueOf(c).toLowerCase().equals("u")){
                        countU++;
                    }
                    if(String.valueOf(c).toLowerCase().equals("e")){
                        countE++;
                    }
                    count++;
                    countInWord++;
                }
                if (String.valueOf(c).equals(" ") || String.valueOf(c).equals(";")) {
                    if (countInWord > 0) {
                        System.out.println(" - count: " + countInWord);
                    }
                    countInWord = 0;

                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("a", countA);
        map.put("o", countO);
        map.put("e", countE);
        map.put("y", countY);
        map.put("u", countU);
        map.put("i", countI);
        System.out.println(map);
        System.out.println();
        System.out.println("count vowels: " + count);

    }
}
