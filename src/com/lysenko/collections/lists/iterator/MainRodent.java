package com.lysenko.collections.lists.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainRodent {
    public static void main(String[] args) {
        List<Rodent> list = new ArrayList<>();
        list.add(new Mouse("маус0",5));
        list.add(new Mouse("маус1",2));
        list.add(new Hamster("хома0", 1));
        list.add(new Hamster("хома1", 4));
        Rodent rodent = new Rodent();
        rodent.display(list);
    }
}

class Rodent {
    int age;
    static int id;
    Rodent() {
    }

    Rodent(int age) {
        this.age = age;
        Rodent.id++;
    }

    public String toString() {
        return " age: " + age;
    }

    String action(String action) {
        action += this.getClass();
        return action;
    }

    void display(List<Rodent> list) {
        Iterator<Rodent> it = list.iterator();
        while (it.hasNext()) {
            Rodent rodent = it.next();
            System.out.println();
            System.out.println(rodent.toString());
            System.out.println(rodent.action("action: "));
            System.out.println(rodent.catchRodent("catch: "));

        }

    }

    String catchRodent(String catchRodent) {
        catchRodent += this.getClass();
        return catchRodent;
    }
}

class Mouse extends Rodent {
    String name;
    int myId = Rodent.id;
    Mouse(){}
    Mouse(String name, int age) {
        super(age);
        this.name = name;
    }

    @Override
    String action(String action) {
        return super.action(action) + " Грызет сыр";
    }

    @Override
    String catchRodent(String catchRodent) {
        return super.catchRodent(catchRodent) + " Мыша поймана";
    }

    @Override
    public String toString() {
        return "name: " + name + super.toString() + " id: " + this.myId;
    }
}

class Hamster extends Rodent {
    Hamster(){}
    String name;
    int myId = Rodent.id;
    Hamster(String name, int age) {
        super(age);
        this.name = name;
    }

    @Override
    String action(String action) {
        return super.action(action) + " Хомячит семки";
    }

    @Override
    String catchRodent(String catchRodent) {
        return super.catchRodent(catchRodent) + " Грызун пойман";
    }

    @Override
    public String toString() {
        return "name: " + name + super.toString() + " id: " + this.myId;
    }
}