import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Поехали!
        StepTracker stepTracker = new StepTracker();
       // Converter converter = new Converter();

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();



        while (userInput != 0) {


            if (userInput == 1) {
                System.out.println("Введите номер месяца:");
                int monthNumber = scanner.nextInt();
                System.out.println("Введите номер дня, от 1 до 30:");
                int dayNumber = scanner.nextInt();
                System.out.println("Введите количество шагов за день:");
                int numberSteps = scanner.nextInt();
                stepTracker.saveNumberSteps(monthNumber, dayNumber, numberSteps);


            } else if (userInput == 2) {
                System.out.println("Введите месяц за который хотите посмотреть статистику:");
                int month = scanner.nextInt();
                stepTracker.printStatisticsMonth(month);

            } else if (userInput == 3) {
                System.out.println("Введите цель по количеству шагов в день:");
                int targetNumberSteps = scanner.nextInt();
                stepTracker.setNumberSteps(targetNumberSteps);


            } else if (userInput == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");

            }
            printMenu();
            userInput = scanner.nextInt();

        }
        System.out.println("Программа завершена");


    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");

    }
}

