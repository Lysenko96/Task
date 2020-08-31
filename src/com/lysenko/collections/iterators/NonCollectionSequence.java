package com.lysenko.collections.iterators;

import java.util.*;

public class NonCollectionSequence extends Pet {
    static Pet[] pets = Pet.createArray();
    List<Pet> list = new ArrayList<>(Arrays.asList(pets));

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

    public Iterator<Pet> reverse() {
        return new Iterator<Pet>() {
            private int index = pets.length - 1;

            @Override
            public boolean hasNext() {
                return index > -1;
            }

            @Override
            public Pet next() {
                return pets[index--];
            }
        };
    }

    public static Iterable<Pet> randomize() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                List<Pet> list1 = new ArrayList<>(Arrays.asList(pets));
                Collections.shuffle(list1, new Random());
                return list1.iterator();
            }
        };
    }

    private static void display(Collection<Pet> collection) {
        Iterator<Pet> it = collection.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println();
    }

    private static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            System.out.print(it.next().toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        display(nc.iterator());
        display(nc.reverse());
        display(nc.list);
        display(randomize().iterator());

    }
}
