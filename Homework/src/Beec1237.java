import java.util.Scanner;

public class Beec1237 {
    public static int IloveSpaggety(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int longest = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    longest = Math.max(longest, dp[i][j]);
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s1 = scanner.nextLine().trim();
            if (!scanner.hasNextLine()) break;
            String s2 = scanner.nextLine().trim();
            System.out.println(IloveSpaggety(s1, s2));
        }
        scanner.close();
    }
}
