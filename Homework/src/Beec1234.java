import java.util.Scanner;

public class Beec1234 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;

        while (in.hasNextLine()) {
            str = in.nextLine();
            int j = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c != ' ') {
                    j++;
                    if (j % 2 == 1) {
                        result.append(Character.toUpperCase(c));
                    } else {
                        result.append(Character.toLowerCase(c));
                    }
                } else {
                    result.append(" ");
                }
            }

            System.out.println(result);
        }

        in.close();
    }
}
