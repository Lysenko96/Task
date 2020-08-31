package com.lysenko.collections.iterators;

import java.util.Random;

public class Pet {
    private String name;
    private int age;

    Pet() {
    }

    Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static Pet[] createArray() {
        String names[] = new String[]{"Matt", "Manx", "Dog", "Pug", "Rat"};
        Pet[] pets = new Pet[names.length];
        Random random = new Random();
        for (int i = 0; i < names.length; i++) {
            pets[i] = new Pet(names[i], random.nextInt(20));
        }
        return pets;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
