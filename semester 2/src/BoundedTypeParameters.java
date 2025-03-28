class Calculator<T extends Number> {
    public double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static void main(String[] args) {
        Calculator<Integer> intCalc = new Calculator<>();
        System.out.println(intCalc.add(5, 10));

        Calculator<Double> doubleCalc = new Calculator<>();
        System.out.println(doubleCalc.add(3.5, 2.5));
    }
}
