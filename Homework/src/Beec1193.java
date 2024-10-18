import java.util.Scanner;

public class Beec1193 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();  

        for (int i = 1; i <= N; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            String number = parts[0];
            String type = parts[1];

            System.out.println("Case " + i + ":");

            if (type.equals("bin")) {
                int decimal = Integer.parseInt(number, 2);
                System.out.println(decimal + " dec");
                System.out.println(Integer.toHexString(decimal) + " hex");
            } else if (type.equals("dec")) {
                int decimal = Integer.parseInt(number);
                System.out.println(Integer.toHexString(decimal) + " hex");
                System.out.println(Integer.toBinaryString(decimal) + " bin");
            } else if (type.equals("hex")) {
                int decimal = Integer.parseInt(number, 16);
                System.out.println(decimal + " dec");
                System.out.println(Integer.toBinaryString(decimal) + " bin");
            }

            System.out.println();
        }
    }
}
