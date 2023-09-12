import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            int i = scanner.nextInt();

            if (i == 1) {
                stepTracker.addNewNumberStepsPerDay();

            } else if (i == 2) {
                stepTracker.changeStepGoal();

            } else if (i == 3) {
                stepTracker.printStatistic();

            } else if (i == 0) {
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести пройденое количество шагов за день.");
        System.out.println("2 - Ввести цель. (Количество шагов в день.)");
        System.out.println("3 - Вывести статистику за месяц.");
        System.out.println("0 - Выход");
    }
}
