package com.lysenko.collections.iterator.foreach;

import java.util.ArrayList;
import java.util.List;

public class Shapes {
    public static void main(String[] args) {
        List<Shape> list = new ArrayList<>();
        RandomShapeGenerator rg = new RandomShapeGenerator(4, list);
        rg.returnShapes();   
    }
}
