import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Поехали!
        Scanner scanner = new Scanner(System.in);


        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1){


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

