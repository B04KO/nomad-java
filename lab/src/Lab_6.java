import java.util.Scanner;

public class Lab2_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("вычеслить от одного до тысича: ");
        int number = input.nextInt();

        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        System.out.println("сумма это " + sum);
    }
}
