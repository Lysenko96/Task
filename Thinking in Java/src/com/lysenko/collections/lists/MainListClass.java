package com.lysenko.collections.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainListClass {
    public static void main(String[] args) {
        Cars[] arrCars = new Cars[5];
        for (int i = 0; i < arrCars.length; i++) {
            arrCars[i] = new Cars();
        }
        System.out.println("arrCars");
        for (Cars arrCar : arrCars) {
            System.out.println(arrCar);
        }
        List<Cars> carsList = new ArrayList<>(Arrays.asList(arrCars));
        System.out.println("CarsList");
        for (Cars cars : carsList) {
            System.out.println(cars);
        }

        List<Cars> newCarsList = carsList.subList(1, 3);
        System.out.println("newCarsList");
        for (Cars newCars : newCarsList) {
            System.out.println(newCars);
        }
        carsList.removeAll(newCarsList);
        System.out.println("CarsList");
        for (Cars cars:carsList) {
            System.out.println(cars);
        }
    }

    static class Cars {

    }
}
