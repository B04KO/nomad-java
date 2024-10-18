import java.util.Scanner;

public class Beec1138 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            if (A == 0 && B == 0) {
                break;
            }

            int[] digitCount = new int[10];

            for (int i = A; i <= B; i++) {
                String number = Integer.toString(i);
                for (char digit : number.toCharArray()) {
                    digitCount[digit - '0']++;
                }
            }

            for (int i = 0; i < 10; i++) {
                System.out.print(digitCount[i] + (i < 9 ? " " : "\n"));
            }
        }
    }
}
