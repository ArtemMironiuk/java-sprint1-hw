import java.util.HashMap;
import java.util.Map;

public class StepTracker {

   public int targetSteps = 10000;           //Целевое кол-во шагов по умолчанию
   public int totalNumberStepsOfMonth = 0;    //Общее количество шагов за месяц
   private HashMap<Integer, MonthData> monthToData = new HashMap<>();
   Converter converter = new Converter(totalNumberStepsOfMonth);


    public StepTracker(){
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    /**
     * Сохраняет цель
     * @param targetNumberSteps
     */
    public void setNumberSteps(int targetNumberSteps) {
            if (targetNumberSteps < 0) {
                System.out.println("Невозможно ввести отрицательное количество шагов!");
            } else if (targetSteps != targetNumberSteps) {
                targetSteps = targetNumberSteps;
                System.out.println("Сохранили количество шагов: " + targetNumberSteps);
            }
    }

    /**
     * Вывод статистики за месяц
     * @param month
     */
    public void printStatisticsMonth(int month) {
        System.out.println("Вывод статистики за месяц");
        if(monthToData.containsKey(month)) {
            int maxSteps = 0;
            int day = 0;
            MonthData steps = monthToData.get(month);
            for (int i = 0; i < 30; i++) {
                int v = steps.getMonthData(i+1);
                System.out.print((i+1) + " день: " + v + ", " );

                totalNumberStepsOfMonth += v;

                if(maxSteps< v){
                    maxSteps = v;
                }
                if(v >= targetSteps){
                    day++;
                }

            }
            System.out.println("Общее количество шагов: " + totalNumberStepsOfMonth);
            System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
            System.out.println("Среднее количество шагов: " + totalNumberStepsOfMonth/30);
            System.out.println("Пройденная дистанция (в км): " + converter.calculationDistance(totalNumberStepsOfMonth));
            System.out.println("Количество сожжённых килокалорий: " + converter.caloriesBurned(totalNumberStepsOfMonth));
            System.out.println("Лучшая серия: " + day);


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
//    int saveNumberSteps(String month, Integer numberSteps,int dayNumber){
//        if (map.containsKey(month)){
//            Integer[] steps = map.get(month);
//            steps[dayNumber - 1] = numberSteps;
//            map.put(month, steps);
//
//        } else {
//            Integer[] steps = new Integer[30];
//            steps[dayNumber - 1] = numberSteps;
//            map.put(month,steps);
//        }
//
//        return saveNumberSteps(month,numberSteps,dayNumber);
//    }
//
//    void printStatisticsMonth(String month){
//        if(map.containsKey(month)){
//            for (String monthM: map.keySet()) {
//                Integer[] value = map.get(monthM);
//                System.out.println(monthM);
//                for (int i = 0; i < value.length ; i++) {
//                    System.out.println((i+1) + " день: " + value[i]);
//                }
//            }
//        }
//          else {
//            System.out.println("Нет статистики за " + month);
//        }
//    }
}
