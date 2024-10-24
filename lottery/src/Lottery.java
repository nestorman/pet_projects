import java.util.Random;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        start();
        randomArray();

        for (int a : randomArray()) {
            System.out.print(a + " ");
        }


    }

    public static void start(){
        System.out.println("Enter six numbers between 1 and 54, separated by commas !");
        Scanner scanner = new Scanner(System.in);
        String clientEntersNumbers = scanner.nextLine();
        scanner.close();
        String[] clientsNumbers = clientEntersNumbers.split(",");
    }

    public static int[] randomArray() {
        Random random = new Random();
        int[] randomArray = new int[6];

        for (int i = 0; i < randomArray.length; i++) {
            int checkNumber;
            boolean matches;

            do {
                matches = false;
                checkNumber = random.nextInt(55);

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

    public static void reaultOfLottery(){
        int matchesWithClientsNumbers = 0;
        int a;
        System.out.println("hfjhsjsd");
        int [] matchesNumbers;
//        for (int i = 0; i <  i++) {
//
//        }
    }
}
