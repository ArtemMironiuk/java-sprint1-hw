public class MonthData {
    Integer[] stepsNumberOfDay;

    public MonthData() {
        stepsNumberOfDay = new Integer[30];

    }

    void monthData(int dayNumber, int numberSteps) {
            stepsNumberOfDay[dayNumber - 1] = numberSteps;
    }

}
