package com.lysenko.collections.priorityqueue;

import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueMain {
    public static void main(String[] args) {
        PriorityQueue<Double> doublePriorityQueue = new PriorityQueue<>();
        fillQueue(doublePriorityQueue, 5);
        for (Double d : doublePriorityQueue) {
            System.out.println(d);
        }
        PriorityQueue<Car> priorityQueue = new PriorityQueue<>();
        fillQueueCars(priorityQueue, 4);
        for (Car car:priorityQueue) {
            System.out.println(car);
        }

    }

    static void fillQueue(PriorityQueue<Double> queue, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            queue.offer(random.nextDouble());
        }
    }
    static void fillQueueCars(PriorityQueue<Car> queue, int size) {
        for (int i = 0; i < size; i++) {
            queue.offer(new Car());
        }
    }

}
class Car implements Comparable<Car>{

    @Override
    public int compareTo(Car o) {
        return 0;
    }
}
