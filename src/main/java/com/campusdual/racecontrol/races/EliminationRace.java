package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Garage;

import java.util.ArrayList;

public class EliminationRace extends Race {
    //region CONSTRUCTORS
    public EliminationRace(String name, ArrayList<Garage> participatingGarages, ArrayList<Car> garagesCars) {
        super(name, participatingGarages, garagesCars);
    }
    //endregion

    //region METHODS
    @Override
    public void startRace() {
    }
    //endregion
}

