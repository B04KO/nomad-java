public class Pract_6 {
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        double fahrenheit = 98.6;
        double celsius = fahrenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + " фарингейт равен: " + celsius + " цельсию ");
    }
}
