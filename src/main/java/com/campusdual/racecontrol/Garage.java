package com.campusdual.racecontrol;

import java.util.ArrayList;
import java.util.Random;

public class Garage {
    private String name;
    private ArrayList<Car> cars;

    public Garage(String name, ArrayList<Car> cars) {
        this.name = name;
        this.cars = cars;
    }
    public Garage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public Car getRandomCar() {
        if (cars.isEmpty()) {
            throw new IllegalStateException("There are no cars in the garage");
        }

        Random random = new Random();
        int index = random.nextInt(cars.size());
        return cars.get(index);
    }

}
