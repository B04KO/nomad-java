import java.util.Scanner;

public class Beec1170 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            double x = in.nextDouble();
            int days = 0;

            while (x > 1) {
                x /= 2;
                days++;
            }
            System.out.println(days + " dias");
        }
    }
}