package com.campusdual.racecontrol;

import com.campusdual.racecontrol.races.EliminationRace;
import com.campusdual.racecontrol.races.StandardRace;

public class Main {
    public static void main(String[] args) {

        StandardRace sr = new StandardRace();
        EliminationRace er = new EliminationRace();

        Control control = new Control();
        control.addToAllRacesArray(sr);
        control.addToAllRacesArray(er);
        sr.exportJSONToFile(control.getAllRacesArray());

        control.ui();
    }
}