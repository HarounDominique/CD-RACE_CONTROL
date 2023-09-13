package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Garage;

import java.util.ArrayList;
import java.util.Arrays;

public class EliminationRace extends Race {
    //region ATTRIBUTES
    public final String NAME = "Elimination race";
    public final int DURATION = 30; //en este caso, la duración hace referencia al tiempo de calentamiento; la duración dependerá del número de participantes
    public final RaceType RACE_TYPE = RaceType.ELIMINAT;
    //endregion

    //region CONSTRUCTORS

    public EliminationRace(String name, int duration) {
        super.setName(name);
        super.setDurationInMinutes(duration);
        super.setRaceType(this.RACE_TYPE);
    }

    public EliminationRace() {
        super.setName(this.NAME);
        super.setDurationInMinutes(this.DURATION);
        super.setRaceType(this.RACE_TYPE);
    }

    public EliminationRace(String name, RaceType raceType, int durationInMinutes, ArrayList<Garage> participatingGarages, ArrayList<Car> participatingCars) {
        super(name, raceType, durationInMinutes, participatingGarages, participatingCars);
        super.setRaceType(this.RACE_TYPE);
    }

    public EliminationRace(String name, int duration, ArrayList<Garage> participatingGarages, ArrayList<Car> participatingCars) {
        super(name, participatingGarages, participatingCars);
        super.setDurationInMinutes(duration);
        super.setRaceType(this.RACE_TYPE);
    }

    public EliminationRace(ArrayList<Garage> participatingGarages, ArrayList<Car> participatingCars) {
        super(participatingGarages, participatingCars);
        super.setName(this.NAME);
        super.setDurationInMinutes(this.DURATION);
        super.setRaceType(this.RACE_TYPE);
    }

    public EliminationRace(String name, RaceType raceType, int duration) {
        super(name, raceType, duration);
    }

    //endregion

    //region METHODS
//    @Override
//    public void startRace() {
//        // Todo: actualizar el podium cuando finaliza la carrera
//        int counter = 0;
//        Car firstCar = null;
//        Car secondCar = null;
//        Car thirdCar = null;
//
//        for (Car c : this.getParticipatingCars()) {
//            counter++;
//            for (int minutes = 0; minutes <= this.DURATION; minutes++) {
//                c.speedometerByCycle();
//            }
//
//            if (counter == 1) {
//                firstCar = c;
//            } else {
//                if (secondCar == null) {
//                    secondCar = c;
//                } else {
//                    if (c.getDistance() > firstCar.getDistance()) {
//                        thirdCar = secondCar;
//                        secondCar = firstCar;
//                        firstCar = c;
//                    } else if (c.getDistance() < firstCar.getDistance() && (secondCar == null || c.getDistance() > secondCar.getDistance())) {
//                        thirdCar = secondCar;
//                        secondCar = c;
//                    } else if (c.getDistance() < firstCar.getDistance() && (secondCar == null || c.getDistance() < secondCar.getDistance())) {
//                        thirdCar = c;
//                    }
//                }
//            }
//        }
//        //una vez finalizado el calentamiento:
//        ArrayList<Car> warmedUpCars = new ArrayList<>(Arrays.asList(firstCar, secondCar, thirdCar));
//
//        for(int i = 0; i<getParticipatingCars().size();i++){
//            firstCar.speedometerByCycle();
//            secondCar.speedometerByCycle();
//            thirdCar.speedometerByCycle();
//
//            //establecer condiciones para que el que menos distancia tenga sea excluído
//        }
//
//        for(Car c : warmedUpCars){
//
//            if(c!=null){
//
//            }
//        }
//    }

    @Override
    public void startRace() {
        // Calentamiento
        int counter = 0;
        Car firstCar = null;
        Car secondCar = null;
        Car thirdCar = null;

        Car finishFirstCar = null;
        Car finishSecondCar = null;
        Car finishThirdCar = null;

        ArrayList<Car> originalCarsList = new ArrayList<>(this.getParticipatingCars());

        for (Car c : originalCarsList) {
            counter++;
            for (int minutes = 0; minutes <= this.DURATION; minutes++) {
                c.speedometerByCycle();
            }

            if (counter == 1) {
                firstCar = c;
            } else {
                if (secondCar == null) {
                    secondCar = c;
                } else {
                    if (c.getDistance() > firstCar.getDistance()) {
                        thirdCar = secondCar;
                        secondCar = firstCar;
                        firstCar = c;
                    } else if (c.getDistance() > secondCar.getDistance()) {
                        thirdCar = secondCar;
                        secondCar = c;
                    } else if (c.getDistance() > thirdCar.getDistance()) {
                        thirdCar = c;
                    }
                }
            }
        }

        ArrayList<Car> carsInRace = new ArrayList<>(Arrays.asList(firstCar, secondCar, thirdCar));
        ArrayList<Car> carsToRemove = new ArrayList<>();

        while (carsInRace.size() > 1) {
            for (Car car : carsInRace) {
                if (car != null) {
                    car.speedometerByCycle();
                }
            }

            Car carToRemove = null;
            double maxDistance = 0.0;

            for (Car car : carsInRace) {
                if (car != null) {
                    if (car.getDistance() > maxDistance) {
                        maxDistance = car.getDistance();
                        carToRemove = car;
                    }
                }
            }

            int count=0;
            if (carToRemove != null) {
                carsToRemove.add(carToRemove);
                System.out.println("The " + carToRemove.getBrand() + " " + carToRemove.getModel() + " has been removed from the race! Total distance: "+carToRemove.getDistance());
                if(thirdCar!=null){
                    switch (count){
                        case 0:
                            count++;
                            finishThirdCar = carToRemove;
                            break;
                        case 1:
                            count++;
                            finishSecondCar = carToRemove;
                            break;
                        case 2:
                            finishFirstCar = carToRemove;
                            break;
                    }
                }else{
                    switch (count){
                        case 0:
                            count++;
                            finishSecondCar = carToRemove;
                            break;
                        case 1:
                            count++;
                            finishFirstCar = carToRemove;
                            break;
                    }
                }

            }

            carsInRace.removeAll(carsToRemove);
        }

        firstCar = carsInRace.get(0);

        secondCar = carsInRace.get(1);

        thirdCar = carsInRace.size() > 2 ? carsInRace.get(2) : null;

        System.out.println("Primer puesto: " + finishFirstCar.getModel() + " " + finishFirstCar.getBrand());
        System.out.println("Segundo puesto: " + finishSecondCar.getModel() + " " + finishSecondCar.getBrand());
        System.out.println("Tercer puesto: " + (finishThirdCar != null ? finishThirdCar.getBrand() + " " + thirdCar.getModel() : "---"));
    }

    //endregion
}

