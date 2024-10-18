import java.util.Scanner;

public class Beec1255 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        while (n > 0) {
            n--;
            String s = in.nextLine().toLowerCase();
            int[] arr = new int[26];

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLetter(c)) {
                    arr[c - 'a']++;
                }
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == max) {
                    char ch = (char) (i + 'a');
                    System.out.print(ch);
                }
            }
            System.out.println();
        }
    }
}
