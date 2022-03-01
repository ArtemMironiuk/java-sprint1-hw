import java.util.HashMap;

public class StepTracker {
    HashMap<String, Integer[]> map;

    StepTracker(){
        map = new HashMap<>();
    }
    int saveNumberSteps(String month, Integer numberSteps){
        if (map.containsKey(month)){
            Integer[] steps = map.get(month);
            steps[0] = numberSteps;

        }
        return saveNumberSteps(month,numberSteps);
    }
}
