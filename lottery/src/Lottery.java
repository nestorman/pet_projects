import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lottery {
    static String[] clientsNumbers;

    public static void main(String[] args) {
        start();
        int[] randomNumbers = randomArray();
        System.out.println(Arrays.toString(randomNumbers));
        resultOfLottery(randomNumbers);


    }

    public static void start() {

        while (true) {
            System.out.println("Enter six numbers between 1 and 54, separated by commas !");
            Scanner scanner = new Scanner(System.in);
            String clientEntersNumbers = scanner.nextLine();
            clientsNumbers = clientEntersNumbers.split(",");

            if (clientsNumbers.length != 6) {
                System.out.println("You must enter exactly six numbers. Please try again");
                continue;
            }
            boolean valid = true;

            for (String string : clientsNumbers) {
                try {
                    int num = Integer.parseInt(string);
                    if (num < 1 || num > 54) {
                        System.out.println("Number must be between 1 and 54. Please enter valid numbers");
                        valid = false;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input ! Please enter valid numbers ");
                    valid = false;
                    break;
                }
            }
            if (valid) {
                scanner.close();
                break;
            }
        }


    }

    public static int[] randomArray() {
        Random random = new Random();
        int[] randomArray = new int[6];

        for (int i = 0; i < randomArray.length; i++) {
            int checkNumber;
            boolean matches;

            do {
                matches = false;
                checkNumber = random.nextInt(54) + 1;

                for (int a : randomArray) {
                    if (a == checkNumber) {
                        matches = true;
                        break;
                    }
                }
            } while (matches);

            randomArray[i] = checkNumber;
        }
        return randomArray;
    }

    public static void resultOfLottery(int[] randomNumbers) {
        int matchesWithClientsNumbers = 0;
        StringBuilder resultNumbers = new StringBuilder();
        int[] matchesNumbers;
        for (int i = 0; i < clientsNumbers.length; i++) {
            for (int j = 0; j < randomNumbers.length; j++) {
                if (Integer.parseInt(clientsNumbers[i]) == randomNumbers[j]) {
                    matchesWithClientsNumbers++;
                    resultNumbers.append(randomNumbers[j]);
                }
            }
        }
        System.out.println("The quantity of matched numbers is " + matchesWithClientsNumbers);
        System.out.println("The matching numbers are " + resultNumbers);
    }
}
