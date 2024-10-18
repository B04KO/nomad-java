public class Pract_10 {

    public static int[] squareArray(int[] array) {
        int[] squaredArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            squaredArray[i] = array[i] * array[i];
        }
        return squaredArray;
    }

    public static void main(String[] args) {
        int[] originalArray = {3, 5, 6, 9, 7};
        int[] resultArray = squareArray(originalArray);

        for (int square : resultArray) {
            System.out.print(square + " ");
        }
    }
}
