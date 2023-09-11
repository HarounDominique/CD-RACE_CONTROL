package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Garage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
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

    public static void exportJSONToFile(ArrayList<Race> racesList) {
        JSONObject jsonRaces = new JSONObject();
        JSONArray racesArray = new JSONArray();

        for (Race race : racesList) {
            JSONObject raceJson = new JSONObject();
            raceJson.put("Name", race.getName());
            raceJson.put("RaceType", race.getRaceType().name());
            raceJson.put("DurationInMinutes", race.getDurationInMinutes());

            if (race.getParticipatingGarages() != null) {
                raceJson.put("ParticipatingGarages", race.getParticipatingGarages());
            } else {
                raceJson.put("ParticipatingGarages", "null");
            }

            if (race.getParticipatingCars() != null) {
                raceJson.put("ParticipatingCars", race.getParticipatingCars());
            } else {
                raceJson.put("ParticipatingCars", "null");
            }

            racesArray.add(raceJson);
        }

        jsonRaces.put("Races", racesArray);

        try {
            FileWriter fileWriter = new FileWriter("allRaces.json");
            fileWriter.write(jsonRaces.toJSONString());
            fileWriter.close();

            System.out.println("Las carreras se han guardado en el archivo JSON.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR: Las carreras NO se han guardado en el archivo JSON.");
        }
    }


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

    public abstract void startRace(ArrayList<Car> participatingCars);

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
