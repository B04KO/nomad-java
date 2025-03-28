public class LeetCode214 {
    public String shortestPalindrome(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        int[] lps = new int[combined.length()];
        for (int i = 1, j = 0; i < combined.length(); i++) {
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        int prefixLength = lps[combined.length() - 1];
        String suffixToAdd = rev.substring(0, n - prefixLength);
        return suffixToAdd + s;
    }
}
