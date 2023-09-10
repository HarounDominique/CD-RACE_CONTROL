package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Garage;

import java.util.ArrayList;

public abstract class Race {

    //#region ATTRIBUTES
    private String name;
    private RaceType raceType;
    private ArrayList<Garage> participatingGarages;
    private ArrayList<Car> participatingCars;
    private ArrayList<Car> podium;
    private int durationInMinutes;
    //#endregion

    //#region CONSTRUCTORS

    public Race(String name, RaceType raceType, int durationInMinutes, ArrayList<Garage> participatingGarages, ArrayList<Car> participatingCars) {
        this.name = name;
        this.raceType = raceType;
        this.durationInMinutes = durationInMinutes;
        this.participatingGarages = participatingGarages;
        this.participatingCars = participatingCars;
    }

    public Race(String name, ArrayList<Garage> participatingGarages, ArrayList<Car> participatingCars) {
        this.name = name;
        this.participatingGarages = participatingGarages;
        this.participatingCars = participatingCars;
    }

    public Race(ArrayList<Garage> participatingGarages, ArrayList<Car> participatingCars) {
        this.participatingGarages = participatingGarages;
        this.participatingCars = participatingCars;
    }

    public Race(String name, RaceType raceType, int duration) {
        this.name = name;
        this.raceType = raceType;
        this.durationInMinutes = duration;
    }

    public Race() {
    }
    //#endregion

    //#region METHODS


    public RaceType getRaceType() {
        return raceType;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

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

    public ArrayList<Car> getParticipatingCars() {
        return participatingCars;
    }

    public void setParticipatingCars(ArrayList<Car> participatingCars) {
        this.participatingCars = participatingCars;
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
