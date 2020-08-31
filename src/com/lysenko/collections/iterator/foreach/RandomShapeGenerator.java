package com.lysenko.collections.iterator.foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomShapeGenerator implements Iterable<Shape> {

    private List<Shape> shapeList;
    private int size;

    public RandomShapeGenerator(int size, List<Shape> list) {
        this.size = size;
        this.shapeList = list;
    }

    private List<Shape> fillList() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    shapeList.add(new Circle());
                    break;
                case 1:
                    shapeList.add(new Square());
                    break;
                case 2:
                    shapeList.add(new Triangle());
                    break;
                default:
            }
        }
        return shapeList;
    }

    public List<Shape> returnShapes() {
        fillList();
        Iterator<Shape> it = shapeList.iterator();
        while (it.hasNext()) {
            it.next().draw();
        }
        return shapeList;
    }


    @Override
    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Shape next() {
                return shapeList.get(index++);
            }
        };
    }
}
