import java.util.HashMap;

public class StepTracker {

   private int targetSteps = 10000;
   private HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();

//    public StepTracker(){
//        for (int i = 0; i < 12; i++) {
//            monthToData.put(i, new MonthData());
//        }
//    }

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
            for (Integer monthM : monthToData.keySet()) {
                //MonthData value = monthToData.get(monthM);
                System.out.println(monthM);
                for (int i = 0; i < 30; i++) {

                    System.out.println((i + 1) + " день: " + monthToData);
                }
            }
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
        if (stepsOfMonth == null){
            stepsOfMonth = new MonthData();
            monthToData.put(monthNumber, stepsOfMonth);
        }
        stepsOfMonth.monthData(dayNumber,numberSteps);
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
