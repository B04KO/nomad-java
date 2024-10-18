import java.util.Scanner;

public class Beec1287 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            StringBuilder resp = new StringBuilder();
            boolean flag = false;

            for (char ch : input.toCharArray()) {
                if (Character.isDigit(ch)) {
                    resp.append(ch);
                } else if (ch == 'l') {
                    resp.append('1');
                } else if (ch == 'o' || ch == 'O') {
                    resp.append('0');
                } else if (ch != ' ' && ch != ',') {
                    flag = true;
                    break;
                }
            }

            String result = resp.toString();
            if (flag || result.isEmpty()) {
                System.out.println("error");
            } else {
                try {
                    long num = Long.parseLong(result);
                    if (num > 2147483647) {
                        System.out.println("error");
                    } else {
                        System.out.println(num);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("error");
                }
            }
        }
        scanner.close();
    }
}
