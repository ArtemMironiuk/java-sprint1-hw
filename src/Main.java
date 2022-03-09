import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        int userInput = 0;

        Scanner scanner = new Scanner(System.in);
        printMenu();
        while (true) {
            while (!scanner.hasNextInt()) { //Проверка ввода на число
                scanner.next();
                System.out.println("Неверный формат команды!");
                printMenu();
            }
            userInput = scanner.nextInt();
            if (userInput == 1) {
                stepTracker.saveNumberSteps();
            } else if (userInput == 2) {
                stepTracker.printStatisticsMonth();
            } else if (userInput == 3) {
                stepTracker.setNumberSteps();
            } else if (userInput == 0) {
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
            printMenu();
        }
        System.out.println("Приложение закрылось.");
    }
    /**
     * Вывод меню команд
     */
    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}