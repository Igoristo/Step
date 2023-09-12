import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    StepTracker(Scanner scan) { // Конструктор
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void changeStepGoal() { // Планируемое число шагов
        System.out.println("Введите планируемое число шагов.");
        int num = scanner.nextInt();
        if (num < 1) {
            System.out.println("Ввели меньше 1 шага");
        } else {
            goalByStepsPerDay = num;
            System.out.println("Запланировано пройти " + goalByStepsPerDay + " шагов.");
        }
    }

    void addNewNumberStepsPerDay() { // Количество шагов в день месяца
        System.out.println("Введите номер месяца");
        // ввод и проверка номера месяца
        int numMonth = scanner.nextInt();
        if (numMonth > 12 || numMonth < 1) {
            System.out.println("Такого месяца не существует.");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        // ввод и проверка дня
        int numDay = scanner.nextInt();
        if (numDay > 30 || numDay < 1) {
            System.out.println("Такого дня не существует.");
            return;
        }

        System.out.println("Введите количество шагов");
        // ввод и проверка количества шагов
        int numStep = scanner.nextInt();
        if (numStep < 1) {
            System.out.println("Ввели меньше 1 шага");
            return;
        }
        // Получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[numMonth - 1];
        // Сохранение полученных данных
        monthData.days[numDay - 1] = numStep;
    }

    void printStatistic() {
        System.out.println("Введите номера месяца");
        // ввод и проверка номера месяца
        int numMonth = scanner.nextInt();
        if (numMonth > 12 || numMonth < 1) {
            System.out.println("Такого месяца не существует.");
            return;
        }

        MonthData monthData = monthToData[numMonth - 1]; // получение соответствующего месяца
        int sumSteps = monthData.sumStepsFromMonth(); // получение суммы шагов за месяц
        monthData.printDaysAndStepsFromMonth();  // вывод общей статистики по дням
        System.out.println("За месяц пройдено " + sumSteps + " шагов.");        // вывод суммы шагов за месяц
        System.out.println("Наибольшее число шагов в день " + monthData.maxSteps()); // вывод максимального пройденного количества шагов за месяц
        System.out.println("В среднем пройдено " + (sumSteps / 30) + " в день.");        // вывод среднего пройденного количества шагов за месяц
        System.out.println("За месяц пройдено " + converter.convertToKm(sumSteps) + " км.");        // вывод пройденной за месяц дистанции в км
        System.out.println("За месяц сожгли " + converter.convertStepsToKilocalories(sumSteps) + " килоколорий."); // вывод количества сожжённых килокалорий за месяц
        System.out.println("Лучшая серия за месяц " + monthData.bestSeries(goalByStepsPerDay) + " дней подряд.");  // вывод лучшей серии
        System.out.println(); //дополнительный перенос строки
    }
}
