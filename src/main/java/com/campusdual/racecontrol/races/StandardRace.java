package com.campusdual.racecontrol.races;

import com.campusdual.racecontrol.Car;
import com.campusdual.racecontrol.Garage;

import java.util.ArrayList;

public class StandardRace extends Race {
    //region CONSTRUCTOR
    public StandardRace(String name, ArrayList<Garage> participatingGarages, ArrayList<Car> garagesCars) {
        super(name, participatingGarages, garagesCars);
    }
    //endregion

    //region METHODS
    @Override
    public void startRace() {
        //todo actualizar el podium cuando finaliza la carrera
    }
    //endregion
}
