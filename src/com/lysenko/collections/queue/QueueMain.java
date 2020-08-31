package com.lysenko.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        QueueFill queueFill = new QueueFill();
        Queue<Command> queue = new LinkedList<>();
        queueFill.fillQueue(queue,5,"IronMan","Hulk","Freakazoid","Wolverine","SpiderMan");
        for (Command command:queue) {
            command.operation();
        }
    }
}
