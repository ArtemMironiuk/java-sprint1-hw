import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {

    private int targetSteps = 10000; //Целевое кол-во шагов по умолчанию

    private final HashMap<Integer, MonthData> monthToData = new HashMap<>();
    Converter converter = new Converter();
    Scanner scanner = new Scanner(System.in);

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    /**
     * Сохраняет количество шагов за день.
     * Предполагаем в каждом месяце 30 дней.
     */
    public void saveNumberSteps() {
        System.out.println("Введите номер месяца:");
        int monthNumber = scanner.nextInt();
        System.out.println("Введите номер дня, от 1 до 30:");
        int dayNumber = scanner.nextInt();
        System.out.println("Введите количество шагов за день:");
        int numberSteps = scanner.nextInt();
        System.out.println("Сохранили шаги " + numberSteps);
        MonthData stepsOfMonth = monthToData.get(monthNumber);
        stepsOfMonth.setMonthData(dayNumber, numberSteps);
    }

    /**
     * Вывод статистики за месяц
     */
    public void printStatisticsMonth() {
        System.out.println("Введите месяц за который хотите посмотреть статистику:");
        int month = scanner.nextInt();
        System.out.println("Вывод статистики за месяц");
        if (monthToData.containsKey(month)) {
            MonthData steps = monthToData.get(month);
            for (int i = 0; i < steps.stepsNumberOfDay.length; i++) {
                int step = steps.getMonthData(i);
                if (i != steps.stepsNumberOfDay.length - 1) {
                    System.out.print((i + 1) + " день: " + step + ", ");
                } else {
                    System.out.print((i + 1) + " день: " + step);
                }
            }
        }
        System.out.println("\nОбщее количество шагов: " + getCountStepOfMonth(month));
        System.out.println("Максимальное пройденное количество шагов в месяце: " + getMaxNumberStep(month));
        System.out.println("Среднее количество шагов: " + getAverageStep(month));
        System.out.println("Пройденная дистанция (в км): " + getCalculationDistance(month));
        System.out.println("Количество сожжённых килокалорий: " + getCaloriesBurned(month));
        System.out.println("Лучшая серия: " + getBestSeries(month));
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
            if (maxSteps < step) { //Условие для нахождения максимального количества шагов
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
        return (double) getCountStepOfMonth(month) / 30;
    }

    /**
     * Возвращает пройденную дистанцию
     * @param month
     * @return
     */
    public double getCalculationDistance(int month) {
        return converter.calculationDistance(getCountStepOfMonth(month));
    }

    /**
     * Возвращает количество сожженных калорий
     * @param month
     * @return
     */
    public double getCaloriesBurned(int month) {
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
            if (step >= targetSteps) { //Условие для подсчета лучшей серии дней
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
     */
    public void setNumberSteps() {
        System.out.println("Введите цель по количеству шагов в день:");
        int targetNumberSteps = scanner.nextInt();
        if (targetNumberSteps < 0) {
            System.out.println("Невозможно ввести отрицательное количество шагов!");
        } else {
            this.targetSteps = targetNumberSteps;
            System.out.println("Сохранили количество шагов: " + this.targetSteps);
        }
    }
}
