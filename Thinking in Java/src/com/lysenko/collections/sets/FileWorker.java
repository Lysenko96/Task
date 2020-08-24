package com.lysenko.collections.sets;

import java.io.*;
import java.util.Collections;

import java.util.TreeSet;

public class FileWorker {
    public static final String PATH = "C://Users//Gweep//IdeaProjects//LambdaTest//src//com//lysenko//collections//sets//UniqueWords.java";

    public static void main(String[] args) throws IOException {
        TreeSet<String> vowels = new TreeSet<>();
        Collections.addAll(vowels, "A O I Y U E".toLowerCase().split(" "));
        int count = 0;
        int countInWord = 0;
        FileReader fileReader = new FileReader(PATH);
        int i = -1;
        while ((i = fileReader.read()) != -1) {
            char c = (char) i;
            if (vowels.contains(String.valueOf(c).toLowerCase()) || String.valueOf(c).equals(" ") || String.valueOf(c).equals(";")) {
                if(vowels.contains(String.valueOf(c).toLowerCase())) {
                    System.out.print((char) i);
                }
                if (vowels.contains(String.valueOf(c).toLowerCase())) {
                    count++;
                    countInWord++;
                }
                if (String.valueOf(c).equals(" ") || String.valueOf(c).equals(";")) {
                    if(countInWord > 0) {
                        System.out.println(" - count: " + countInWord);
                    }
                    countInWord = 0;

                }
            }
        }
        System.out.println();
        System.out.println("count vowels: " + count);

    }

}
