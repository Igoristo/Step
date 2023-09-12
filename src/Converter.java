
public class Converter {
    int convertToKm(int steps) {
        int stepCm = 75;  // один шаг равен 75 см
        int cmPerKm = 100000;  // В 1 километр = 100 000 сантиметров
        int km = steps * stepCm / cmPerKm;
        return km;
    }

    int convertStepsToKilocalories(int steps) {
        int stepCalories = 50;  // Один шаг сжигант 50 калорий
        int kilocalories = 1000;  // 1 килокалория = 1 000 калорий
        int kc = steps * stepCalories / kilocalories;
        return kc;
    }
}
