public class Converter {
    private StepTracker stepTracker;
    int steps;

    public Converter(int stepTracker) {
        steps = stepTracker;

    }
    public double calculationDistance(int steps){
        double distance = steps * 0.75 / 1000;
        return distance;
    }
    public double caloriesBurned(int steps){
        return steps * 50 / 1000;
    }
}
