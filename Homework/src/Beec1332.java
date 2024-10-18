import java.util.Scanner;

public class Beec1332 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            String number = s.nextLine();
            if (number.length() == 5) {
                System.out.println(3);
            } else if (number.equals("two") || hd(number, "two") == 1) {
                System.out.println(2);
            } else if (number.equals("one") || hd(number, "one") == 1) {
                System.out.println(1);
            }
        }
    }

    public static int hd(String number, String input) {
        int distance = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != input.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
