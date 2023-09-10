package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Garage;

import java.util.ArrayList;

public class StandardRace extends Race {
    //region ATTRIBUTES
    public final String NAME = "Standard race";
    public final int DURATION = 180;
    //endregion

    //region CONSTRUCTOR
    public StandardRace(ArrayList<Garage> participatingGarages, ArrayList<Car> participatingCars) {
        super(participatingGarages, participatingCars);
        super.setName(this.NAME);
        super.setDurationInMinutes(this.DURATION);
    }
    //endregion

    //region METHODS
    @Override
    public void startRace() {
        //todo actualizar el podium cuando finaliza la carrera
    }
    //endregion
}
