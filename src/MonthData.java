public class MonthData {
    int [] stepsNumberOfDay;

    public MonthData() {
        stepsNumberOfDay = new int[30];

    }

    public void setMonthData(int dayNumber, int numberSteps) {
            stepsNumberOfDay[dayNumber - 1] = numberSteps;
        //for (int i = 0; i < stepsNumberOfDay.length; i++) {
            //System.out.print(stepsNumberOfDay[i] + " ; ");
        //}
    }

    public int getMonthData(int dayNumber) {
        int numberSteps = stepsNumberOfDay[dayNumber -1];

        return numberSteps;
    }

}
