import java.util.Scanner;

public class Main {


    static String playerOne;
    static String playerTwo;
    static int[][] battleFieldPlayerOne = new int[10][10];
    static int[][] battleFieldPlayerTwo = new int[10][10];

    static int[][] monitorPlayerOne = new int[10][10];
    static int[][] monitorPlayerTwo = new int[10][10];


    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Player # 1 enter your name");
        playerOne = scanner.nextLine();
        System.out.println("Player # 2 enter your name");
        playerTwo = scanner.nextLine();
        System.out.println(playerOne + " place your ships on the board");
        placeShips(playerOne, battleFieldPlayerOne);
        placeShips(playerTwo, battleFieldPlayerTwo);
        do {
            makeTurn(playerOne, monitorPlayerOne, battleFieldPlayerTwo);
            makeTurn(playerTwo, monitorPlayerTwo, battleFieldPlayerOne);
        }
        while (!isEndGame());
    }

    public static void placeShips(String playerName, int[][] battleField) {

        int deck = 4;
        while (deck >= 1) {

            System.out.println(playerName + " place your " + deck + " deck ship  on the board");

            drawField(battleField);

            System.out.println("Enter OX coordinate");
            int x = scanner.nextInt();
            System.out.println("Enter OY coordinate");
            int y = scanner.nextInt();
            System.out.println("choose direction 1 - Vertical ,\n2 - Horisontal");
            int rotation = scanner.nextInt();

            for (int i = 0; i < deck; i++) {
                if (rotation == 1) {
                    battleField[x + i][y - 1] = 1;
                } else {
                    battleField[x][y - 1 + i] = 1;
                }
            }

            deck--;

        }
        drawField(battleField);
    }   // <--- розміщення кораблів

    public static void drawField(int[][] battleFieldPlayer) {   // малює розташування для різних гравців

        char first = 'A';
        for (int i = 0; i < 9; i++) {
            if (i == 0) System.out.print("  " + first++ + "  ");
            System.out.print(first++ + "  ");
        }

        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.print(i);

            for (int j = 0; j < 10; j++) {
                if (battleFieldPlayer[i][j] == 0) {
                    System.out.print(" ~ ");
                } else {
                    System.out.print(" # ");
                }
            }
            System.out.println();
        }
    }  // <--- малює вивід поля

    public static void makeTurn(String playerName, int[][] monitorPlayer, int[][] battleFieldPlayer) {
        boolean turn = true;
        while (turn) {

            System.out.println(playerName + " make you turn");
            char first = 'A';
            for (int i = 0; i < 9; i++) {
                if (i == 0) System.out.print("  " + first++ + "  ");
                System.out.print(first++ + "  ");
            }

            System.out.println();

            for (int i = 0; i < 10; i++) {
                System.out.print(i);

                for (int j = 0; j < 10; j++) {
                    if (monitorPlayer[i][j] == 0) {
                        System.out.print(" ~ ");
                    } else if (monitorPlayer[i][j] == 1) {
                        System.out.print(" * ");
                    } else {
                        System.out.print(" X ");
                    }
                }
                System.out.println();
            }

            System.out.println("Enter OX coordinate for shoot");
            int x = scanner.nextInt();
            System.out.println("Enter OY coordinate for shoot");
            int y = scanner.nextInt();

            if (battleFieldPlayer[x][y] == 1) {
                System.out.println("Hit and make you turn againe");
                monitorPlayer[x][y] = 2;
            } else {
                System.out.println("Miss next players turn");
                monitorPlayer[x][y] = 1;
                turn = false;
            }


        }
    }

    public static boolean isEndGame() {
        int couterPlayerOne = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (monitorPlayerOne[i][j] == 2) {
                    couterPlayerOne++;
                }
            }
        }
        if (couterPlayerOne == 10) {
            System.out.println("Player One Win");
            return true;
        }


        int counterPlayerTwo = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (monitorPlayerTwo[i][j] == 2) {
                    counterPlayerTwo++;
                }
            }
        }
        if (counterPlayerTwo == 10) {
            System.out.println("Player One Win");
            return true;
        }
        return false;
    }
}