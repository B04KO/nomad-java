import java.util.Scanner;
public class Lab2_4 {
    public static void main(String[] args) {

        double pounds;
        double kilograms;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the pounds: ");
        kilograms = input.nextDouble();
        pounds = kilograms * 0.454;
        System.out.println(kilograms + " is " + pounds + " kilograms");
    }
}
