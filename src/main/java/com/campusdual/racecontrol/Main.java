package com.campusdual.racecontrol;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.campusdual.EXAMPLERacecontrol.Car2;

public class Main {
    public static void main(String[] args) {

        //region GARAGES
        Garage citroen = new Garage("CitroënTeam");
        Garage subaru = new Garage("SubaruTeam");
        Garage bmw = new Garage("BMWTeam");
        Garage audi = new Garage("AudiTeam");
        Garage mercedes = new Garage("MercedesBenzTeam");
        Garage vw = new Garage("VolkswagenTeam");
        //endregion

        //region CARS
        Car2 c1 = new Car2("Citroën", "Saxo", "citroen");
        Car2 c2 = new Car2("Citroën", "2CV", "citroen");
        Car2 c3 = new Car2("Citroën", "Elysée", "citroen");
        ArrayList<Car2> citroenCars = new ArrayList<>(Arrays.asList(c1, c2, c3));
        citroen.setCars(citroenCars);

        Car2 s1 = new Car2("Subaru", "Impreza", "subaru");
        Car2 s2 = new Car2("Subaru", "Legacy", "subaru");
        Car2 s3 = new Car2("Subaru", "BRZ", "subaru");
        ArrayList<Car2> subaruCars = new ArrayList<>(Arrays.asList(s1, s2, s3));
        subaru.setCars(subaruCars);

        Car2 b1 = new Car2("BMW", "M3-GTR", "bmw");
        Car2 b2 = new Car2("BMW", "M1", "bmw");
        Car2 b3 = new Car2("BMW", "Z4", "bmw");
        ArrayList<Car2> bmwCars = new ArrayList<>(Arrays.asList(b1, b2, b3));
        bmw.setCars(bmwCars);

        Car2 a1 = new Car2("Audi", "R8", "audi");
        Car2 a2 = new Car2("Audi", "Quattro", "audi");
        Car2 a3 = new Car2("Audi", "A4", "audi");
        ArrayList<Car2> audiCars = new ArrayList<>(Arrays.asList(a1, a2, a3));
        audi.setCars(audiCars);

        Car2 m1 = new Car2("Mercedes", "CLK-GTR", "mercedes");
        Car2 m2 = new Car2("Mercedes", "300SL", "mercedes");
        Car2 m3 = new Car2("Mercedes", "AMG-GT", "mercedes");
        ArrayList<Car2> mercedesCars = new ArrayList<>(Arrays.asList(m1, m2, m3));
        mercedes.setCars(mercedesCars);

        Car2 v1 = new Car2("Volkswagen", "Golf-GTI", "vw");
        Car2 v2 = new Car2("Volkswagen", "Polo-R", "vw");
        Car2 v3 = new Car2("Volkswagen", "Corrado", "vw");
        ArrayList<Car2> vwCars = new ArrayList<>(Arrays.asList(v1, v2, v3));
        vw.setCars(vwCars);

        ArrayList<ArrayList<Car2>> teams = new ArrayList<>(Arrays.asList(citroenCars, subaruCars, bmwCars, audiCars, mercedesCars, vwCars));

        //endregion



        //region EXPORT JSON

        JSONArray jsonArray = new JSONArray();

        JSONObject carJson;
        for (ArrayList<Car2> a : teams){
            for (Car2 c : a) {
                carJson = c.exportCar();
                jsonArray.add(carJson);
            }
        }

        try {
            FileWriter fileWriter = new FileWriter("allGarageCars.json");
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.close();
            System.out.println("Los coches se han guardado en el archivo JSON.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR: Los coches NO se han guardado en el archivo JSON.");
        }


        //endregion

        //region IMPORT JSON



        //endregion


        Control c = new Control();

        ArrayList<Garage> garages = new ArrayList<>(Arrays.asList(citroen, subaru, bmw, audi, mercedes, vw));
        c.setGarages(garages);

        c.ui();

    }
}