import java.util.Scanner;


public class Beec1028 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }
            while (b != 0) {
                int temp = a;
                a = b;
                b = temp % b;
                System.out.println(a);
            }
        }
    }
}