package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Garage;

import java.util.ArrayList;

public class StandardRace extends Race {
    //region ATTRIBUTES
    public final String NAME = "Standard race";
    //endregion

    //region CONSTRUCTOR
    public StandardRace(ArrayList<Garage> participatingGarages, ArrayList<Car> garagesCars) {
        super(participatingGarages, garagesCars);
        super.setName(this.NAME);
    }
    //endregion

    //region METHODS
    @Override
    public void startRace() {
        //todo actualizar el podium cuando finaliza la carrera
    }
    //endregion
}
