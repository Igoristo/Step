

public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            // Вывод элементов массива в необходимом формате
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            // подсчёт суммы элементов массива days[]
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            // поиск максимального элемента
            if (maxSteps < days[i]) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        int tempSeries = 0;
        for (int i = 0; i < days.length; i++) {
            // поиск максимальной серии
            if (goalByStepsPerDay <= days[i]) {
                currentSeries++;
                tempSeries = currentSeries;
            } else {
                currentSeries = 0;
            }
            if (finalSeries < tempSeries) {
                finalSeries = tempSeries;
            }
        }
        return finalSeries;
    }
}
