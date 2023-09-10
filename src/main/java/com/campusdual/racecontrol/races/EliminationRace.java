package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Garage;

import java.util.ArrayList;

public class EliminationRace extends Race {
    //region ATTRIBUTES
    public final String NAME = "Elimination race";
    public final int DURATION = 180;
    public final RaceType RACE_TYPE = RaceType.ELIMINATION;
    //endregion

    //region CONSTRUCTORS
    public EliminationRace(String name, RaceType raceType, int durationInMinutes, ArrayList<Garage> participatingGarages, ArrayList<Car> participatingCars) {
        super(name, raceType, durationInMinutes, participatingGarages, participatingCars);
    }

    public EliminationRace(String name, ArrayList<Garage> participatingGarages, ArrayList<Car> participatingCars) {
        super(name, participatingGarages, participatingCars);
    }
    public EliminationRace(ArrayList<Garage> participatingGarages, ArrayList<Car> garagesCars) {
        super(participatingGarages, garagesCars);
        super.setName(this.NAME);
    }

    public EliminationRace(String name, RaceType raceType, int duration) {
        super(name, raceType, duration);
    }

    public EliminationRace() {
    }
    //endregion

    //region METHODS
    @Override
    public void startRace() {
    }
    //endregion
}

