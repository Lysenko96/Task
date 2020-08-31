package com.lysenko.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueFill {
    //Queue<Command> commandQueue = new LinkedList<Command>();
    public void fillQueue(Queue<Command> commandQueue, int size, String ... name) {
        for (int i = 0; i < size; i++) {
            commandQueue.offer(new Command(name[i]));
        }
        for (Command command:commandQueue) {
            System.out.println(command);
        }
    }
}
