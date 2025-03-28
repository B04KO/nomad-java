// Обобщенный метод для вывода элементов массива
public class GenericMethod {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        printArray(intArray); // Вывод: 1 2 3

        String[] strArray = {"A", "B", "C"};
        printArray(strArray); // Вывод: A B C
    }
}
