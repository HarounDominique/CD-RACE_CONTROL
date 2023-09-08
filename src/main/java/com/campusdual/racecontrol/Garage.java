package com.campusdual.racecontrol;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class Garage {
    //#region ATTRIBUTES
    private String name;
    private ArrayList<Car> cars;

    public static final String NAME = "Name";
    public static final String CARS = "Cars";
    //#endregion

    //#region CONTRUCTORS
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
        for (Car car : this.getCars()) {
            JSONObject carJson = new JSONObject();
            carJson.put("brand", car.getBrand());
            carJson.put("model", car.getModel());
            carsArray.add(carJson);
        }
        garageJson.put(Garage.CARS, carsArray);

        return garageJson;
    }

    public static Car importCar(JSONObject obj){
        String model = (String)obj.get(Car.MODEL);
        String brand = (String)obj.get(Car.BRAND);
        String garage = (String)obj.get(Car.GARAGE);
        return new Car(brand, model, garage);
    }

    public static void exportJSONToFile(JSONObject obj){
        try(FileWriter fw = new FileWriter("text.json")){
            fw.write(obj.toJSONString());
        }catch(Exception e){
            e.printStackTrace();
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
