public class Converter {

    /**
     * Вычисление пройденной дистанции за месяц в километрах
     * 1 шаг = 75 см
     * @param steps
     * @return
     */
    public double calculationDistance(int steps){
        return steps * 0.75 / 1000;
    }

    /**
     * Вычисление потраченных киллокалорий за месяц
     * 1 шаг - 50 калорий
     * 1 килокалория = 1000 калорий
     * @param steps
     * @return
     */
    public double caloriesBurned(int steps){
        return steps * 50 / 1000;
    }
}
