import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Поехали!
        Scanner scanner = new Scanner(System.in);

        StepTracker stepTracker = new StepTracker();

        HashMap<String, Integer[]> map = new HashMap<>();
        Integer[] numberStepsDay = new Integer[30];
        map.put("Январь", numberStepsDay);
        map.put("Февраль", numberStepsDay);
        map.put("Март", numberStepsDay);
        map.put("Апрель", numberStepsDay);
        map.put("Май", numberStepsDay);
        map.put("Июнь", numberStepsDay);
        map.put("Июль", numberStepsDay);
        map.put("Август", numberStepsDay);
        map.put("Сентябрь", numberStepsDay);
        map.put("Октябрь",numberStepsDay );
        map.put("Ноябрь", numberStepsDay);
        map.put("Декабрь", numberStepsDay);

//        for (int i = 0; i < numberStepsDay.length; i++) {
//            numberStepsDay[i] = numberSteps;
//        }


        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1){
                System.out.println("Введите месяц");
                String month = scanner.next();
                System.out.println("Введите количество шагов за день");
                int numberSteps = scanner.nextInt();
                stepTracker.saveNumberSteps(month,numberSteps);


            } else if (command == 2){


            } else if (command == 3) {


            } else if (command == 4) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }

        }


    }
    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");

    }
}

