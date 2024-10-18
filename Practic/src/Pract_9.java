public class Pract_9 {

    public static int sumArray(int[] array) {
        int sum = 0;

        for (int num : array) {
            sum += num;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] exampleArray = {10,20,30,9 };
        int totalSum = sumArray(exampleArray);

        System.out.println("массccccccив: " + totalSum);
    }
}
