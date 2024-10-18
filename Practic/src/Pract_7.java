import java.util.Scanner;

public class Pract_7 {
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ведите: ");
        String original = scanner.nextLine();

        String reversed = reverseString(original);

        System.out.println(original);
        System.out.println(reversed);

        scanner.close();
    }
}
