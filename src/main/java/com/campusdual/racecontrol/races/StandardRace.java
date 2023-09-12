package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Control;
import com.campusdual.racecontrol.Garage;

import java.util.ArrayList;

public class StandardRace extends Race {
    //region ATTRIBUTES
    public final String NAME = "Standard    race";
    public final int DURATION = 180;
    public final RaceType RACE_TYPE = RaceType.STANDARD;
    //endregion

    //region CONSTRUCTOR

    public StandardRace(String name, int duration) {
        super.setName(name);
        super.setDurationInMinutes(duration);
        super.setRaceType(this.RACE_TYPE);
    }

    public StandardRace(String name, int duration, ArrayList<Garage> participatingGarages, ArrayList<Car> participatingCars) {
        super(name, participatingGarages, participatingCars);
        super.setDurationInMinutes(duration);
        super.setRaceType(this.RACE_TYPE);
    }

    public StandardRace(ArrayList<Garage> participatingGarages, ArrayList<Car> participatingCars) {
        super(participatingGarages, participatingCars);
        super.setName(this.NAME);
        super.setDurationInMinutes(this.DURATION);
        super.setRaceType(this.RACE_TYPE);
    }

    public StandardRace() {
        super.setName(this.NAME);
        super.setDurationInMinutes(this.DURATION);
        super.setRaceType(this.RACE_TYPE);
    }
    //endregion

    //region METHODS
    @Override
    public void startRace() {
        // Todo: actualizar el podium cuando finaliza la carrera
        int counter = 0;
        Car firstCar = null;
        Car secondCar = null;
        Car thirdCar = null;

        for (Car c : this.getParticipatingCars()) {
            counter++;
            for (int minutes = 0; minutes < this.DURATION; minutes++) {
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
                    } else if (c.getDistance() < firstCar.getDistance() && (secondCar == null || c.getDistance() > secondCar.getDistance())) {
                        thirdCar = secondCar;
                        secondCar = c;
                    } else if (c.getDistance() < firstCar.getDistance() && (secondCar == null || c.getDistance() < secondCar.getDistance())) {
                        thirdCar = c;
                    }
                }
            }
        }

        Control c = new Control();

        System.out.println(firstCar.getGarageName() + " win the GOLD MEDAL with the " + firstCar.getBrand() + " " + firstCar.getModel() + "; with a total distance of " + firstCar.getDistance() / 1000 + "Kms.");
        c.pause(1000);

        if (secondCar != null) {
            System.out.println(secondCar.getGarageName() + " win the SILVER MEDAL with the " + secondCar.getBrand() + " " + secondCar.getModel() + "; with a total distance of " + secondCar.getDistance() / 1000 + "Kms.");
            c.pause(1000);
        } else {
            System.out.println("No second place (Silver Medal) winner.");
        }

        if (thirdCar != null) {
            System.out.println(thirdCar.getGarageName() + " win the BRONZE MEDAL with the " + thirdCar.getBrand() + " " + thirdCar.getModel() + "; with a total distance of " + thirdCar.getDistance() / 1000 + "Kms.");
        } else {
            System.out.println("No third place (BRONZE MEDAL) winner.");
        }
    }
    //endregion
}
