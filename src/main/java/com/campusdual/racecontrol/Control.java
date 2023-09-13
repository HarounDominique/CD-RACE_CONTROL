package com.campusdual.racecontrol;

import com.campusdual.racecontrol.races.EliminationRace;
import com.campusdual.racecontrol.races.Race;
import com.campusdual.racecontrol.races.RaceType;
import com.campusdual.racecontrol.races.StandardRace;
import com.campusdual.racecontrol.tournaments.Tournament;
import util.Input;
import util.Utils;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Control {
    //region ATTRIBUTES
    private ArrayList<Garage> allGaragesArray = new ArrayList<>();
    private ArrayList<Garage> showGaragesArray = new ArrayList<>();
    private ArrayList<Car> allCarsArray = new ArrayList<>();
    private ArrayList<Car> participatingCarsArray = new ArrayList<>();
    private ArrayList<Garage> participatingGaragesArray = new ArrayList<>();
    private ArrayList<Race> allRacesArray = new ArrayList<>();
    private ArrayList<Tournament> allTournamentsArray = new ArrayList<>();

    private Race selectedRace;
    private Garage firstParticipatingGarage;
    private Garage secondParticipatingGarage;

    //endregion

    //region CONSTRUCTORS
    public Control() {
    }
    //endregion

    //region METHODS

    public void pause(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Car> selectParticipatingCars(Garage firstParticipatingGarage, Garage secondParticipatingGarage){
        Car firstParticipatingCar = null;
        Car secondParticipatingCar = null;
        ArrayList<Car> participatingCars = null;
        if(secondParticipatingGarage != null){
            firstParticipatingCar = firstParticipatingGarage.getRandomCar();
            secondParticipatingCar = secondParticipatingGarage.getRandomCar();
            participatingCars = new ArrayList<>(Arrays.asList(firstParticipatingCar, secondParticipatingCar));
        }else{
            participatingCars = firstParticipatingGarage.getCars();
        }
        this.participatingCarsArray = participatingCars;
        return participatingCars;
    }

    public ArrayList<Car> getAllCarsArray() {
        return allCarsArray;
    }

    public void setAllCarsArray(ArrayList<Car> allCarsArray) {
        this.allCarsArray = allCarsArray;
    }

    public ArrayList<Car> getParticipatingCarsArray() {
        return participatingCarsArray;
    }

    public void setParticipatingCarsArray(ArrayList<Car> participatingCarsArray) {
        this.participatingCarsArray = participatingCarsArray;
    }

    public ArrayList<Garage> getParticipatingGaragesArray() {
        return participatingGaragesArray;
    }

    public void setParticipatingGaragesArray(ArrayList<Garage> participatingGaragesArray) {
        this.participatingGaragesArray = participatingGaragesArray;
    }

    public ArrayList<Race> getAllRacesArray() {
        return allRacesArray;
    }

    public void setAllRacesArray(ArrayList<Race> allRacesArray) {
        this.allRacesArray = allRacesArray;
    }

    public void addToAllRacesArray(Race race) {
        this.allRacesArray.add(race);
    }

    public ArrayList<Tournament> getAllTournamentsArray() {
        return allTournamentsArray;
    }

    public void setAllTournamentsArray(ArrayList<Tournament> allTournamentsArray) {
        this.allTournamentsArray = allTournamentsArray;
    }

    public ArrayList<Garage> getAllGaragesArray() {
        return allGaragesArray;
    }

    public void setAllGaragesArray(ArrayList<Garage> allGaragesArray) {
        this.allGaragesArray = allGaragesArray;
    }

    public void ui() {
        /**IMPORTANDO LOS DATOS DESDE FICHERO JSON AL INICIAR LA APLICACIÓN**/

        Car c = new Car("", "", "");

        allCarsArray = c.importCarsFromJSON("allCars.json");

        Garage g = new Garage();

        allGaragesArray = g.importGaragesFromJSON("allGarages.json");
        showGaragesArray = allGaragesArray;

        Race ra = new StandardRace();

        allRacesArray = ra.importRacesFromJSON("allRaces.json");

        boolean on = true;
        boolean control = false;
        boolean validRaceControlMenu = false;
        do {
            System.out.println("*********************| RACE CONTROL |*********************");
            System.out.println("**********************************************************");
            System.out.println("*                                                        *");
            System.out.println("*                   Insert '0' to EXIT                   *");
            System.out.println("*                                                        *");
            System.out.println("*            Insert '1' to enter the RACE MENU           *");
            System.out.println("*                                                        *");
            System.out.println("*         Insert '2' to enter the TOURNAMENT MENU        *");
            System.out.println("*                                                        *");
            System.out.print("* >>> ");
            String answer = Input.string();
            switch (answer.trim()) {
                case "0":
                    /**EXPORTANDO LOS DATOS A JSON ANTES DE CERRAR LA APLICACIÓN**/

                    c.exportJSONToFile(allCarsArray);
                    g.exportJSONToFile(allGaragesArray);
                    ra.exportJSONToFile(allRacesArray);
                    on = false;
                    System.out.println("EXITING");
                    pause(1000);
                    System.exit(0);
                    break;

                case "1":
                    boolean validRaceMenuAnswer = false;
                    do {
                        System.out.println("*********************| RACE CONTROL |*********************");
                        System.out.println("*********************|  RACE  MENU  |*********************");
                        System.out.println("*                                                        *");
                        System.out.println("*                 Insert '0' to GO BACK                  *");
                        System.out.println("*                                                        *");
                        System.out.println("*          Insert '1' to SELECT an EXISTENT RACE         *");
                        System.out.println("*                                                        *");
                        System.out.println("*               Insert '2' to MANAGE RACES               *");
                        System.out.println("*                                                        *");
                        System.out.print("* >>> ");
                        String raceMenuAnswer = Input.string();
                        switch (raceMenuAnswer.trim()) {
                            case "0":
                                validRaceMenuAnswer = true;
                                ui();
                                break;

                            case "1":
                                boolean validRaceListAnswer = false;
                                do {
                                    System.out.println("*********************| RACE CONTROL |*********************");
                                    System.out.println("*********************|  RACE  MENU  |*********************");
                                    System.out.println("*********************|  RACE  LIST  |*********************");
                                    System.out.println("*                                                        *");
                                    System.out.println("*                 Insert '0' to GO BACK                  *");
                                    System.out.println("*                                                        *");
                                    System.out.println("*                           OR                           *");
                                    System.out.println("*                                                        *");
                                    System.out.println("*                  Select a RACE to RUN:                  *");
                                    System.out.println("*                                                        *");
                                    System.out.println("* INDEX|         NAME         |     TYPE     | DURATION  *");
                                    Iterator<Race> raceIterator = this.allRacesArray.iterator();
                                    int raceIndex = 0;
                                    while (raceIterator.hasNext()) {
                                        raceIndex++;
                                        Race r = raceIterator.next();
                                        System.out.println("   " + raceIndex + "   |   " + r.getName() + "   |   " + r.getRaceType() + "   |   " + r.getDurationInMinutes());
                                    }
                                    System.out.print("* >>> ");
                                    String raceSelectionAnswer = Input.string();
                                    switch (raceSelectionAnswer.trim()) {
                                        case "0":
                                            validRaceListAnswer = true;
                                            ui();
                                            break;

                                        default:
                                            try {
                                                int selectedRaceInteger = Integer.parseInt(raceSelectionAnswer.trim());
                                                System.out.println("You selected " + allRacesArray.get(selectedRaceInteger - 1).getName());
                                                //todo almacenar la carrera para extraer su tipo, duración etc...
                                                selectedRace = allRacesArray.get(selectedRaceInteger - 1);
                                                pause(500);
                                                boolean validGarageSelection = false;
                                                int garageIndex = 0;
                                                int secondGarageIndex = 0;
                                                int selectedGarageIndex;
                                                int secondSelectedGarageIndex;
                                                do{
                                                    System.out.println("*********************| RACE CONTROL |*********************");
                                                    System.out.println("*********************|  RACE  MENU  |*********************");
                                                    System.out.println("*****************|FIRST GARAGE SELECTION|*****************");
                                                    System.out.println("*                                                        *");
                                                    System.out.println("*                 Insert '0' to GO BACK                  *");
                                                    System.out.println("*                                                        *");
                                                    System.out.println("*                           OR                           *");
                                                    System.out.println("*                                                        *");
                                                    System.out.println("*             Select a GARAGE to PARTICIPATE:            *");
                                                    System.out.println("*                                                        *");
                                                    System.out.println("* INDEX| GARAGE NAME                                   *");
                                                    Iterator<Garage> garageIterator = this.allGaragesArray.iterator();
                                                    while (garageIterator.hasNext()) {
                                                        garageIndex++;
                                                        Garage firstGarageIteration = garageIterator.next();
                                                        System.out.println("     "+garageIndex + " | " + firstGarageIteration.getName());
                                                    }
                                                    System.out.print("* >>> ");
                                                    String garageSelectionAnswer = Input.string();
                                                    switch (garageSelectionAnswer.trim()){
                                                        case "0":
                                                            garageIndex = 0;
                                                            validGarageSelection = true;
                                                            ui();
                                                            break;

                                                        default:
                                                            try {
                                                                selectedGarageIndex = Integer.parseInt(garageSelectionAnswer.trim());
                                                                System.out.println("You selected " + this.allGaragesArray.get(selectedGarageIndex - 1).getName());
                                                                this.firstParticipatingGarage = this.allGaragesArray.get(selectedGarageIndex - 1);
                                                                this.showGaragesArray.remove(selectedGarageIndex - 1);
                                                                garageIndex = 0;
                                                                pause(500);
                                                                validGarageSelection = true;

                                                                boolean validSecondGarageSelection = false;
                                                                do {
                                                                    System.out.println("*********************| RACE CONTROL |*********************");
                                                                    System.out.println("*********************|  RACE  MENU  |*********************");
                                                                    System.out.println("*****************|SECOND GARAGE SELECTION|****************");
                                                                    System.out.println("*                                                        *");
                                                                    System.out.println("*              Insert '0' to SKIP 2º GARAGE              *");
                                                                    System.out.println("*                                                        *");
                                                                    System.out.println("*                           OR                           *");
                                                                    System.out.println("*                                                        *");
                                                                    System.out.println("*          Select a SECOND GARAGE to PARTICIPATE:        *");
                                                                    System.out.println("*                                                        *");
                                                                    System.out.println("* INDEX| GARAGE NAME                                   *");
                                                                    Iterator<Garage> secondGarageIterator = this.showGaragesArray.iterator();
                                                                    while (secondGarageIterator.hasNext()) {
                                                                        Garage secondGarageIteration = secondGarageIterator.next();
                                                                        secondGarageIndex++;
                                                                        System.out.println("     " + secondGarageIndex + " | " + secondGarageIteration.getName());
                                                                    }
                                                                    System.out.print("* >>> ");
                                                                    String garageSecondSelectionAnswer = Input.string();
                                                                    switch (garageSecondSelectionAnswer.trim()) {
                                                                        case "0":
                                                                            secondGarageIndex = 0;
                                                                            validSecondGarageSelection = true;
                                                                            this.secondParticipatingGarage = null;
                                                                            //todo: complete the method: (o sustituir por un método propio de clase Race)
                                                                            selectParticipatingCars(firstParticipatingGarage, secondParticipatingGarage);

                                                                            StandardRace sr = new StandardRace(participatingGaragesArray, participatingCarsArray);
                                                                            sr.startRace();
                                                                            break;

                                                                        default:
                                                                            try {
                                                                                secondSelectedGarageIndex = Integer.parseInt(garageSecondSelectionAnswer.trim());
                                                                                System.out.println("You selected " + showGaragesArray.get(secondSelectedGarageIndex -1).getName());
                                                                                this.secondParticipatingGarage = showGaragesArray.get(secondSelectedGarageIndex -1);
                                                                                validSecondGarageSelection = true;
                                                                                secondGarageIndex = 0;
                                                                                //secondSelectedGarageIndex=0;
                                                                                pause(500);

                                                                                selectParticipatingCars(firstParticipatingGarage, secondParticipatingGarage);
                                                                                StandardRace sr2 = new StandardRace(participatingGaragesArray, participatingCarsArray);
                                                                                sr2.startRace();

                                                                            } catch (NumberFormatException nfe) {
                                                                                System.out.println("ERROR: INVALID NUMBER FORMAT");
                                                                                pause(1000);
                                                                            } catch (IndexOutOfBoundsException ioobe) {
                                                                                System.out.println("INVALID OPTION (SECOND GARAGE)");
                                                                                ioobe.printStackTrace();
                                                                                ioobe.getLocalizedMessage();
                                                                                pause(1000);
                                                                            }
                                                                            break;

                                                                            /**HERE ENDS STANDARD RACE MENUS**/

                                                                    }
                                                                }while(!validSecondGarageSelection);
                                                            } catch (NumberFormatException nfe) {
                                                                System.out.println("ERROR: INVALID NUMBER FORMAT");
                                                                pause(1000);
                                                            } catch (IndexOutOfBoundsException ioobe) {
                                                                //ioobe.printStackTrace();
                                                                System.out.println("INVALID OPTION (FIRST GARAGE)");
                                                                pause(1000);
                                                            }
                                                            break;
                                                    }
                                                }while(!validGarageSelection);
                                                raceIndex = 0;
                                                validRaceListAnswer = true;

                                            } catch (NumberFormatException nfe) {
                                                System.out.println("ERROR: INVALID NUMBER FORMAT");
                                                validRaceListAnswer = false;
                                                pause(1000);
                                            } catch (IndexOutOfBoundsException ioobe) {
                                                System.out.println("INVALID OPTION");
                                                validRaceListAnswer = false;
                                                pause(1000);
                                            }

                                            break;

                                    }
                                } while (!validRaceListAnswer);
                                //break;
                            case "2":
                                boolean validRaceManagementAnswer = false;
                                do {
                                    System.out.println("*********************| RACE CONTROL |*********************");
                                    System.out.println("********************|RACE  MANAGEMENT|********************");
                                    System.out.println("*                                                        *");
                                    System.out.println("*                 Insert '0' to GO BACK                  *");
                                    System.out.println("*                                                        *");
                                    System.out.println("*              Insert '1' to ADD a new RACE              *");
                                    System.out.println("*                                                        *");
                                    System.out.println("*           Insert '2' to REMOVE an existent RACE        *");
                                    System.out.println("*                                                        *");
                                    System.out.print("* >>> ");
                                    String tournamentMenuAnswer = Input.string();
                                    switch (tournamentMenuAnswer.trim()) {
                                        case "0":
                                            validRaceManagementAnswer = true;
                                            ui();
                                            break;

                                        case "1":
                                            validRaceManagementAnswer = true;
                                            System.out.println("Insert a race name:");
                                            String raceName = Input.string();
                                            RaceType raceType = null;
                                            int raceDuration = 180;
                                            Race race = null;
                                            boolean invalidTypeRace = true;
                                            do {
                                                System.out.println("Insert 1 for STANDARD race or 2 for ELIMINATION race:");
                                                try {
                                                    String raceTypeAnswer = Input.string().trim();
                                                    switch (raceTypeAnswer){
                                                        case "1":
                                                            raceType = RaceType.STANDARD;
                                                            invalidTypeRace = false;
                                                            break;
                                                        case "2":
                                                            raceType = RaceType.ELIMINAT;
                                                            invalidTypeRace = false;
                                                            break;
                                                        default:
                                                            System.out.println("ERROR: Race type non-valid");
                                                            break;
                                                    }
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }

                                                if(raceType.equals(RaceType.STANDARD)){
                                                    System.out.println("Insert the race DURATION in minutes:");
                                                }else{
                                                    System.out.println("Insert the race warm-up DURATION in minutes:");
                                                }

                                                try{
                                                    raceDuration = Input.integer();
                                                }catch (Exception e){
                                                    System.out.println("ERROR: Duration must be an integer. A default value (180) will be set.");
                                                    //e.printStackTrace();
                                                }
                                                if(raceType.equals(RaceType.STANDARD)){
                                                    race = new StandardRace(raceName, raceDuration);
                                                }else if(raceType.equals(RaceType.ELIMINAT)){
                                                    race = new EliminationRace(raceName, raceDuration);
                                                }
                                                this.allRacesArray.add(race);
                                                System.out.println("Race successfully added");
                                                pause(1000);
                                                ui();
                                            }while(invalidTypeRace);
                                            break;

                                        case "2":
                                            validRaceManagementAnswer = true;
                                            break;

                                        default:
                                            System.out.println("INVALID COMMAND");
                                            pause(1000);
                                            break;

                                    }
                                } while (!validRaceManagementAnswer);
                                break;
                            default:
                                System.out.println("INVALID COMMAND");
                                pause(1000);
                                break;

                        }
                        if (control) {
                            System.exit(0);
                        }
                    } while (on);
                case "3":
                    break;
            }
            //endregion
        } while (!validRaceControlMenu);
    }
}

