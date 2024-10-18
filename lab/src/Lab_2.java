import java.util.Scanner;

public class Lab2_2 {
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Введите радиус: ");
    double radius = input.nextDouble();
    double length = input.nextDouble();

    double area = Math.PI * radius * radius;
    double volume = area * length;

    System.out.println("Область это\n" + area);
    System.out.println("Обьем это\n" + volume);
   }
}
