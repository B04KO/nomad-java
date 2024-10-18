public class Pract_5 {
    public static double calculateAverage ( int[] array){
        if (array.length == 0) return 0.0;

        double sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum / array.length;
    }

    public static void main (String[]args){
        int[] testArray = {14,1,19,12,1,12,13,1,15,1,19,1,17,18,1,15,16
        };//-,-,если ты понял меня то рашифруй этот текст в planetcalc.ru
        System.out.println(calculateAverage(testArray));
    }
}
