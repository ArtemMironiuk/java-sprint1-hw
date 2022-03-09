public class MonthData {
    int[] stepsNumberOfDay;

    public MonthData() {
        stepsNumberOfDay = new int[30];
    }

    /**
     * Заполнение массива шагов
     * @param dayNumber
     * @param numberSteps
     */
    public void setMonthData(int dayNumber, int numberSteps) {
        stepsNumberOfDay[dayNumber - 1] = numberSteps;
    }

    /**
     * Получение значение по определенному дню
     * @param dayNumber
     * @return
     */
    public int getMonthData(int dayNumber) {
        return stepsNumberOfDay[dayNumber];
    }
}
