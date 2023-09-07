package com.campusdual.racecontrol;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class Car {

    public static final String BRAND = "brand";
    public static final String MODEL = "model";
    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return this.getBrand()+" "+this.getModel();
    }

    public JSONObject exportCar(){
        JSONObject obj = new JSONObject();
        obj.put(Car.BRAND, this.getBrand());
        obj.put(Car.MODEL, this.getModel());
        return obj;
    }

    public static Car importCar(JSONObject obj){
        String model = (String)obj.get(Car.MODEL);
        String brand = (String)obj.get(Car.BRAND);
        return new Car(brand, model);
    }

    public static void exportJSONToFile(JSONObject obj){
        try(FileWriter fw = new FileWriter("text.json")){
            fw.write(obj.toJSONString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static JSONObject importtJSONToFile(String fileName){
        try(FileReader r = new FileReader(fileName)){
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject)parser.parse(r);
            return obj;
        }catch(Exception e){
            return null;
        }
    }


    public static void main(String[] args) {
       Car c = new Car("Renault", "Megane");
        System.out.println(c.exportCar());

        JSONObject jsonObject = c.exportCar();
        Car c2 = Car.importCar(jsonObject);
        c2.toString();

        //Car.exportJSONToFile(jsonObject);
        //Car.importtJSONToFile("test2.json");




    }
}
