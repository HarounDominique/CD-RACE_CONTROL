package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Garage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
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

    public Race(String name, int duration, ArrayList<Garage> participatingGarages, ArrayList<Car> participatingCars) {
        this.name = name;
        this.durationInMinutes = duration;
        this.participatingGarages = participatingGarages;
        this.participatingCars = participatingCars;
    }

    public Race() {
    }
    //#endregion

    //#region METHODS

    public static ArrayList<Race> importRacesFromJSON(String filePath) {
        ArrayList<Race> races = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));

            JSONObject jsonObj = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObj.get("Races");

            races.clear();

            for (Object carObj : jsonArray) {
                JSONObject raceJson = (JSONObject) carObj;
                long durationLong = (Long) raceJson.get("DurationInMinutes");
                int duration = (int) durationLong;
                String raceType = (String) raceJson.get("RaceType");
                ArrayList<Car> participatingCars = (ArrayList<Car>) raceJson.get("ParticipatingCars");
                ArrayList<Garage> participatingGarages = (ArrayList<Garage>) raceJson.get("ParticipatingGarages");
                String name = (String) raceJson.get("Name");

                if(raceType.equals("STANDARD")){
                    if(participatingCars!=null&&participatingGarages!=null){
                        StandardRace r = new StandardRace(name, duration, participatingGarages, participatingCars);
                        races.add(r);
                    }else{
                        StandardRace r = new StandardRace(name, duration);
                        races.add(r);
                    }

                }else if(raceType.equals("ELIMINAT")){
                    if(participatingCars!=null&&participatingGarages!=null){
                        EliminationRace r = new EliminationRace(name, duration, participatingGarages, participatingCars);
                        races.add(r);
                    }else{
                        EliminationRace r = new EliminationRace(name, duration);
                        races.add(r);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return races;
    }

//    public static void exportJSONToFile(ArrayList<Race> racesList) {
//        JSONObject jsonRaces = new JSONObject();
//        JSONArray racesArray = new JSONArray();
//
//        for (Race race : racesList) {
//            JSONObject raceJson = new JSONObject();
//            raceJson.put("Name", race.getName());
//            raceJson.put("RaceType", race.getRaceType().name());
//            raceJson.put("DurationInMinutes", race.getDurationInMinutes());
//
//            if (race.getParticipatingGarages() != null) {
//                raceJson.put("ParticipatingGarages", race.getParticipatingGarages());
//            } else {
//                raceJson.put("ParticipatingGarages", "null");
//            }
//
//            if (race.getParticipatingCars() != null) {
//                raceJson.put("ParticipatingCars", race.getParticipatingCars());
//            } else {
//                raceJson.put("ParticipatingCars", "null");
//            }
//
//            racesArray.add(raceJson);
//        }
//
//        jsonRaces.put("Races", racesArray);
//
//        try {
//            FileWriter fileWriter = new FileWriter("allRaces.json");
//            fileWriter.write(jsonRaces.toJSONString());
//            fileWriter.close();
//
//            System.out.println("Las carreras se han guardado en el archivo JSON.");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("ERROR: Las carreras NO se han guardado en el archivo JSON.");
//        }
//    }

    public static void exportJSONToFile(ArrayList<Race> racesList) {
        JSONObject jsonRaces = new JSONObject();
        JSONArray racesArray = new JSONArray();

        for (Race race : racesList) {
            JSONObject raceJson = new JSONObject();
            raceJson.put("Name", race.getName());

            // Verifica si race.getRaceType() es null antes de llamar a name()
            if (race.getRaceType() != null) {
                raceJson.put("RaceType", race.getRaceType().name());
            } else {
                raceJson.put("RaceType", RaceType.STANDARD.name());
            }

            raceJson.put("DurationInMinutes", race.getDurationInMinutes());

            // Corrección: Almacena ParticipatingGarages como un arreglo JSON vacío si es nulo.
            if (race.getParticipatingGarages() != null) {
                raceJson.put("ParticipatingGarages", race.getParticipatingGarages());
            } else {
                raceJson.put("ParticipatingGarages", new JSONArray());
            }

            // Corrección: Almacena ParticipatingCars como un arreglo JSON vacío si es nulo.
            if (race.getParticipatingCars() != null) {
                raceJson.put("ParticipatingCars", race.getParticipatingCars());
            } else {
                raceJson.put("ParticipatingCars", new JSONArray());
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
