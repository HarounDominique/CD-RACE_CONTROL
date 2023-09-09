package com.campusdual.racecontrol;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import util.Input;
import util.Utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Car implements Comparable<Car>{
    //region ATTRIBUTES
    private String brand;
    private String model;
    private String garageName = "";
    public final int MAX_VELOCITY = 200;
    private int speedometer = 0;
    private double distance = 0.0;

    public static final String BRAND = "Brand";
    public static final String MODEL = "Model";
    public static final String GARAGE = "Garage";

    //endregion

    //region CONSTRUCTORS
    public Car() {
        this.brand = Input.string("Marca del coche: ");
        this.model = Input.string("Modelo del coche: ");
        this.garageName = Input.string("Garaje del coche: ");
    }

    public Car(String brand, String model, String garageName) {
        this.brand = brand;
        this.model = model;
        this.garageName = garageName;
    }
    //endregion

    //region METHODS

    public void speedUp(){
        if(this.speedometer<this.MAX_VELOCITY){
            this.speedometer+=10;
        }
    }
    public void slowDown(){
        if(this.speedometer>0){
            this.speedometer-=10;
        }
    }
    public void speedometerByCycle(){
        int isAccelerating = Utils.getRandomNumberInRange(1,3);

        if(isAccelerating!=2){
            speedUp();
        }else{
            slowDown();
        }
        updateDistance();
    }

    public void updateDistance(){
        this.distance += speedometer * 16.667;
    }

    @Override
    public String toString() {
        return "Car2{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", garageName='" + garageName + '\'' +
                ", speedometer=" + speedometer +
                ", distance=" + distance +
                '}';
    }

    public int getSpeedometer() {
        return speedometer;
    }

    public void setSpeedometer(int speedometer) {
        this.speedometer = speedometer;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    //import/export

    public JSONObject exportCar(){
        JSONObject obj = new JSONObject();
        obj.put(Car.BRAND, this.getBrand());
        obj.put(Car.MODEL, this.getModel());
        obj.put(Car.GARAGE, this.getGarageName());
        return obj;
    }


    public static ArrayList<Car> importCarsFromJSON(JSONObject jsonObj) {


        ArrayList<Car> cars = new ArrayList<>();

        try {
            JSONArray jsonArray = (JSONArray) jsonObj.get("Cars");

            for (Object obj : jsonArray) {
                JSONObject carJson = (JSONObject) obj;
                String brand = (String) carJson.get("Brand");
                String model = (String) carJson.get("Model");
                String garageName = (String) carJson.get("Garage");

                Car car = new Car(brand, model, garageName);
                cars.add(car);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cars;
    }

    public static void exportJSONToFile(ArrayList<ArrayList<Car>> carsArrayList) {
        try {
            // Crear un objeto JSON principal
            JSONObject mainObject = new JSONObject();

            // Crear un arreglo JSON para almacenar los coches
            JSONArray carsArray = new JSONArray();

            // Iterar a través de los garajes
            for (ArrayList<Car> garageCars : carsArrayList) {
                for (Car car : garageCars) {
                    // Crear un objeto JSON para cada coche
                    JSONObject carJson = new JSONObject();
                    carJson.put("Brand", car.getBrand());
                    carJson.put("Model", car.getModel());
                    carJson.put("Garage", car.getGarageName());

                    // Agregar el objeto coche al arreglo de coches
                    carsArray.add(carJson);
                }
            }

            // Agregar el arreglo de coches al objeto principal con la clave "Cars"
            mainObject.put("Cars", carsArray);

            // Escribir el objeto JSON en un archivo
            FileWriter fileWriter = new FileWriter("allCars.json");
            fileWriter.write(mainObject.toJSONString());
            fileWriter.close();

            System.out.println("Los COCHES se han guardado en el archivo JSON.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR: Los COCHES NO se han guardado en el archivo JSON.");
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

    //endregion

    //region INTERFACE METHOD
    @Override
    public int compareTo(Car o) {
        if(this.getDistance() > o.getDistance()){
            return 1;
        }else if(this.getDistance()<o.getDistance()){
            return -1;
        }else {
            return 0;
        }
    }

    //endregion

    public static void main(String[] args) {
        //Car2 c = new Car2();
        //System.out.println(c);

        Car c1 = new Car("Seat", "Ibiza", "SeatTeam");
        System.out.println(c1);

        Car c2 = new Car("Citroën", "Saxo", "CitroënTeam");

        for(int i = 0; i<120; i++){
            c1.speedometerByCycle();
            c2.speedometerByCycle();
        }
        System.out.println("Velocidad coche 1 final tras 12 minutos: "+c1.getSpeedometer()+", ditancia recorrida: "+c1.getDistance());
        System.out.println("Velocidad coche 2 final tras 12 minutos: "+c2.getSpeedometer()+", ditancia recorrida: "+c2.getDistance());
        System.out.println(c1.compareTo(c2));
    }

}
