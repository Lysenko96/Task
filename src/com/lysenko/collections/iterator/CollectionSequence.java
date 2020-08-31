package com.lysenko.collections.iterator;

import java.util.*;

public class CollectionSequence extends CollectionSequenceAdapter {
    private Pet[] pets = fillPets(4, "Rat", "Manx", "Cymric", "Mutt");
    Collection<Pet> collection = new ArrayList<>(Arrays.asList(pets));

    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        display(c.collection);
        display(c.iterator());
    }

    public Pet[] fillPets(int size, String... name) {
        Pet[] pets = new Pet[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            pets[i] = new Pet(name[i], random.nextInt(20));
        }
        return pets;
    }

    public static void display(Collection<Pet> pets) {
        for (Pet p : pets) {
            System.out.print(p.age + ":" + p.name + " ");
        }
        System.out.println();
    }

    public static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.age + ":" + p.name + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return pets.length;
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {

                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }
}

class Pet {
    String name;
    int age;

    Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
