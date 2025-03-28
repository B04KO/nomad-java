// Обобщенный класс Box
class Box<T> {
    private T value;

    // Конструктор для инициализации значения
    public Box(T value) {
        this.value = value;
    }

    // Метод для получения значения
    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(123);
        System.out.println(intBox.getValue()); // Вывод: 123

        Box<String> strBox = new Box<>("Hello");
        System.out.println(strBox.getValue()); // Вывод: Hello
    }
}
