package com.lysenko.collections.lists.listiterator;

import java.util.ArrayList;
import java.util.List;

public class Controller extends Event {
    private List<Event> eventList = new ArrayList<>();

    public Controller(long delayTime) {
        super(delayTime);
    }

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        while (eventList.size() > 0) {
            for (Event e : new ArrayList<>(eventList)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }

    @Override
    public void action() {

    }
}
