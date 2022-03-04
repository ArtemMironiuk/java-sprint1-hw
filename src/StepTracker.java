import java.util.HashMap;

public class StepTracker {

    private int targetSteps = 10000;                  //Целевое кол-во шагов по умолчанию
    public int maxSteps = 0;                         //Максимальное количество шагов в месяц за день
    public int dayD = 0;                             //Серия из дней

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
            int day = 0;
            MonthData steps = monthToData.get(month);
            for (int i = 0; i < steps.stepsNumberOfDay.length; i++) {
                int v = steps.getMonthData(i);
                if(i != steps.stepsNumberOfDay.length -1){
                    System.out.print((i+1) + " день: " + v + ", " );
                }else {
                    System.out.print((i+1) + " день: " + v);
                }

                if(v >= targetSteps){                         //Условие для подсчета лучшей серии дней
                    day++;
                }
                else{
                    if(dayD < day){
                        dayD = day;
                        day = 0;
                    }
                }

            }

        }
    }

    public int countStepOfMonth(int month) {
        int totalNumberStepsOfMonth = 0;
        MonthData steps = monthToData.get(month);            //как то зайти в массив
        for (int i = 0; i < steps.stepsNumberOfDay.length; i++) {
            int step = steps.getMonthData(i);
            totalNumberStepsOfMonth += step;
        }
        return totalNumberStepsOfMonth;
    }

    public double averageStep(int month) {
        return (double)  countStepOfMonth(month)/ 30;
    }

    public int maxNumberStep(int month) {
        int maxSteps = 0;
        MonthData steps = monthToData.get(month);           //как то зайти в массив
        for (int i = 0; i < steps.stepsNumberOfDay.length; i++) {
            int step = steps.getMonthData(i);
            if (maxSteps < step) {                               //Условие для нахождения максимального количества шагов
                maxSteps = step;
            }
        }
        return maxSteps;
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
