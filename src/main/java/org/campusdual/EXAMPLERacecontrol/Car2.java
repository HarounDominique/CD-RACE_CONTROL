package org.campusdual.EXAMPLERacecontrol;

import util.Input;
import util.Utils;

import java.util.Random;

public class Car2 implements Comparable<Car2>{
    private String brand;
    private String model;
    private String garageName = "";
    public final int MAX_VELOCITY = 200;
    private int speedometer = 0;
    private double distance = 0.0;

    //region CONSTRUCTORS
    public Car2() {
        this.brand = Input.string("Marca del coche: ");
        this.model = Input.string("Modelo del coche: ");
        //this.garageName = Input.string("Garaje del coche: ");
    }

    public Car2(String brand, String model) {
        this.brand = brand;
        this.model = model;
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
                ", MAX_VELOCITY=" + MAX_VELOCITY +
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

    //endregion

    public static void main(String[] args) {
        //Car2 c = new Car2();
        //System.out.println(c);

        Car2 c1 = new Car2("Seat", "Ibiza");
        System.out.println(c1);

        Car2 c2 = new Car2("Citroën", "Saxo");

        for(int i = 0; i<120; i++){
            c1.speedometerByCycle();
            c2.speedometerByCycle();
        }
        System.out.println("Velocidad coche 1 final tras 12 minutos: "+c1.getSpeedometer()+", ditancia recorrida: "+c1.getDistance());
        System.out.println("Velocidad coche 2 final tras 12 minutos: "+c2.getSpeedometer()+", ditancia recorrida: "+c2.getDistance());
        System.out.println(c1.compareTo(c2));
    }

    @Override
    public int compareTo(Car2 o) {
        if(this.getDistance() > o.getDistance()){
            return 1;
        }else if(this.getDistance()<o.getDistance()){
            return -1;
        }else {
            return 0;
        }
    }
}
