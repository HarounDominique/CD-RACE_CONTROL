package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Garage;

import java.util.ArrayList;

public class StandardRace extends Race {
    //region ATTRIBUTES
    public final String NAME = "Standard    race";
    public final int DURATION = 180;
    public final RaceType RACE_TYPE = RaceType.STANDARD;
    //endregion

    //region CONSTRUCTOR
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
    public void startRace(ArrayList<Car> participatingCars) {
        //todo actualizar el podium cuando finaliza la carrera
        Car fastestCar
        for(int i = 0; i<this.DURATION; i++){
            for(Car c : participatingCars){
                c.speedometerByCycle();
            }
        }
    }
    //endregion
}
