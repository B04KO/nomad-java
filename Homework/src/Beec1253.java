import java.util.Scanner;

public class Beec1253 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String encoded = scanner.nextLine();
            int shift = scanner.nextInt();
            scanner.nextLine();

            String decoded = "";
            for (int j = 0; j < encoded.length(); j++) {
                char c = encoded.charAt(j);
                char decodedChar = (char) ((c - 'A' - shift + 26) % 26 + 'A');
                decoded += decodedChar;
            }

            System.out.println(decoded);
        }
    }
}
