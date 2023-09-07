package com.campusdual.racecontrol;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class Car {

    //#region ATTRIBUTES

    public static final String BRAND = "Brand";
    public static final String MODEL = "Model";
    public static final String GARAGE = "Garage";
    private final int MAX_VELOCITY = 200;
    private String brand;
    private String model;
    private Garage garage;
    //#endregion

    //#region CONTRUCTOR
    public Car(String brand, String model, Garage garage) {
        this.brand = brand;
        this.model = model;
        this.garage = garage;
    }
    //#endregion

    //#region METHODS
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
        obj.put(Car.GARAGE, this.garage.getName());
        return obj;
    }

    public static Car importCar(JSONObject obj){
        String model = (String)obj.get(Car.MODEL);
        String brand = (String)obj.get(Car.BRAND);
        Garage garage = (Garage)obj.get(Car.GARAGE); //todo hacer que devuelva un string con el nombre del garaje en lugar de un obj garaje ->
        // necesita devolver un objeto garaje para poner instanciar el objeto coche; porlo que deberemos incluir algún iterador que busque entre todos los garajes el que
        //coincida con el nombre que recuperamos del archivo json
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
    //#endregion

/*
    public static void main(String[] args) {
       Car c = new Car("Renault", "Megane");
        System.out.println(c.exportCar());

        JSONObject jsonObject = c.exportCar();
        Car c2 = Car.importCar(jsonObject);
        c2.toString();

        //Car.exportJSONToFile(jsonObject);
        //Car.importJSONToFile("test2.json");

    }

 */
}
