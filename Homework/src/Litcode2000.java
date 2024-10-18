public class Litcode2000 {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx == -1) return word;
        return new StringBuilder(word.substring(0, idx + 1)).reverse().toString() + word.substring(idx + 1);
    }
}
