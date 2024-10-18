import java.util.Scanner;
import java.math.BigInteger;

public class Beec1120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            int D = Integer.parseInt(parts[0]);
            String N = parts[1];

            if (D == 0 && N.equals("0")) {
                break;
            }

            String faultyDigit = String.valueOf(D);
            String result = N.replace(faultyDigit, "");

            if (result.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(new BigInteger(result));
            }
        }
        scanner.close();
    }
}
