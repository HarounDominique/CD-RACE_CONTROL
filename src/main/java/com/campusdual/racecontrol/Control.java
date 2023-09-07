package com.campusdual.racecontrol;

import util.Input;

public class Control {
    public Control() {
    }
    public void ui(){
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
            System.out.println("*         Insert '3' to enter the MANAGEMENT MENU        *");
            System.out.println("*                                                        *");
            System.out.print("* >>> ");
            String answer = Input.string();
            switch (answer.trim()) {
                case "0":
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
                        System.out.print("* >>> ");
                        String raceMenuAnswer = Input.string();
                        switch (raceMenuAnswer.trim()){
                            case "0":
                                //validRaceMenuAnswer = true;
                                ui(); //todo probar a quitar ui() solo con el break debería retroceder
                                break;
                            case "1":
                                //validRaceMenuAnswer = true;
                                boolean validStandardRaceMenuAnswer = false;
                                do {
                                    System.out.println("*********************| RACE CONTROL |*********************");
                                    System.out.println("*****************|  STANDARD RACE  MENU  |****************");
                                    System.out.println("*                                                        *");
                                    System.out.println("*                 Insert '0' to GO BACK                  *");
                                    System.out.println("*                                                        *");
                                    System.out.println("*            Select the GARAGE from the list:            *");
                                    System.out.println("*                                                        *");
                                    System.out.print("* >>> ");
                                    String standardRaceMenuAnswer = Input.string();
                                    switch (standardRaceMenuAnswer.trim()){
                                        case "0":
                                            //validStandardRaceMenuAnswer = true;
                                            ui(); //todo probar a quitar ui() solo con el break debería retroceder
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
                                            ui(); //todo probar a quitar ui() solo con el break debería retroceder
                                            break;
                                    }
                                }while(!validEliminationRaceMenuAnswer);
                                break;
                            default:
                                System.out.println("INVALID OPTION");
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
                        }
                    }while(!validTournamentMenuAnswer);
                    break;
                case "3":
                default:
                    System.out.println("NON-EXISTENT COMMAND");
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
}
