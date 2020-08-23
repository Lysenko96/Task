package com.lysenko.collections;

import java.util.*;

public class MainClassGenerator {

    static void print(Collection<String> collection){
        System.out.println(collection.toString());
    }

    public static void main(String[] args) {
        Collection<String> arrayList = new ArrayList<>();
        Collection<String> linkedList = new LinkedList<>();
        Collection<String> hashSet = new HashSet<>();
        Collection<String> linkedHashSet = new LinkedHashSet<>();
        Collection<String> treeSet = new TreeSet<>();
        ClassGenerator classGenerator = new ClassGenerator();
        print(classGenerator.next(arrayList));
        print(classGenerator.next(linkedList));
        print(classGenerator.next(hashSet));
        print(classGenerator.next(linkedHashSet));
        print(classGenerator.next(treeSet));
    }
}
class ClassGenerator{

    public Collection<String> next(Collection<String> collection){
        collection.add("Spider man");
        collection.add("Iron man");
        collection.add("Wolverine");
        collection.add("Hulk");
        collection.add("Iron man");
        return collection;
    }

}
