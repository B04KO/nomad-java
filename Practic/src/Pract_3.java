public class Pract_3 {
    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] exampleArray = {3,1,4,1,5,9};
        System.out.println(findMax(exampleArray));
    }
}
