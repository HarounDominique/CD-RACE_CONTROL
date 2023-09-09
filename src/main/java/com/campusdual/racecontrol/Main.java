package com.campusdual.racecontrol;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //region IMPORT JSON

        //TODO: IMPORTAR OBJETOS EN LUGAR DE INSTANCIARLOS

        //endregion

        //region GARAGES
        Garage citroen = new Garage("CitroënTeam");
        Garage subaru = new Garage("SubaruTeam");
        Garage bmw = new Garage("BMWTeam");
        Garage audi = new Garage("AudiTeam");
        Garage mercedes = new Garage("MercedesBenzTeam");
        Garage vw = new Garage("VolkswagenTeam");

        ArrayList<Garage> garagesArrayList = new ArrayList<>(Arrays.asList(citroen, subaru, bmw, audi, mercedes, vw));
        //endregion

        //region CARS
        Car c1 = new Car("Citroën", "Saxo", "citroen");
        Car c2 = new Car("Citroën", "2CV", "citroen");
        Car c3 = new Car("Citroën", "Elysée", "citroen");
        ArrayList<Car> citroenCars = new ArrayList<>(Arrays.asList(c1, c2, c3));
        citroen.setCars(citroenCars);

        Car s1 = new Car("Subaru", "Impreza", "subaru");
        Car s2 = new Car("Subaru", "Legacy", "subaru");
        Car s3 = new Car("Subaru", "BRZ", "subaru");
        ArrayList<Car> subaruCars = new ArrayList<>(Arrays.asList(s1, s2, s3));
        subaru.setCars(subaruCars);

        Car b1 = new Car("BMW", "M3-GTR", "bmw");
        Car b2 = new Car("BMW", "M1", "bmw");
        Car b3 = new Car("BMW", "Z4", "bmw");
        ArrayList<Car> bmwCars = new ArrayList<>(Arrays.asList(b1, b2, b3));
        bmw.setCars(bmwCars);

        Car a1 = new Car("Audi", "R8", "audi");
        Car a2 = new Car("Audi", "Quattro", "audi");
        Car a3 = new Car("Audi", "A4", "audi");
        ArrayList<Car> audiCars = new ArrayList<>(Arrays.asList(a1, a2, a3));
        audi.setCars(audiCars);

        Car m1 = new Car("Mercedes", "CLK-GTR", "mercedes");
        Car m2 = new Car("Mercedes", "300SL", "mercedes");
        Car m3 = new Car("Mercedes", "AMG-GT", "mercedes");
        ArrayList<Car> mercedesCars = new ArrayList<>(Arrays.asList(m1, m2, m3));
        mercedes.setCars(mercedesCars);

        Car v1 = new Car("Volkswagen", "Golf-GTI", "vw");
        Car v2 = new Car("Volkswagen", "Polo-R", "vw");
        Car v3 = new Car("Volkswagen", "Corrado", "vw");
        ArrayList<Car> vwCars = new ArrayList<>(Arrays.asList(v1, v2, v3));
        vw.setCars(vwCars);

        ArrayList<ArrayList<Car>> carsArrayList = new ArrayList<>(Arrays.asList(citroenCars, subaruCars, bmwCars, audiCars, mercedesCars, vwCars));

        //endregion


        //region EXPORT JSON



        /**EXPORTAR COCHES**/

        Car c = new Car("","","");
        c.exportJSONToFile(carsArrayList);

        /**EXPORTAR GARAGES**/

        Garage g = new Garage();
        g.exportJSONToFile(garagesArrayList);

        //endregion

        Control control = new Control();

        control.setGarages(garagesArrayList);

        control.ui();

    }
}