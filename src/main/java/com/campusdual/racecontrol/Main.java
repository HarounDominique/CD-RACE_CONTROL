package com.campusdual.racecontrol;

import com.campusdual.racecontrol.races.StandardRace;

public class Main {
    public static void main(String[] args) {

        StandardRace sr = new StandardRace();

        Control control = new Control();
        control.addToAllRacesArray(sr);

        control.ui();

    }
}