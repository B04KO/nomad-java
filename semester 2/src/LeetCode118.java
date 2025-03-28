import java.util.ArrayList;
import java.util.List;

class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Создаем треугольник по строкам
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            // Первый элемент в каждой строке всегда 1
            row.add(1);

            // Каждый следующий элемент (кроме первого и последнего) равен сумме двух элементов сверху
            for (int j = 1; j < i; j++) {
                row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            }

            // Последний элемент в каждой строке всегда 1
            if (i > 0) {
                row.add(1);
            }

            // Добавляем текущую строку в треугольник
            triangle.add(row);
        }

        return triangle;
    }
}
