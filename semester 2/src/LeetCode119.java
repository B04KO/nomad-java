import java.util.List;
import java.util.ArrayList;

class LeetCode119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1); // Первая строка всегда начинается с 1

        // Строим строку по формуле (число = число сверху слева + число сверху справа)
        for (int i = 1; i <= rowIndex; i++) {
            // Обновляем текущие элементы строки с конца к началу, чтобы избежать перезаписи
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j - 1) + row.get(j));
            }
            row.add(1); // Добавляем 1 в конец строки
        }

        return row;
    }
}
