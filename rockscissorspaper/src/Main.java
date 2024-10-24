import java.util.Random;
import java.util.Scanner;

public class Main {


    private int userChoice = -1;
    private int computerChoice = -1;
    private int userWins = 0;
    private int computerWins = 0;
    private int draws = 0;


    private void start() {
        Scanner scanner = new Scanner(System.in);
        boolean continueGame = true;
        while (continueGame) {
            getUserChoice(scanner);
            if (userChoice == 0) {
                System.out.println("You end the game. Bye");
                printScore();
                break;
            }
            computersNumber();
            compareResults(userChoice, computerChoice);
            printScore();
            continueGame = askForReplay(scanner);
        }
    }

    private void getUserChoice(Scanner scanner) {

        do {
            System.out.println("You must choice the rock, scissors or paper : \n push 1 - ROCK " +
                    "\n push 2 - PAPER \n push 3 - SCISSORS ");
            System.out.println("If you want end the game - push 0");

            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                if (userChoice >= 0 && userChoice <= 3) {
                    break;
                } else {
                    System.out.println("Pleas enter a number between 0 and 3");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }


        }
        while (userChoice < 0 || userChoice > 3);
    }

    private void computersNumber() {
        Random random = new Random();
        computerChoice = random.nextInt(3) + 1;
        switch (computerChoice) {
            case 1:
                System.out.println("Computer choose the ROCK");
                break;
            case 2:
                System.out.println("Computer choose the PAPER");
                break;
            case 3:
                System.out.println("Computer choose the SCISSORS");
        }
    }

    private void compareResults(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            System.out.println("The match ended in a draw");
            draws++;
        } else if ((userChoice == 2 && computerChoice == 1) || (userChoice == 3 && computerChoice == 2) ||
                (userChoice == 1 && computerChoice == 3)) {
            System.out.println("You Win");
            userWins++;
        } else {
            System.out.println("Computer Win");
            computerWins++;
        }
    }

    private void printScore() {
        System.out.println("You : " + userWins + " wins || Computer : " + computerWins + " wins || Draws : " + draws);
    }

    private boolean askForReplay(Scanner scanner) {
        while (true) {
            System.out.println("Do you want to play another round ? push - Y or N");
            String answer = scanner.next().toLowerCase();
            if (answer.equalsIgnoreCase("y")) {
                return true;
            } else if (answer.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter Y  or N");
            }
        }

    }


    public static void main(String[] args) {
        Main game = new Main();
        game.start();


    }
}