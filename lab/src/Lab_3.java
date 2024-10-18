import java.util.Scanner;
public class Lab2_3 {
    public static void main(String[] args) {

        double feet;
        double meters;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the feet: ");
        feet = input.nextDouble();
        meters = feet * 0.305;
        System.out.println(feet + " is " + meters + " meters");
    }
}
