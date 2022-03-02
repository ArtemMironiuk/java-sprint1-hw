public class MonthData {
    int [] stepsNumberOfDay;

    public MonthData() {
        stepsNumberOfDay = new int[30];

    }

    void monthData(int dayNumber, int numberSteps) {
            stepsNumberOfDay[dayNumber - 1] = numberSteps;
    }

}
