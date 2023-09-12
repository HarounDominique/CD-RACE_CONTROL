package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Garage;

import java.util.ArrayList;

public class EliminationRace extends Race {
    //region ATTRIBUTES
    public final String NAME = "Elimination race";
    public final int DURATION = 180;
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
    }
    //endregion
}

