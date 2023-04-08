//
// Simple roulette game by Max
//

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        clear();
        logo();
        System.out.println("\n\n\n\n\n");
        System.out.println("\nWelcome to Max's game of Roulette\nTo start the game press s");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equals("s")) {
            int cash = 100;
            boolean isFinished = false;

            while(true) {
                while(!isFinished) {
                    clear();
                    logo();
                    System.out.println("\n\n\n\n\n");
                    table();
                    System.out.println("\n\n\n\n\n");
                    System.out.println("Your balance is: " + cash + "$");
                    System.out.print("Your bet: ");

                    int betAmount;
                    for(betAmount = scanner.nextInt(); betAmount > cash; betAmount = scanner.nextInt()) {
                        System.out.println("You do not have enough cash");
                        System.out.print("Your bet: ");
                    }

                    System.out.print("Where do you want to place your bet: ");
                    String bet = scanner.next();
                    int number = (int)(Math.random() * 37.0);
                    String numberString = "" + number;
                    String exit;
                    if (bet.equals("b") && color(number).equals("b") || bet.equals("r") && color(number).equals("r") || bet.equals("e") && evenOdd(number) == 1 || bet.equals("o") && evenOdd(number) == 2 || bet.equals("1/2") && half(number) == 1 || bet.equals("2/2") && half(number) == 2) {
                        System.out.println("" + number + " " + color(number).toUpperCase());
                        System.out.println("you win!!");
                        cash = cash - betAmount + betAmount * 2;
                        System.out.println("Your balance is: " + cash + "$");
                        System.out.print("Do you wish to continues? y/n: ");
                        exit = scanner.next();
                        if (exit.equals("n")) {
                            isFinished = true;
                        }
                    } else if (bet.equals("1/3") && third(number) == 1 || bet.equals("2/3") && third(number) == 2 || bet.equals("3/3") && third(number) == 3 || bet.equals("t") && layer(number) == 1 || bet.equals("m") && layer(number) == 2 || bet.equals("l") && layer(number) == 3) {
                        System.out.println("" + number + " " + color(number).toUpperCase());
                        System.out.println("you win!!");
                        cash = cash - betAmount + betAmount * 3;
                        System.out.println("Your balance is: " + cash + "$");
                        System.out.print("Do you wish to continues? y/n: ");
                        exit = scanner.next();
                        if (exit.equals("n")) {
                            isFinished = true;
                        }
                    } else if (bet.equals(numberString)) {
                        System.out.println("" + number + " " + color(number).toUpperCase());
                        System.out.println("you win!!");
                        cash = cash - betAmount + betAmount * 36;
                        System.out.println("Your balance is: " + cash + "$");
                        System.out.print("Do you wish to continues? y/n: ");
                        exit = scanner.next();
                        if (exit.equals("n")) {
                            isFinished = true;
                        }
                    } else {
                        System.out.println("" + number + " " + color(number).toUpperCase());
                        System.out.println("You lost");
                        cash -= betAmount;
                        System.out.println("Your balance is: " + cash + "$");
                        if (cash <= 0) {
                            System.out.println("Game over");
                            isFinished = true;
                        } else {
                            System.out.print("Do you wish to continues? y/n: ");
                            exit = scanner.next();
                            if (exit.equals("n")) {
                                isFinished = true;
                            }
                        }
                    }
                }

                return;
            }
        }
    }

    public static String color(int number) {
        if (number != 1 && number != 3 && number != 5 && number != 7 && number != 9 && number != 12 && number != 14 && number != 16 && number != 18 && number != 19 && number != 21 && number != 23 && number != 25 && number != 27 && number != 30 && number != 32 && number != 34 && number != 36) {
            return number == 0 ? "g" : "b";
        } else {
            return "r";
        }
    }

    public static int third(int number) {
        if (number >= 1 && number < 13) {
            return 1;
        } else if (number >= 13 && number < 25) {
            return 2;
        } else {
            return number >= 25 && number <= 36 ? 3 : 0;
        }
    }

    public static int half(int number) {
        if (number >= 1 && number < 19) {
            return 1;
        } else {
            return number >= 19 && number <= 36 ? 2 : 0;
        }
    }

    public static int evenOdd(int number) {
        if (number == 0) {
            return 0;
        } else {
            return number % 2 == 0 ? 1 : 2;
        }
    }

    public static int layer(int number) {
        if (number == 0) {
            return 0;
        } else if (number % 3 == 0) {
            return 1;
        } else {
            return (number + 1) % 3 == 0 ? 2 : 3;
        }
    }

    public static void clear() {
        for(int i = 0; i < 25; ++i) {
            System.out.println("\n");
        }

    }

    public static void logo() {
        System.out.println("\n███████████████████████████████████████████████████████████████████████\n█▄─▀█▀─▄██▀▄─██▄─▀─▄███▄─▄▄▀█─▄▄─█▄─██─▄█▄─▄███▄─▄▄─█─▄─▄─█─▄─▄─█▄─▄▄─█\n██─█▄█─███─▀─███▀─▀█████─▄─▄█─██─██─██─███─██▀██─▄█▀███─█████─████─▄█▀█\n▀▄▄▄▀▄▄▄▀▄▄▀▄▄▀▄▄█▄▄▀▀▀▄▄▀▄▄▀▄▄▄▄▀▀▄▄▄▄▀▀▄▄▄▄▄▀▄▄▄▄▄▀▀▄▄▄▀▀▀▄▄▄▀▀▄▄▄▄▄▀");
    }

    public static void table() {
        System.out.println("             ##=====#=====#=====#=====#=====#=====#=====#=====#=====#=====#=====#=====##-------#          #--------------------------------------#\n             ||  3b |  6r |  9b | 12r | 15b | 18r | 21b | 24r | 27b | 30r | 33b | 36r ||  TOP  |          |               Instructions           |\n        #----||-----#-----#-----#-----#-----#-----#-----#-----#-----#-----#-----#-----||-------#          #--------------------------------------#\n        | 0g ||  2r |  5b |  8r | 11b | 14r | 17b | 20r | 23b | 26r | 29b | 32r | 35b ||  MID  |          |  Number   - enter number             |\n        #----||-----#-----#-----#-----#-----#-----#-----#-----#-----#-----#-----#-----||-------#          |  Color    - enter b or r             |\n             ||  1b |  4r |  7b | 10r | 13b | 16r | 19b | 22r | 25b | 28r | 31b | 34r ||  LOW  |          |  Third    - enter 1/3 or 2/3 or 3/3  |\n             ||=====#=====#=====#=====#=====#=====#=====#=====#=====#=====#=====#=====##-------#          |  Half     - enter 1/2 or 2/2         |\n              |         1 / 3         |         2 / 3         |         3 / 3         |                   |  Odd Even - enter e or o             |\n              #-----------------------#-----------------------#-----------------------#                   |  Layer    - enter t m l              |\n              |   1 - 18  |    ODD    |    RED    |   BLACK   |  18 - 36  |    EVEN   |                   #--------------------------------------#\n              #-----------------------#-----------------------#-----------------------#");
    }
}
