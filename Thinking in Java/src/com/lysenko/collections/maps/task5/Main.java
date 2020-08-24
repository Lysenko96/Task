package com.lysenko.collections.maps.task5;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static final String PATH = "C://Users//Gweep//IdeaProjects//LambdaTest//src//com//lysenko//collections//sets//UniqueWords.java";

    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader(PATH);
        int i = -1;
        StringBuilder s = new StringBuilder();
        while ((i = fileReader.read()) != -1) {
            char c = (char) i;
            s.append(c);
        }
        String[] strings = s.toString().split("\\W+");
        Map<String, Integer> m = new HashMap<>();
        for (int j = 0; j < strings.length; j++) {
            String str = strings[j];
            Integer freq = m.get(str);
            m.put(str, freq == null ? 1 : freq + 1);
        }
        Set<WordCount> set = new HashSet<>();
        WordCount wordCount = new WordCount();
        for (int j = 0; j < strings.length; j++) {
            wordCount.word.add(strings[j]);
            wordCount.count.add(m.get(strings[j]));
            set.add(wordCount);
        }
        for (WordCount w : set) {
            for (int j = 0; j < strings.length; j++) {
                if (j == strings.length - 1) {
                    System.out.print(w.word.get(j) + "=" + w.count.get(j));
                } else {
                    System.out.print(w.word.get(j) + "=" + w.count.get(j) + " ");
                }
            }
        }

    }

    static class WordCount {
        List<String> word = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
    }
}
