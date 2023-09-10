package com.campusdual.racecontrol;

import com.campusdual.racecontrol.races.Race;
import com.campusdual.racecontrol.tournaments.Tournament;
import util.Input;

import java.util.ArrayList;
import java.util.Iterator;

public class Control {
    //region ATTRIBUTES
    private ArrayList<Garage> allGaragesArray = new ArrayList<>();
    private ArrayList<Car> allCarsArray = new ArrayList<>();
    private ArrayList<Car> participatingCarsArray = new ArrayList<>();
    private ArrayList<Garage> participatingGaragesArray = new ArrayList<>();
    private ArrayList<Race> allRacesArray = new ArrayList<>();
    private ArrayList<Tournament> allTournamentsArray = new ArrayList<>();
    //endregion

    //region CONSTRUCTORS
    public Control() {
    }
    //endregion

    //region METHODS

    public void pause(int miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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

    public void ui(){
        /**IMPORTANDO LOS DATOS DESDE FICHERO JSON AL INICIAR LA APLICACIÓN**/

        Car c = new Car("","","");

        allCarsArray = c.importCarsFromJSON("allCars.json");

        //****************************************

        Garage g = new Garage();

        allGaragesArray = g.importGaragesFromJSON("allGarages.json");

        boolean on = true;
        boolean control = false;
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
                        System.out.println("*       Insert '1' to enter the STANDARD RACE MENU       *");
                        System.out.println("*                                                        *");
                        System.out.println("*      Insert '2' to enter the ELIMINATION RACE MENU     *");
                        System.out.println("*                                                        *");
                        System.out.println("*               Insert '3' to MANAGE RACES               *");
                        System.out.print("* >>> ");
                        String raceMenuAnswer = Input.string();
                        switch (raceMenuAnswer.trim()){
                            case "0":
                                //validRaceMenuAnswer = true;
                                ui();
                                break;

                            case "1":
                                //validRaceMenuAnswer = true;
                                boolean validStandardRaceMenuAnswer = false;
                                int garageIndex = 0;
                                do {
                                    System.out.println("*********************| RACE CONTROL |*********************");
                                    System.out.println("*****************|  STANDARD RACE  MENU  |****************");
                                    System.out.println("*                                                        *");
                                    System.out.println("*                 Insert '0' to GO BACK                  *");
                                    System.out.println("*                                                        *");
                                    System.out.println("*            Select the GARAGE from the list:            *");
                                    System.out.println("*                                                        *");
                                    Iterator<Garage> iterator = this.allGaragesArray.iterator();
                                    while(iterator.hasNext()){
                                        garageIndex++;
                                        System.out.println(garageIndex+" "+iterator.next().getName());
                                    }
                                    //garageIndex=0;
                                    System.out.print("* >>> ");
                                    String standardRaceMenuAnswer = Input.string();
                                    switch (standardRaceMenuAnswer.trim()){
                                        case "0":
                                            garageIndex = 0;
                                            //validStandardRaceMenuAnswer = true;
                                            ui();
                                            break;

                                        default:
                                            try{
                                                System.out.println(this.allGaragesArray.get(Integer.parseInt(standardRaceMenuAnswer)-1).getName());
                                                int selectedGarageInteger = Integer.parseInt(standardRaceMenuAnswer.trim());
                                                System.out.println("You selected "+ allGaragesArray.get(selectedGarageInteger-1).getName());
                                                garageIndex = 0;
                                            } catch (NumberFormatException nfe) {
                                                System.out.println("ERROR: INVALID NUMBER FORMAT");
                                                pause(1000);
                                            } catch (IndexOutOfBoundsException ioobe) {
                                                System.out.println("INVALID OPTION");
                                                pause(1000);
                                            }
                                            break;
                                    }
                                }while(!validStandardRaceMenuAnswer);
                                break;

                            case "2":
                                //validRaceMenuAnswer = true;
                                boolean validEliminationRaceMenuAnswer = false;
                                do {
                                    System.out.println("*********************| RACE CONTROL |*********************");
                                    System.out.println("*****************| ELIMINATION RACE MENU |****************");
                                    System.out.println("*                                                        *");
                                    System.out.println("*                 Insert '0' to GO BACK                  *");
                                    System.out.println("*                                                        *");
                                    System.out.println("*            Select the GARAGE from the list:            *");
                                    System.out.println("*                                                        *");
                                    System.out.print("* >>> ");
                                    String eliminationRaceMenuAnswer = Input.string();
                                    switch (eliminationRaceMenuAnswer.trim()){
                                        case "0":
                                            //validEliminationRaceMenuAnswer = true;
                                            ui();
                                            break;

                                        case "1":
                                            break;

                                        default:
                                            System.out.println("INVALID COMMAND");
                                            pause(1000);
                                            break;

                                    }
                                }while(!validEliminationRaceMenuAnswer);
                                break;

                            case "3":
                                boolean validManageRaceMenuAnswer = false;
                                do {
                                    System.out.println("*********************| RACE CONTROL |*********************");
                                    System.out.println("*****************| MANAGEMENT  RACE MENU |****************");
                                    System.out.println("*                                                        *");
                                    System.out.println("*                 Insert '0' to GO BACK                  *");
                                    System.out.println("*                                                        *");
                                    System.out.println("*            Select the GARAGE from the list:            *");
                                    System.out.println("*                                                        *");
                                    System.out.print("* >>> ");
                                    String manageRaceMenuAnswer = Input.string();
                                    switch (manageRaceMenuAnswer.trim()){
                                        case "0":
                                            //validEliminationRaceMenuAnswer = true;
                                            ui();
                                            break;

                                        case "1":
                                            break;

                                        default:
                                            System.out.println("INVALID COMMAND");
                                            pause(1000);
                                            break;

                                    }
                                }while(!validManageRaceMenuAnswer);
                                break;

                            default:
                                System.out.println("INVALID COMMAND");
                                pause(1000);
                                break;
                        }
                    }while(!validRaceMenuAnswer);
                    //break;
                case "2":
                    boolean validTournamentMenuAnswer = false;
                    do {
                        System.out.println("*********************| RACE CONTROL |*********************");
                        System.out.println("********************|TOURNAMENT  MENU|********************");
                        System.out.println("*                                                        *");
                        System.out.println("*                 Insert '0' to GO BACK                  *");
                        System.out.println("*                                                        *");
                        System.out.println("*            Insert '1' to enter the RACE MENU           *");
                        System.out.println("*                                                        *");
                        System.out.println("*         Insert '2' to enter the TOURNAMENT MENU        *");
                        System.out.println("*                                                        *");
                        System.out.print("* >>> ");
                        String tournamentMenuAnswer = Input.string();
                        switch (tournamentMenuAnswer.trim()){
                            case "0":
                                ui();
                                //validTournamentMenuAnswer = true;
                                break;

                            case "1":
                                break;

                            default:
                                System.out.println("INVALID COMMAND");
                                pause(1000);
                                break;

                        }
                    }while(!validTournamentMenuAnswer);
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
    }
    //endregion
}
