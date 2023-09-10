package com.campusdual.racecontrol;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import util.Input;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Control {
    //region ATTRIBUTES
    private ArrayList<Garage> garagesArray = new ArrayList<>();

    private ArrayList<Car> carsArray = new ArrayList<>();
    //endregion

    //region CONSTRUCTORS
    public Control() {
    }
    //endregion

    //region METHODS

    public ArrayList<Garage> getGaragesArray() {
        return garagesArray;
    }

    public void setGaragesArray(ArrayList<Garage> garagesArray) {
        this.garagesArray = garagesArray;
    }

    public void ui(){
        /**IMPORTANDO LOS DATOS DESDE FICHERO JSON AL INICIAR LA APLICACIÓN**/

        Car c = new Car("","","");

        carsArray = c.importCarsFromJSON("allCars.json");

        //****************************************

        Garage g = new Garage();

        garagesArray = g.importGaragesFromJSON("allGarages.json");

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

                    c.exportJSONToFile(carsArray);
                    g.exportJSONToFile(garagesArray);
                    on = false;
                    System.out.println("EXITING");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
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
                                    Iterator<Garage> iterator = this.garagesArray.iterator();
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
                                                System.out.println(this.garagesArray.get(Integer.parseInt(standardRaceMenuAnswer)-1).getName());
                                                int selectedGarageInteger = Integer.parseInt(standardRaceMenuAnswer.trim());
                                                System.out.println("You selected "+garagesArray.get(selectedGarageInteger-1).getName());
                                                garageIndex = 0;
                                            } catch (NumberFormatException nfe) {
                                                System.out.println("ERROR: INVALID NUMBER FORMAT");
                                            } catch (IndexOutOfBoundsException ioobe) {
                                                System.out.println("INVALID OPTION");
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
                                            break;

                                    }
                                }while(!validManageRaceMenuAnswer);
                                break;

                            default:
                                System.out.println("INVALID COMMAND");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
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
                                break;

                        }
                    }while(!validTournamentMenuAnswer);
                    break;
                default:
                    System.out.println("INVALID COMMAND");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

            }
            if (control) {
                System.exit(0);
            }
        } while (on);
    }
    //endregion
}
