import java.util.Scanner;

public class beec1138 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();

        int[] digitCount = new int[10];

        for (int i = A; i <= B; i++) {
            String number = Integer.toString(i);

            for (char c : number.toCharArray()) {
                digitCount[c - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(digitCount[i]);
            if (i < 9) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}