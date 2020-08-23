package com.lysenko.collections.lists.iterator;

import java.util.*;

public class MainIteratorCollection {
    public static void main(String[] args) {
        List<Car> arrayList = new ArrayList<>();
        arrayList.add(new Car("veron"));
        arrayList.add(new Car("aventador"));
        arrayList.add(new Car("bmv"));
        List<Car> linkedList = new LinkedList<>(arrayList);
        Collection<Car> hashSet = new HashSet<>(arrayList);
        Collection<Car> treeSet = new TreeSet<>(arrayList);
        displayCollection(arrayList.iterator());
        displayCollection(linkedList.iterator());
        displayCollection(hashSet.iterator());
        displayCollection(treeSet.iterator());
    }

    private static void displayCollection(Iterator<Car> it) {
        while (it.hasNext()) {
            Car car = it.next();
            System.out.print(car.toString());
        }
        System.out.println();
    }

    static class Car implements Comparable<Car> {
        String name;

        Car(String nameCar) {
            this.name = nameCar;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Car o) {
            return name.compareTo((o.name));
        }
    }
}
