import java.util.Scanner;

public class Beec1551 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < N; i++) {
            String frase = scanner.nextLine().toLowerCase();
            boolean[] letras = new boolean[26];
            int uniqueCount = 0;

            for (char letra : frase.toCharArray()) {
                if (letra >= 'a' && letra <= 'z') {
                    int index = letra - 'a';
                    if (!letras[index]) {
                        letras[index] = true;
                        uniqueCount++;
                    }
                }
            }

            if (uniqueCount == 26) {
                System.out.println(" frase completa");
            } else if (uniqueCount > 12) {
                System.out.println(" frase quase completa");
            } else {
                System.out.println(" frase mal elaborada");
            }
        }

        scanner.close();
    }
}
