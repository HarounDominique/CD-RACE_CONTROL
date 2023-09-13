package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Garage;

import java.util.ArrayList;

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

    public EliminationRace(String name, RaceType raceType, int duration) {
        super(name, raceType, duration);
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
    }
    //endregion
}

