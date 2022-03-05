import java.util.HashMap;

public class StepTracker {

    private int targetSteps = 10000;                  //Целевое кол-во шагов по умолчанию

    private final HashMap<Integer, MonthData> monthToData = new HashMap<>();
    Converter converter = new Converter();


    public StepTracker(){
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    /**
     * Сохраняет количество шагов за день.
     * Предполагаем в каждом месяце 30 дней.
     * @param monthNumber
     * @param numberSteps
     * @param dayNumber
     */
    public void saveNumberSteps(int monthNumber,int dayNumber, int numberSteps) {
        System.out.println("Сохранили шаги " + numberSteps);
        MonthData stepsOfMonth = monthToData.get(monthNumber);
        stepsOfMonth.setMonthData(dayNumber,numberSteps);
    }

    /**
     * Вывод статистики за месяц
     * @param month
     */
    public void printStatisticsMonth(int month) {
        System.out.println("Вывод статистики за месяц");
        if(monthToData.containsKey(month)) {
            MonthData steps = monthToData.get(month);
            for (int i = 0; i < steps.stepsNumberOfDay.length; i++) {
                int step = steps.getMonthData(i);
                if(i != steps.stepsNumberOfDay.length -1){
                    System.out.print((i+1) + " день: " + step + ", " );
                }else {
                    System.out.print((i+1) + " день: " + step);
                }
            }

        }
    }

    /**
     * Метод возвращает общее количество шагов за месяц
     * @param month
     * @return
     */
    public int getCountStepOfMonth(int month) {
        int totalNumberStepsOfMonth = 0;
        MonthData steps = monthToData.get(month);
        for (int i = 0; i < steps.stepsNumberOfDay.length; i++) {
            int step = steps.getMonthData(i);
            totalNumberStepsOfMonth += step;
        }
        return totalNumberStepsOfMonth;
    }

    /**
     * Метод возвращает максимальное количество шагов в месяц
     * @param month
     * @return
     */
    public int getMaxNumberStep(int month) {
        int maxSteps = 0;
        MonthData steps = monthToData.get(month);
        for (int i = 0; i < steps.stepsNumberOfDay.length; i++) {
            int step = steps.getMonthData(i);
            if (maxSteps < step) {                               //Условие для нахождения максимального количества шагов
                maxSteps = step;
            }
        }
        return maxSteps;
    }

    /**
     * Метод возвращает среднее количество шагов за день
     * @param month
     * @return
     */
    public double getAverageStep(int month) {
        return (double)  getCountStepOfMonth(month)/ 30;
    }

    /**
     * Возвращает пройденную дистанцию
     * @param month
     * @return
     */
    public double getCalculationDistance(int month){

        return converter.calculationDistance(getCountStepOfMonth(month));
    }

    /**
     * Возвращает количество сожженных калорий
     * @param month
     * @return
     */
    public double getCaloriesBurned(int month){
        return converter.caloriesBurned(getCountStepOfMonth(month));
    }

    /**
     * Возвращает лучшую серию: максимальное количество
     * подряд идущих дней, в течение которых количество
     * шагов за день было равно или выше целевого.
     * @param month
     * @return
     */
    public int getBestSeries(int month) {
        int day = 0;
        int dayD = 0;
        MonthData steps = monthToData.get(month);
        for (int i = 0; i < steps.stepsNumberOfDay.length; i++) {
            int step = steps.getMonthData(i);
            if (step >= targetSteps) {                         //Условие для подсчета лучшей серии дней
                day++;
            } else {
                if (dayD < day) {
                    dayD = day;
                    day = 0;
                }
            }
        }
        return dayD;
    }


    /**
     * Сохраняет цель
     * @param targetNumberSteps
     */
    public void setNumberSteps(int targetNumberSteps) {
            if (targetNumberSteps < 0) {
                System.out.println("Невозможно ввести отрицательное количество шагов!");
            } else {
                this.targetSteps = targetNumberSteps;
                System.out.println("Сохранили количество шагов: " + this.targetSteps);
            }
    }
}
