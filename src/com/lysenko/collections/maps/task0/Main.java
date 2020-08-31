package com.lysenko.collections.maps.task0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        Map<String, Gerbil> gerbilMap = new HashMap<>();
        Random random = new Random();
        Gerbil gerbil0 = new Gerbil("gerbil0", random.nextInt(23));
        Gerbil gerbil1 = new Gerbil("gerbil1", random.nextInt(63));
        Gerbil gerbil2 = new Gerbil("gerbil2", random.nextInt(75));
        gerbilMap.put(gerbil0.name, gerbil0);
        gerbilMap.put(gerbil1.name, gerbil1);
        gerbilMap.put(gerbil2.name, gerbil2);
        Iterator<String> it = gerbilMap.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            Gerbil gerbil = gerbilMap.get(key);
            System.out.print("name = " + key + " ");
            gerbil.hop();
        }
    }
}
