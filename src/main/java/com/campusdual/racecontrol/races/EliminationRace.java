package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Garage;

import java.util.ArrayList;

public class EliminationRace extends Race {
    //region ATTRIBUTES
    public final String NAME = "Elimination race";
    //endregion

    //region CONSTRUCTORS
    public EliminationRace(ArrayList<Garage> participatingGarages, ArrayList<Car> garagesCars) {
        super(participatingGarages, garagesCars);
        super.setName(this.NAME);
    }
    //endregion

    //region METHODS
    @Override
    public void startRace() {
    }
    //endregion
}

