import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        int userInput = 0;

        Scanner scanner = new Scanner(System.in);
        boolean entry = true;
        while (entry) {
            printMenu();
            while (!scanner.hasNextInt()) { //Проверка ввода на число
                scanner.next();
                System.out.println("Неверный формат команды!");
                printMenu();
            }
            userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    stepTracker.saveNumberSteps();
                    break;
                case 2:
                    stepTracker.printStatisticsMonth();
                    break;
                case 3:
                    stepTracker.setNumberSteps();
                    break;
                case 0:
                    entry = false;
                    break ;
                default:
                    System.out.println("Извините, такой команды пока нет.");
                    break;
            }
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