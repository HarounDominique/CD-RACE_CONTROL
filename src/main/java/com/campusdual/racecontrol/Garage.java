package com.campusdual.racecontrol;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Garage {
    //#region ATTRIBUTES
    private String name;
    private ArrayList<Car> cars;

    public static final String NAME = "Garage Name";
    public static final String CARS = "Garage Cars";
    //#endregion

    //#region CONTRUCTORS

    public Garage(String name, ArrayList<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public Garage(String name) {
        this.name = name;
    }
    public Garage() {
    }
    //#endregion

    //#region METHODS
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

    //import/export
    /*
    public JSONObject exportGarage(){
        JSONObject obj = new JSONObject();
        obj.put(Garage.NAME, this.getName());
        obj.put(Garage.CARS, this.getCars());
        return obj;
    }

     */

    public JSONObject exportGarage() {

        JSONObject garageJson = new JSONObject();

        garageJson.put(Garage.NAME, this.getName());
        JSONArray carsArray = new JSONArray();
        garageJson.put(Garage.CARS, carsArray);
        for (Car car : this.getCars()) {
            JSONObject carJson = new JSONObject();
            carJson.put(car.BRAND, car.getBrand());
            carJson.put(car.MODEL, car.getModel());
            carsArray.add(carJson);
        }


        return garageJson;
    }
/*
    public static Car importCar(JSONObject obj){
        String model = (String)obj.get(Car.MODEL);
        String brand = (String)obj.get(Car.BRAND);
        String garage = (String)obj.get(Car.GARAGE);
        return new Car(brand, model, garage);
    }

 */

    public static ArrayList<Garage> importGaragesFromJSON(JSONObject jsonObj) {
        ArrayList<Garage> garages = new ArrayList<>();

        try {
            for (Object teamKey : jsonObj.keySet()) {
                JSONObject teamJson = (JSONObject) jsonObj.get(teamKey);
                String garageName = teamKey.toString();

                JSONArray garageCars = (JSONArray) teamJson.get("Garage Cars");
                ArrayList<Car> cars = new ArrayList<>();

                for (Object carObj : garageCars) {
                    JSONObject carJson = (JSONObject) carObj;
                    String brand = (String) carJson.get("Brand");
                    String model = (String) carJson.get("Model");

                    Car car = new Car(brand, model, garageName);
                    cars.add(car);
                }

                Garage garage = new Garage(garageName, cars);
                garages.add(garage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return garages;
    }

    public static void exportJSONToFile(ArrayList<Garage> garagesArrayList) {
        JSONObject jsonGarages = new JSONObject();

        for (Garage g : garagesArrayList) {
            JSONObject garageJson = new JSONObject();
            jsonGarages.put(g.getName(), garageJson);
            //garageJson.put(Garage.NAME, g.getName());

            JSONArray carsArray = new JSONArray();
            for (Car c : g.getCars()) {
                JSONObject carJson = new JSONObject();
                carJson.put("Brand", c.getBrand());
                carJson.put("Model", c.getModel());
                carJson.put("Garage", c.getGarageName());
                carsArray.add(carJson);
            }
            garageJson.put("Garage Cars", carsArray);
        }

        try {
            FileWriter fileWriter = new FileWriter("allGarages.json");
            fileWriter.write(jsonGarages.toJSONString());
            fileWriter.close();
            System.out.println("Los GARAJES se han guardado en el archivo JSON.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR: Los GARAJES NO se han guardado en el archivo JSON.");
        }
    }

    public static JSONObject importJSONToFile(String fileName){
        try(FileReader r = new FileReader(fileName)){
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject)parser.parse(r);
            return obj;
        }catch(Exception e){
            return null;
        }
    }

    public Car getRandomCar() {
        if (cars.isEmpty()) {
            throw new IllegalStateException("There are no cars in the garage");
        }

        Random random = new Random();
        int index = random.nextInt(cars.size());
        return cars.get(index);
    }
    //#endregion

}
