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
                        System.out.println("*            Insert '1' to enter the RACE MENU           *");
                        System.out.println("*                                                        *");
                        System.out.println("*         Insert '2' to enter the TOURNAMENT MENU        *");
                        System.out.println("*                                                        *");
                        System.out.print("* >>> ");
                        String raceMenuAnswer = Input.string();
                        switch (raceMenuAnswer.trim()){
                            case "0":
                                validRaceMenuAnswer = true;
                                ui();
                                break;
                            case "1":
                                validRaceMenuAnswer = true;
                                do {
                                    System.out.println("*********************| RACE CONTROL |*********************");
                                    System.out.println("*********************|  RACE  MENU  |*********************");
                                    System.out.println("*                                                        *");
                                    System.out.println("*                 Insert '0' to GO BACK                  *");
                                    System.out.println("*                                                        *");
                                    System.out.println("*            Insert '1' to enter the RACE MENU           *");
                                    System.out.println("*                                                        *");
                                    System.out.println("*         Insert '2' to enter the TOURNAMENT MENU        *");
                                    System.out.println("*                                                        *");
                                    System.out.print("* >>> ");
                                    String raceMenuAnswer = Input.string();
                                }while();
                                break;
                            case "2":
                                validRaceMenuAnswer = true;
                                do {
                                    System.out.println("*********************| RACE CONTROL |*********************");
                                    System.out.println("*********************|  RACE  MENU  |*********************");
                                    System.out.println("*                                                        *");
                                    System.out.println("*                 Insert '0' to GO BACK                  *");
                                    System.out.println("*                                                        *");
                                    System.out.println("*            Insert '1' to enter the RACE MENU           *");
                                    System.out.println("*                                                        *");
                                    System.out.println("*         Insert '2' to enter the TOURNAMENT MENU        *");
                                    System.out.println("*                                                        *");
                                    System.out.print("* >>> ");
                                    String raceMenuAnswer = Input.string();
                                }while();
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
                        System.out.println("*********************|  RACE  MENU  |*********************");
                        System.out.println("*                                                        *");
                        System.out.println("*                 Insert '0' to GO BACK                  *");
                        System.out.println("*                                                        *");
                        System.out.println("*            Insert '1' to enter the RACE MENU           *");
                        System.out.println("*                                                        *");
                        System.out.println("*         Insert '2' to enter the TOURNAMENT MENU        *");
                        System.out.println("*                                                        *");
                        System.out.print("* >>> ");
                        String raceMenuAnswer = Input.string();
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
