package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Garage;

import java.util.ArrayList;

public abstract class Race {

    //#region ATTRIBUTES
    private String name;
    private ArrayList<Garage> participatingGarages;
    private ArrayList<Car> garagesCars;
    private ArrayList<Car> podium;
    //#endregion

    //#region CONSTRUCTORS
    public Race(String name, ArrayList<Garage> participatingGarages, ArrayList<Car> garagesCars) {
        this.name = name;
        this.participatingGarages = participatingGarages;
        this.garagesCars = garagesCars;
    }

    public Race() {
    }
    //#endregion

    //#region METHODS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Garage> getParticipatingGarages() {
        return participatingGarages;
    }

    public void setParticipatingGarages(ArrayList<Garage> participatingGarages) {
        this.participatingGarages = participatingGarages;
    }

    public ArrayList<Car> getGaragesCars() {
        return garagesCars;
    }

    public void setGaragesCars(ArrayList<Car> garagesCars) {
        this.garagesCars = garagesCars;
    }

    public ArrayList<Car> getPodium() {
        return podium;
    }

    public void setPodium(ArrayList<Car> podium) {
        this.podium = podium;
    }

    public abstract void startRace();

    protected void addToPodium(Car car) {
        podium.add(car);
    }
    /*
    protected void clearPodium() {
        podium.clear();
    }

     */
    //#endregion
}
