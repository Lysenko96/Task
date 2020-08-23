package com.lysenko.collections.sets;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {
    public static void main(String[] args) {
        Set<String> vowels = new TreeSet<>();
        byte[] buffer = new byte[1000];
        File targetFile = new File("C:/Users/Gweep/IdeaProjects/LambdaTest/src/com/lysenko/collections/sets/SetOperations.java");
        try {

            OutputStream outputStream = new FileOutputStream(targetFile);
            try {
                outputStream.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(buffer);
        Collections.addAll(vowels, "A O I Y U E".split(" "));
        System.out.println(vowels);
    }
}
