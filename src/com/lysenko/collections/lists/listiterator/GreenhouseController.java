package com.lysenko.collections.lists.listiterator;

import java.util.ArrayList;
import java.util.List;

public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls(2000);
        gc.addEvent(gc.new Bell(900));
        List<Event> listEvent = new ArrayList<>();
        listEvent.add(gc.new ThermostatNight(0));
        listEvent.add(gc.new LightOn(200));
        listEvent.add(gc.new LightOff(400));
        listEvent.add(gc.new WaterOn(600));
        listEvent.add(gc.new WaterOff(800));
        listEvent.add(gc.new ThermostatDay(1400));
        gc.addEvent(gc.new Restart(2000, listEvent));
        for (Event event : listEvent) {
            System.out.println(event);
        }
        new GreenhouseControls.Terminate(0).action();

    }
}
