import java.util.Scanner;

public class Main {


    public static final String EMPTY = "   ",
            FIGURE_X = " X ",
            FIGURE_O = " O ";

    public static final int ROWS = 3,
            COLUMN = 3;

    public static String[][] gameField = new String[ROWS][COLUMN];

    public static int statusOfTheGame;

    public static final int STATUS_GAME_CONTINUES = 0,
            STATUS_X_WIN = 1,
            STATUS_O_WIN = 2,
            STATUS_DRAW = 3;

    public static String player;

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        startGame();
        do {
            getPlayerInput();
            analisisOfTheStatusGame();
            displayTheGameField();
            if(statusOfTheGame == STATUS_X_WIN){
                System.out.println(" X --- Win !!!");
            }
            else if(statusOfTheGame == STATUS_O_WIN){
                System.out.println("O --- Win !!!");
            }
            else if(statusOfTheGame == STATUS_DRAW){
                System.out.println("Draw !!!");
            }
            player = (player == FIGURE_X) ? FIGURE_O : FIGURE_X;
        }
        while (statusOfTheGame == STATUS_GAME_CONTINUES);

    }


    public static void startGame() {                // Створемо порожнє поле і хто починає
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMN; j++) {
                gameField[i][j] = EMPTY;
            }
        }
        player = FIGURE_X;
        displayTheGameField();
    }

    public static void getPlayerInput() {           // куди гравець ставить свою фігуру
        boolean correctInput = false;

        do {
            System.out.println("Гравець " + player + " Ведіть номер комірки у форматі рядок і стовпчик від 1-3 через пробіл");
            int row = in.nextInt() - 1;
            int column = in.nextInt() - 1;
            if (row >= 0 && row < ROWS && column >= 0 && column < COLUMN && gameField[row][column] == EMPTY) {
                gameField[row][column] = player;
                correctInput = true;
            } else {
                System.out.println((row + 1) + " " + (column + 1) + " Нажаль не є коректним записом комірки від 1-3 через пробіл");
            }
        }
        while (!correctInput);
    }

    public static void analisisOfTheStatusGame() {               // хтось переміг чи нічия чи гра триває
        String winner = findAWinner();
        if (winner.equals(FIGURE_X)) {
            statusOfTheGame = STATUS_X_WIN;
        } else if (winner.equals(FIGURE_O)) {
            statusOfTheGame = STATUS_O_WIN;
        } else if (fillingTheGameFiels()) {
            statusOfTheGame = STATUS_DRAW;
        } else {
            statusOfTheGame = STATUS_GAME_CONTINUES;
        }
    }

    public static boolean fillingTheGameFiels() {               //    чи є вільне місце
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (gameField[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String findAWinner() {
        int count;

        for (int i = 0; i < ROWS; i++) {                        // перевірка в рядках
            count = 0;
            for (int j = 0; j < COLUMN; j++) {
                if (gameField[i][j] != EMPTY && gameField[i][0] == gameField[i][j]) {
                    count++;
                }
            }
            if (count == 3) {
                return gameField[i][0];
            }
        }

        for (int i = 0; i < COLUMN; i++) {                  // перевірка в стовпчиках
            count = 0;
            for (int j = 0; j < ROWS; j++) {
                if (gameField[0][i] != EMPTY && gameField[0][i] == gameField[j][i]) {
                    count++;
                }
            }
            if (count == 3) {
                return gameField[0][i];
            }
        }
        // перевірка в діагоналях
        if (gameField[0][0] != EMPTY && gameField[0][0] == gameField[1][1] && gameField[0][0] == gameField[2][2]) {
            return gameField[0][0];
        }

        if (gameField[2][0] != EMPTY && gameField[2][0] == gameField[1][1] && gameField[2][0] == gameField[0][2]) {
            return gameField[2][0];
        }
        return EMPTY;
    }

    public static void displayTheGameField() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMN; j++) {
                System.out.print(gameField[i][j]);
                if (j != COLUMN - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i != ROWS - 1) {
                System.out.println("-----------");
            }
        }
    }
}