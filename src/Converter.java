public class Converter {
    double lengthStep = 0.75 / 1000; //для удобства, переменная сразу переведена в километры
    double kKal = 50 / 1000; //для удобства, переменная сразу переведена в килокалории

    /**
     * Вычисление пройденной дистанции за месяц в километрах
     * по ТЗ 1 шаг = 75 см
     * @param steps
     * @return
     */
    public double calculationDistance(int steps) {
        return steps * lengthStep;
    }

    /**
     * Вычисление потраченных киллокалорий за месяц
     * 1 шаг - 50 калорий
     * 1 килокалория = 1000 калорий
     * @param steps
     * @return
     */
    public double caloriesBurned(int steps) {
        return steps * kKal;
    }
}
